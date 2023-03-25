package org.example.repository;

import org.example.entity.BookingEntity;
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

    public void guestList() {
        try {
            Session session = sessionFactory.openSession();
            Query<BookingEntity> query = session.createQuery("FROM BookingEntity");
            List<BookingEntity> list = query.getResultList();
            list.forEach(System.out::println);
            session.close();
        } catch (Exception e) {
            System.out.println("Not Active Room");
            return;
        }
    }

    public void getBookingListByRoomId(Integer roomId) {
        try {
            Session session = sessionFactory.openSession();
            Query<BookingEntity> query = session.createQuery("FROM BookingEntity AS b WHERE b.room.id =:roomId");
            query.setParameter("roomId", roomId);
            List<BookingEntity> list = query.getResultList();
            list.forEach(System.out::println);
            session.close();
        } catch (Exception e) {
            System.out.println("Not Active Room");
        }
    }

    public void getBookingListByGuestId(Integer guestId) {
        try {
            Session session = sessionFactory.openSession();
            Query<BookingEntity> query = session.createQuery("FROM BookingEntity AS b WHERE b.guest.id =:guestId");
            query.setParameter("guestId", guestId);
            List<BookingEntity> list = query.getResultList();
            list.forEach(System.out::println);
            session.close();
        } catch (Exception e) {
            System.out.println("Not Active Room");
        }
    }
}
