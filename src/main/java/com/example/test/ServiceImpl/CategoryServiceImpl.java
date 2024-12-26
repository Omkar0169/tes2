package com.example.test.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.test.Dto.CategoryDto;
import com.example.test.Model.Category;
import com.example.test.Repository.CategoryRepo;
import com.example.test.Service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public Category saveCategory(CategoryDto categoryDto) {

		Category category = new Category();
		category.setName(categoryDto.getName());
		
		Category save = categoryRepo.save(category);

		return save;
	}

	@Override
	public Page<Category> getAllCategories(int pageno, int pagesize) {

		PageRequest of = PageRequest.of(pageno, pagesize);
		Page<Category> all = categoryRepo.findAll(of);
		return all;
	}

	@Override
	public Category getCategoryById(int id) {
		Category category = categoryRepo.findById(id).get();
		return category;
	}

	@Override
	public Category updateCategory(int id, CategoryDto categoryDto) {

		Category category = categoryRepo.findById(id).get();
		category.setName(categoryDto.getName());

		Category update = categoryRepo.save(category);

		return update;
	}

	@Override
	public String deleteCategory(int id) {
		categoryRepo.deleteById(id);
		return "delete success..!";
	}

}
