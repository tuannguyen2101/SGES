package com.sges.entity;

import java.io.Serializable;

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
@Table(name = "sub_cate")
public class SubCate implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull(message = "Name invalid!")
	@NotBlank(message = "Name invalid!")
	@Column(name = "name")
	private String name;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "sup_cate_id")
	private SupCate supCate;
}
