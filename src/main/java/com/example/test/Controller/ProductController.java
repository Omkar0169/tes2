package com.example.test.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.Dto.ProductDto;
import com.example.test.Service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/")
	public ResponseEntity<?> save(@RequestBody ProductDto productDto) {
		return new ResponseEntity<>(productService.saveProduct(productDto), HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<?> get(@RequestParam(value = "pageno",defaultValue = "0")int pageno,
                                 @RequestParam(value = "pagesize",defaultValue = "2")int pagesize) {
		return new ResponseEntity<>(productService.getAllProducts(pageno,pagesize), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") int id) {
		return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProductDto productDto) {
		return new ResponseEntity<>(productService.updateProduct(id, productDto), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
	}

}
