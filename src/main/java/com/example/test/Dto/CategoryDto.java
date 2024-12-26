package com.example.test.Dto;

import java.util.List;

import com.example.test.Model.Product;

import lombok.Data;

@Data
public class CategoryDto {

	private int id;
	private String name;
	private List<Product> products;
}
