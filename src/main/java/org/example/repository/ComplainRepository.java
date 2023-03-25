package org.example.repository;

import org.example.entity.ComplainEntity;
import org.example.entity.RoomEntity;
import org.example.enums.ComplainStatus;
import org.example.enums.Status;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComplainRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(ComplainEntity entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    public void complainsList() {
        try {
            Session session = sessionFactory.openSession();
            Query<ComplainEntity> query = session.createQuery("FROM ComplainEntity");
            List<ComplainEntity> list = query.getResultList();
            list.forEach(System.out::println);
            session.close();
        } catch (Exception e) {
            System.out.println("Comlains not found :)");
        }
    }

    public ComplainEntity getComplainById(Integer id) {
        Session session = sessionFactory.openSession();
        ComplainEntity complain = session.find(ComplainEntity.class, id);
        System.out.println(complain);
        session.close();
        return complain;
    }

    public void changeStatus(Integer id, String complainStatus) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("UPDATE ComplainEntity set complainStatus = :status " + "WHERE id = :id");
        query.setParameter("status", ComplainStatus.valueOf(complainStatus));
        query.setParameter("id", id);
        int result = query.executeUpdate();
        tx.commit();
        session.close();
        System.out.println("Rows affected: " + result);
    }
}
