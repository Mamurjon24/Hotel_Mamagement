package org.example.repository;

import org.example.entity.CleaningRoomEntity;
import org.example.entity.OutComeEntity;
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
public class OutComeRepository {
    @Autowired
    private SessionFactory sessionFactory;
    public void save(OutComeEntity entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    public List<OutComeEntity> outComeList() {
        Session session = sessionFactory.openSession();
        Query<OutComeEntity> query = session.createQuery("FROM OutComeEntity ");
        List<OutComeEntity> list = query.getResultList();
        session.close();
        return list;
    }
}
