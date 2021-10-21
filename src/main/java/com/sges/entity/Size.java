package com.sges.entity;

import java.io.Serializable;
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
@Table(name = "size")
public class Size implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@NotBlank
	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "size")
	@JsonIgnore
	private List<ProductDetail> productDetails;
}
