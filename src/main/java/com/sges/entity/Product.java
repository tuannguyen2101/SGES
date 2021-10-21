package com.sges.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull(message = "Name invalid!")
	@NotBlank(message = "Name invalid!")
	@Column(name = "name")
	private String name;

	@NotNull(message = "Image invalid!")
	@NotBlank(message = "Image invalid!")
	@Column(name = "image")
	private String image;

	@NotNull(message = "Description in valid!")
	@NotBlank(message = "Description in valid!")
	@Column(name = "description")
	private String description;

	@NotNull(message = "Created invalid!")
	@NotBlank(message = "Created invalid!")
	@Column(name = "created")
	private Date created;

	@Column(name = "view")
	private int view;

	@Column(name = "like")
	private int like;

	@Column(name = "status")
	private int status;

	@ManyToOne
	@JoinColumn(name = "sub_cate_id")
	private SubCate subCate;

	@OneToMany(mappedBy = "product")
	@JsonIgnore
	private List<GenderDetail> genderDetails;

	@OneToMany(mappedBy = "product")
	@JsonIgnore
	private List<Reviews> reviews;

	@OneToMany(mappedBy = "product")
	@JsonIgnore
	private List<ProductDetail> productDetails;

}
