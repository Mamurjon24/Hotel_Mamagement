package org.example.repository;

import org.example.entity.EmployerEntity;
import org.example.entity.GuestPasswordEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GuestPasswordRepository {
    @Autowired
    private SessionFactory sessionFactory;
    public void save(GuestPasswordEntity entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }
    public GuestPasswordEntity getGuestByPassword(String passwordSerial) {
        Session session = sessionFactory.openSession();
        Query<GuestPasswordEntity> query = session.createQuery(" FROM GuestPasswordEntity AS g where serialNumber = :passwordSerial");
        query.setParameter("passwordSerial",passwordSerial);
        GuestPasswordEntity guestPassword = query.getSingleResult();
        session.close();
        return guestPassword;
    }
}
