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
@Table(name = "gender")
public class Gender implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Name invalid!")
	@NotNull(message = "Name invalid!")
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "gender")
	@JsonIgnore
	private List<GenderDetail> genderDetails;
}
