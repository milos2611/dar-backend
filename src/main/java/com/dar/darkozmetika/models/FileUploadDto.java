package com.dar.darkozmetika.models;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadDto {
	private MultipartFile file;
	private String name;

	private String image;
	private CategoryModel category;

	/*
	 * public String getId() { return id; }
	 * 
	 * public void setId(String id) { this.id = id;
	 * this.category.setId(Integer.parseInt(id)); }
	 */

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;

	}

	/*
	 * public String getDescription() { return description; }
	 * 
	 * public void setDescription(String description) { this.description =
	 * description; this.category.setCategory_description(description); }
	 */

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public CategoryModel getCategory() {
		return category;
	}

	public void setCategory(CategoryModel category) {
		this.category = category;
	}

}
