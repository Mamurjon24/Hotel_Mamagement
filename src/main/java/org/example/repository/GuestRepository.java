package org.example.repository;

import org.example.entity.CleaningRoomEntity;
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
    public GuestEntity getGuestById(int id) {
        Session session = sessionFactory.openSession();
        GuestEntity guest = session.find(GuestEntity.class, id);
        session.close();
        return guest;
    }
    public List<GuestEntity> guestList() {
        Session session = sessionFactory.openSession();
        Query<GuestEntity> query = session.createQuery("FROM GuestEntity",GuestEntity.class);
        List<GuestEntity> list = query.getResultList();
        session.close();
        return list;
    }
}
