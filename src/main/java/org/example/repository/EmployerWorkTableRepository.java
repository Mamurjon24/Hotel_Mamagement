package org.example.repository;

import org.example.entity.EmployerTypeEntity;
import org.example.entity.EmployerWorkTableEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployerWorkTableRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(EmployerWorkTableEntity entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    public List<EmployerWorkTableEntity> employerTableList() {
        Session session = sessionFactory.openSession();
        Query<EmployerWorkTableEntity> query = session.createQuery("FROM EmployerWorkTableEntity ",EmployerWorkTableEntity.class);
        List<EmployerWorkTableEntity> list = query.getResultList();
        session.close();
        return list;
    }

    public EmployerWorkTableEntity getById(Integer employerWorkTable) {
        Session session = sessionFactory.openSession();
        EmployerWorkTableEntity entity = session.find(EmployerWorkTableEntity.class, employerWorkTable);
        session.close();
        return entity;
    }

    public void deleteEmployerWorkTable(Integer employerWorkTable) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        String hql = "DELETE FROM EmployerWorkTableEntity WHERE id = :employerworTable_id";
        Query query = session.createQuery(hql);
        query.setParameter("employerworTable_id", employerWorkTable);
        int result = query.executeUpdate();
        tx.commit();
        session.close();
        System.out.println("Rows affected: " + result);
    }
}
