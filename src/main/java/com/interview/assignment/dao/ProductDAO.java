package com.interview.assignment.dao;
import java.util.List;

import com.interview.assignment.entity.Product;

public interface ProductDAO {

	public List<Product> listProducts();
	public void saveProduct(Product product);
	public Product getProduct(int id);
	public void deleteProduct(int id);
}
