package org.example.repository;

import org.example.entity.BookingEntity;
import org.example.entity.GuestEntity;
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
public class BookingRepository {
    @Autowired
    private SessionFactory sessionFactory;
    public void save(BookingEntity entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    public List<BookingEntity> guestList() {
        Session session = sessionFactory.openSession();
        Query<BookingEntity> query = session.createQuery("FROM BookingEntity");
        List<BookingEntity> list = query.getResultList();



        session.close();
        return list;
    }
}
