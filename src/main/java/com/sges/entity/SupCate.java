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
@Table(name = "sup_cate")
public class SupCate implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "Name invalid!")
	@NotBlank(message = "Name invalid!")
	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "supCate")
	@JsonIgnore
	private List<SubCate> subCates;
}
