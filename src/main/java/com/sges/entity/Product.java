package com.sges.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	private String image;

	@NotNull(message = "Description in valid!")
	@
	private String description;
	private Date created;
	private int view;
	private int like;
	private int status;
	private int couponsId;
	private int subcateId;
	private int brandId;	

}
