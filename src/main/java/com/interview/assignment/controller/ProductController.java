package com.interview.assignment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.interview.assignment.entity.Product;
import com.interview.assignment.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productservice;

	@GetMapping("/list")
	public String listProducts(Model model) {
		List < Product > products = productservice.listProducts(); 
		model.addAttribute("products", products);
		return "listProducts";
	}
	
	@GetMapping("/addProduct")
	public String addProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "addProduct";
	}
	
	@PostMapping("/create")
	public String saveProducts(@ModelAttribute("product") Product product) {
		productservice.saveProduct(product);
		return "redirect:/product/list";
	}
	
	@GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("productId") int id,
        Model theModel) {
        Product product = productservice.getProduct(id);
        theModel.addAttribute("product", product);
        return "addProduct";
    }
	
	@GetMapping("/delete")
    public String deleteProduct(@RequestParam("productId") int id) {
        productservice.deleteProducts(id);
        return "redirect:/product/list";
    }
	
	@PostMapping("/bulkDelete")
    public String bulkDeleteProduct(HttpServletRequest request, Model theModel) {
        try {
        	if(request.getParameterValues("productId") != null) {
        		for(String productId: request.getParameterValues("productId")) {
        			productservice.deleteProducts(Integer.valueOf(productId));
        		}
        	}
        	return "redirect:/product/list";
        }
        catch (Exception e) {
        	theModel.addAttribute("error", e.getMessage());
        	return "redirect:/product/list";
        }
    }
}
