package org.example.repository;

import org.example.entity.CleaningRoomEntity;
import org.example.entity.EmployerEntity;
import org.example.entity.EmployerTypeEntity;
import org.example.entity.RoomEntity;
import org.example.enums.Status;
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
        try{
            Session session = sessionFactory.openSession();
            Query<EmployerEntity> query = session.createQuery(" FROM EmployerEntity as e where phone =:phone");
            query.setParameter("phone", phone);
            EmployerEntity employer = query.getSingleResult();
            session.close();
            return employer;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<EmployerEntity> employerList() {
        Session session = sessionFactory.openSession();
        Query<EmployerEntity> query = session.createQuery("FROM EmployerEntity AS e where status=:status");
        query.setParameter("status", Status.ACTIVE);
        List<EmployerEntity> list = query.getResultList();
        session.close();
        return list;
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
}
