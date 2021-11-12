package com.sges.entity;

import java.io.Serializable;
import java.util.Date;
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
	private Integer id;

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
	@Column(name = "created")
	@Temporal(TemporalType.DATE)
	private Date created;

	@Column(name = "view")
	private Integer view;

	@Column(name = "status")
	private Integer status;

	@Column(name = "sale")
	private Integer sale;

	@ManyToOne
	@JoinColumn(name = "sub_cate_id")
	private SubCate subCate;

	@Column(name = "price")
	private Double price;

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
