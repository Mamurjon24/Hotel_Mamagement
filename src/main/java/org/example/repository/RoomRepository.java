package org.example.repository;

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
public class RoomRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(RoomEntity entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    public RoomEntity getRoomById(int id) {
        Session session = sessionFactory.openSession();
        RoomEntity room = session.find(RoomEntity.class, id);
        session.close();
        return room;
    }

    public List<RoomEntity> roomList() {
        Session session = sessionFactory.openSession();
        Query<RoomEntity> query = session.createQuery("FROM RoomEntity AS r where status=:status");
        query.setParameter("status", Status.ACTIVE);
        List<RoomEntity> list = query.getResultList();
        session.close();
        return list;
    }

    public void changeStatus(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("UPDATE RoomEntity set status = :status " + "WHERE id = :room_id");
        query.setParameter("status", Status.NOT_ACTIVE);
        query.setParameter("room_id", id);
        int result = query.executeUpdate();
        tx.commit();
        session.close();
        System.out.println("Rows affected: " + result);
    }

    public void updateRoom(RoomEntity room) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("UPDATE RoomEntity set area = :area , status = :status  , price = :price ," +
                " number =:number , floorNumber = :floorNumber ,roomType = :roontype " + "WHERE id = :room_id");
        query.setParameter("status", Status.ACTIVE);
        query.setParameter("area", room.getArea());
        query.setParameter("room_id", room.getId());
        query.setParameter("price", room.getPrice());
        query.setParameter("number", room.getNumber());
        query.setParameter("floorNumber", room.getFloorNumber());
        query.setParameter("roontype", room.getRoomType());
        int result = query.executeUpdate();
        tx.commit();
        session.close();
        System.out.println("Rows affected: " + result);
    }
}
