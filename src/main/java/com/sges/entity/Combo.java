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
@Table(name = "combo")
public class Combo implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull(message = "Name invalid!")
	@NotBlank(message = "Name invalid!")
	@Column(name = "name")
	private String name;

	@Column(name = "sale_off")
	private Integer saleOff;
	
	@OneToMany(mappedBy = "combo")
	@JsonIgnore
	private List<ComboDetail> comboDetails;

	@OneToMany(mappedBy = "combo")
	@JsonIgnore
	private List<Reviews> reviews;

	@OneToMany(mappedBy = "combo")
	@JsonIgnore
	private List<OrderDetail> orderDetails;
}
