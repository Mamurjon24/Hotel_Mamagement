package org.example.repository;

import org.example.entity.CleaningRoomEntity;
import org.example.entity.EmployerEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        Session session = sessionFactory.openSession();
        Query<EmployerEntity> query = session.createQuery(" FROM EmployerEntity as e where phone =:phone", EmployerEntity.class);
        query.setParameter("phone", phone);
        EmployerEntity employer = query.getSingleResult();
        session.close();
        return employer;
    }
}
