package com.sges.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "color")
public class Color implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@Length(max = 45)
	@Column(name = "name")
	private String name;
	
	@NotBlank
	@Length(max = 100)
	@Column(name = "image")
	private String image;

	@NotNull
	@JsonIgnore
	@OneToMany(mappedBy = "color")
	private List<ProductDetail> productDetails;
	
}
