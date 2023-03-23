package org.example.repository;

import org.example.entity.CleaningRoomEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public List<CleaningRoomEntity> getCleanedRoomList() {
        Session session = sessionFactory.openSession();
        Query<CleaningRoomEntity> query = session.createQuery("FROM CleaningRoomEntity");
        List<CleaningRoomEntity> list = query.getResultList();
        session.close();
        return list;
    }

    public CleaningRoomEntity getById(Integer cleaningRoomId) {
        Session session = sessionFactory.openSession();
        CleaningRoomEntity entity = session.find(CleaningRoomEntity.class, cleaningRoomId);
        session.close();
        return entity;
    }

    public void deleteCleaningRoom(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        String hql = "DELETE FROM CleaningRoomEntity WHERE id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        int result = query.executeUpdate();
        tx.commit();
        session.close();
        System.out.println("Rows affected: " + result);
    }
}
