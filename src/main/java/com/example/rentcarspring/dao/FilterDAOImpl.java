package com.example.rentcarspring.dao;

import com.example.rentcarspring.entity.Utente;
import com.example.rentcarspring.util.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
@Repository
public class FilterDAOImpl implements FilterDAO {
    @Override
    public List<String> getColumn(String campo, String filter) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Utente> criteriaQuery = criteriaBuilder.createQuery(Utente.class);
            Root<Utente> root = criteriaQuery.from(Utente.class);
            criteriaQuery.select(root).where(criteriaBuilder.like(root.get(campo.toLowerCase()), "%" + filter + "%"));
            Query query = session.createQuery(criteriaQuery);
            List<String> list = query.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
