package com.example.test.Dto;

import com.example.test.Model.Category;

import lombok.Data;

@Data
public class ProductDto {

	private int id;
	private String productname;
	private float mrp;
	private Category category;
}
