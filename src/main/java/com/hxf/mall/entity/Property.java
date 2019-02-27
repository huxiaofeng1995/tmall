package com.hxf.mall.entity;

public class Property {

	private Integer id;

	private String name;

	private Category category;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
 
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Property [id=" + id + ", name=" + name + ", category=" + category + "]";
	}
	
	
	
}
