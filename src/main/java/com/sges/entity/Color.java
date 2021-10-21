package com.sges.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "color")
public class Color implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull(message = "Color invalid!")
	@NotBlank(message = "Color invalid!")
	@Column(name = "name")
	private String name;

	@NotBlank(message = "Image invalid!")
	@Column(name = "image")
	private String image;

	@NotNull
	@JsonIgnore
	@OneToMany(mappedBy = "color")
	private List<ProductDetail> productDetails;
	
}
