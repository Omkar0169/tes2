package com.example.test.Service;

import org.springframework.data.domain.Page;

import com.example.test.Dto.ProductDto;
import com.example.test.Model.Product;

public interface ProductService {

	public Product saveProduct(ProductDto productDto);

	public Page<Product> getAllProducts(int pageno,int pagesize);

	public Product getProductById(int id);

	public Product updateProduct(int id, ProductDto productDto);

	public String deleteProduct(int id);
}
