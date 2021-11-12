package com.sges.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "combo_detail")
public class ComboDetail implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Name invalid!")
	@NotNull(message = "Name invalid!")
	@Column(name = "name")
	private String name;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "combo_id")
	private Combo combo;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "product_detail_id")
	private ProductDetail productDetail;
	
}
