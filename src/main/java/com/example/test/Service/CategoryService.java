package com.example.test.Service;

import org.springframework.data.domain.Page;

import com.example.test.Dto.CategoryDto;
import com.example.test.Model.Category;

public interface CategoryService {

	public Category saveCategory(CategoryDto categoryDto);

	public Page<Category> getAllCategories(int pageno,int pagesize);

	public Category getCategoryById(int id);

	public Category updateCategory(int id, CategoryDto categoryDto);

	public String deleteCategory(int id);
}
