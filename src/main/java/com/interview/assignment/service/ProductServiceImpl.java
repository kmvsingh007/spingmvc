package com.interview.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.interview.assignment.entity.Product;
import com.interview.assignment.dao.ProductDAO;;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	@Override
	@Transactional
	public List<Product> listProducts() {
		return productDAO.listProducts();
	}

	@Override
	@Transactional
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		productDAO.saveProduct(product);
	}

	@Override
	@Transactional
	public Product getProduct(int id) {
		return productDAO.getProduct(id);
	}

	@Override
	@Transactional
	public void deleteProducts(int id) {
		productDAO.deleteProduct(id);
	}

}
