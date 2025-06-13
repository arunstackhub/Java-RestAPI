package com.rest.code;

import java.util.Arrays;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@PostMapping("/product")
	public String saveProduct(@RequestBody Product p) {
		System.out.println("Product name : "+p.getName());
		return "product saved";
		
	}
	
	
	@GetMapping("product/{pid}")
	public Product getProduct(@PathVariable Integer pid) {
		
		Product p =null;
		if(pid==100) {
			 p = new Product(100,"Mouse",500.00);
		}else if(pid==101) {
			
		 p = new Product(101,"HDD",3500.00);
	}
	
		return p;
	}
	
	@GetMapping("/products")
	public String listOfProducts(Model model){
		
		Product p1 = new Product(100,"Mouse",500.00);
		Product p2 = new Product(100,"HDD",3500.00);
		
		List<Product> products=  Arrays.asList(p1,p2);
		
		model.addAttribute("products", products);
		
		return "product_details";
				
		
	}

}
