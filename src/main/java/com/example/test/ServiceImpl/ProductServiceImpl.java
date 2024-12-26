package com.example.test.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.test.Dto.ProductDto;
import com.example.test.Model.Product;
import com.example.test.Repository.ProductRepo;
import com.example.test.Service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	@Override
	public Product saveProduct(ProductDto productDto) {

		Product product = new Product();
		product.setProductname(productDto.getProductname());
		product.setMrp(productDto.getMrp());
		product.setCategory(productDto.getCategory());

		Product save = productRepo.save(product);
		return save;
	}

	@Override
	public Page<Product> getAllProducts(int pageno,int pagesize) {
		
        PageRequest of = PageRequest.of(pageno, pagesize);
		Page<Product> all = productRepo.findAll(of);
		return all;
	}

	@Override
	public Product getProductById(int id) {
		
		Optional<Product> byId = productRepo.findById(id);

		if (byId.isEmpty()) {
			throw new RuntimeException("product id not present");
		}
		Product product = byId.get();

		return product;
	}

	@Override
	public Product updateProduct(int id, ProductDto productDto) {
		
		Product product = productRepo.findById(id).get();
		product.setProductname(productDto.getProductname());
		product.setMrp(productDto.getMrp());
		
		Product update = productRepo.save(product);
		
		return update;
	}

	@Override
	public String deleteProduct(int id) {
		productRepo.deleteById(id);
		return "delete success..";
	}

}
