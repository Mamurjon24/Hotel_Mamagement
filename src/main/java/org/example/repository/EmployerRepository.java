package org.example.repository;

import org.example.entity.CleaningRoomEntity;
import org.example.entity.EmployerEntity;
import org.example.entity.EmployerTypeEntity;
import org.example.entity.RoomEntity;
import org.example.enums.Status;
import org.example.mapper.EmployerTypeMapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployerRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(EmployerEntity entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    public EmployerEntity getEmployerByPhone(String phone) {
        try {
            Session session = sessionFactory.openSession();
            Query<EmployerEntity> query = session.createQuery(" FROM EmployerEntity as e where phone =:phone");
            query.setParameter("phone", phone);
            List<EmployerEntity> employerEntities = query.getResultList();
           // session.close();
            return employerEntities.stream().findAny().get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void employerList() {
        try {
            Session session = sessionFactory.openSession();
            Query<EmployerEntity> query = session.createQuery("FROM EmployerEntity AS e where status=:status");
            query.setParameter("status", Status.ACTIVE);
            List<EmployerEntity> list = query.getResultList();
            list.forEach(System.out::println);
            session.close();
        } catch (Exception e) {
            System.out.println("Not Active Employer");
            return;
        }
    }

    public EmployerEntity getEmployerById(Integer employerId) {
        Session session = sessionFactory.openSession();
        EmployerEntity employer = session.find(EmployerEntity.class, employerId);
        session.close();
        return employer;
    }

    public void changeStatus(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("UPDATE EmployerEntity set status = :status " + "WHERE id = :employer_id");
        query.setParameter("status", Status.NOT_ACTIVE);
        query.setParameter("employer_id", id);
        int result = query.executeUpdate();
        tx.commit();
        session.close();
        System.out.println("Rows affected: " + result);
    }

    public String getEmployerRole() {
        Session session = sessionFactory.openSession();
        Query<EmployerTypeMapper> query = session.createQuery("SELECT  new org.example.mapper.EmployerTypeMapper(t.type)" +
                "FROM EmployerEntity AS e INNER JOIN e.employerType AS t",EmployerTypeMapper.class);
        String result = query.getQueryString();
        session.close();
        return result;
    }
}
