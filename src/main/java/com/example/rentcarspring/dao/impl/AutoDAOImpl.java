package com.example.rentcarspring.dao.impl;

import com.example.rentcarspring.dao.AutoDAO;
import com.example.rentcarspring.entity.Auto;
import com.example.rentcarspring.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AutoDAOImpl implements AutoDAO {

    @Override
    public void updateAuto(Auto auto) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(auto);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void deleteAuto(int id) {
        Transaction transaction = null;
        Auto auto;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            auto = session.get(Auto.class, id);
            session.delete(auto);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public List<Auto> getAllAuto() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Auto", Auto.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Auto getAuto(int id) {
        Transaction transaction = null;
        Auto auto = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            auto = session.get(Auto.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return auto;
    }
}
