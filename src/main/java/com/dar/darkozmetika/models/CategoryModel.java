package com.dar.darkozmetika.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Category")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CategoryModel {
    @Id
    @Column(name = "id")
	//@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String category_name;
    private String category_description;
    private String image_path;

    @JsonIgnore
    @OneToMany( mappedBy = "category")
    private Set<ProductModel> category;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getCategory_description() {
		return category_description;
	}

	public void setCategory_description(String category_description) {
		this.category_description = category_description;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public Set<ProductModel> getCategory() {
		return category;
	}

	public void setCategory(Set<ProductModel> category) {
		this.category = category;
	}

	

	

}
