package org.example.repository;

import org.example.entity.ExtraAmenitiesEntity;
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
public class ExtraAmenitiesRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(ExtraAmenitiesEntity entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    public List<ExtraAmenitiesEntity> extraamenitiesList() {
        Session session = sessionFactory.openSession();
        Query<ExtraAmenitiesEntity> query = session.createQuery("FROM ExtraAmenitiesEntity ",ExtraAmenitiesEntity.class);
        List<ExtraAmenitiesEntity> list = query.getResultList();
        session.close();
        return list;
    }
    public ExtraAmenitiesEntity getById(int id) {
        Session session = sessionFactory.openSession();
        ExtraAmenitiesEntity room = session.find(ExtraAmenitiesEntity.class, id);
        session.close();
        return room;
    }

    public void delete(Integer convenientId) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        String hql = "DELETE FROM ExtraAmenitiesEntity WHERE id = :convenient_id";
        Query query = session.createQuery(hql);
        query.setParameter("convenient_id", convenientId);
        int result = query.executeUpdate();
        tx.commit();
        session.close();
        System.out.println("Rows affected: " + result);
    }
}
