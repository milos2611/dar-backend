package com.dar.darkozmetika.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dar.darkozmetika.models.CategoryModel;
import com.dar.darkozmetika.repository.CategoryRepository;
import com.dar.darkozmetika.services.FileStorageService;

@RestController
@RequestMapping("api/cateogry")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private FileStorageService fileStorageService;

	@GetMapping("/findAllCategory")
	private List<CategoryModel> getAllCategory() {
		return this.categoryRepository.findAll();
	}

	@GetMapping("/findOneCategory/{id}")
	public CategoryModel getSpecificCategory(@PathVariable("id") long id) {
		return categoryRepository.getOne(id);
	}

	@PostMapping(consumes = { "multipart/form-data" }, value = "/saveCategory")
	@ResponseStatus(HttpStatus.OK)
	public void createCategory(@RequestPart("category") @Valid CategoryModel category,
			@RequestPart("file") @Valid @NotNull MultipartFile file) {
		String fileName = fileStorageService.storeFile(file);
		String fileURL = ServletUriComponentsBuilder.fromCurrentContextPath().path("/uploads/").path(fileName)
				.toUriString();

		category.setImage_path(fileURL);
		this.fileStorageService.storeFile(file);
		this.categoryRepository.save(category);
	}

	@DeleteMapping("/deleteCategory/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void createDelete(@PathVariable("id") long id) {
		
		this.categoryRepository.deleteProductByCategory(id);
	}

	@PutMapping("/updateCategory/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateCategory(@PathVariable("id") long id, @RequestBody CategoryModel category) {

		this.categoryRepository.updateCategory(id, category.getCategory_name(), category.getCategory_description(),
				category.getImage_path());
	}

	@PutMapping("/updateCategoryM/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateCategorys(@RequestPart CategoryModel category,
			@RequestPart("file") @Valid @NotNull MultipartFile file) {

		this.fileStorageService.deleteImage(category.getImage_path());
		String fileName = fileStorageService.storeFile(file);
		String fileURL = ServletUriComponentsBuilder.fromCurrentContextPath().path("/uploads/").path(fileName)
				.toUriString();

		category.setImage_path(fileURL);

		this.categoryRepository.updateCategory(category.getId(), category.getCategory_name(),
				category.getCategory_description(), category.getImage_path());
	}

}
