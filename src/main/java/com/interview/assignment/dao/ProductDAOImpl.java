package com.interview.assignment.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.interview.assignment.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Product> listProducts() {
		Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery < Product > cq = cb.createQuery(Product.class);
        Root < Product > root = cq.from(Product.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
	}

	@Override
	public void saveProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product); 
	}

	@Override
	public Product getProduct(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
        Product product = currentSession.get(Product.class, id);
        return product;
	}

	@Override
	public void deleteProduct(int id) {
		Session session = sessionFactory.getCurrentSession();
        Product product = session.byId(Product.class).load(id);
        session.delete(product);
	}

}
