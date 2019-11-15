package com.interview.assignment.service;
import java.util.List;

import com.interview.assignment.entity.Product;

public interface ProductService {

	public List<Product> listProducts();
	public void saveProduct(Product product);
	public Product getProduct(int id);
	public void deleteProducts(int id);
	
}
