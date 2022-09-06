package com.example.rentcarspring.dao.impl;

import com.example.rentcarspring.dao.UtenteDAO;
import com.example.rentcarspring.entity.Utente;
import com.example.rentcarspring.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UtenteDAOImpl implements UtenteDAO {
    @Override
    public void updateUtente(Utente utente) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(utente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUtente(int id) {
        Transaction transaction = null;
        Utente utente;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            utente = session.get(Utente.class, id);
            if (utente != null) {
                session.delete(utente);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public List<Utente> getUtenti() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Utente where customer is true", Utente.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Utente getUser(int id) {
        Transaction transaction = null;
        Utente user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            user = session.get(Utente.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Utente getUserByEmail(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Utente> criteriaQuery = criteriaBuilder.createQuery(Utente.class);
            Root<Utente> root = criteriaQuery.from(Utente.class);
            criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("email"), email));
            Query<Utente> query = session.createQuery(criteriaQuery);
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
