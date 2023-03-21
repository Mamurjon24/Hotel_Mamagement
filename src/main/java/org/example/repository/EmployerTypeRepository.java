package org.example.repository;

import org.example.entity.EmployerEntity;
import org.example.entity.EmployerTypeEntity;
import org.example.entity.ExtraAmenitiesEntity;
import org.example.entity.RoomEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployerTypeRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(EmployerTypeEntity entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    public EmployerTypeEntity getById(int id) {
        Session session = sessionFactory.openSession();
        EmployerTypeEntity entity = session.find(EmployerTypeEntity.class, id);
        session.close();
        return entity;
    }

    public List<EmployerTypeEntity> employerTypeList() {
        Session session = sessionFactory.openSession();
        Query<EmployerTypeEntity> query = session.createQuery("FROM EmployerTypeEntity ",EmployerTypeEntity.class);
        List<EmployerTypeEntity> list = query.getResultList();
        session.close();
        return list;
    }

    public void deleteEmployerType(Integer employerTypeId) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        String hql = "DELETE FROM EmployerTypeEntity WHERE id = :employertype_id";
        Query query = session.createQuery(hql);
        query.setParameter("employertype_id", employerTypeId);
        int result = query.executeUpdate();
        tx.commit();
        session.close();
        System.out.println("Rows affected: " + result);
    }
}
