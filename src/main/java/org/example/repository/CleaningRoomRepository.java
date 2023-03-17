package org.example.repository;

import org.example.entity.BookingEntity;
import org.example.entity.CleaningRoomEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CleaningRoomRepository {
    @Autowired
    private SessionFactory sessionFactory;
    public void save(CleaningRoomEntity entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }
}
