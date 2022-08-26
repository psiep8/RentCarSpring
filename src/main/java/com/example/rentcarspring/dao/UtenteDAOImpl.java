package com.example.rentcarspring.dao;

import com.example.rentcarspring.entity.Utente;
import com.example.rentcarspring.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

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
    public Utente getUser(String nome) {
        Transaction transaction = null;
        Utente user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            user = session.get(Utente.class, nome);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return user;
    }
}
