package org.example.repository;

import org.example.entity.CleaningRoomEntity;
import org.example.entity.GuestEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GuestRepository {
    @Autowired
    private SessionFactory sessionFactory;
    public void save(GuestEntity entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

}
