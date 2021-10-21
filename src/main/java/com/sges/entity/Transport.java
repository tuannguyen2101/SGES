package com.sges.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Min;
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
@Table(name = "transport")
public class Transport implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull(message = "Name invalid!")
	@NotBlank(message = "Name invalid!")
	@Column(name = "name")
	private String name;

	@Min(message = "Price invalid!", value = 0)
	@NotNull(message = "Price invalid!")
	@NotBlank(message = "Price invalid!")
	@Column(name = "price")
	private BigDecimal price;

	@OneToMany(mappedBy = "transport")
	@JsonIgnore
	private List<Order> orders;
}
