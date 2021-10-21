package com.sges.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "combo")
public class Combo implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@Length(max = 100)
	@Column(name = "name")
	private String name;	
	
	@OneToMany(mappedBy = "combo")
	@JsonIgnore
	private List<ComboDetail> comboDetails;

	@OneToMany(mappedBy = "combo")
	@JsonIgnore
	private List<Reviews> reviews;

	@ManyToOne
	@JoinColumn(name = "order_detail_id")
	private OrderDetail orderDetail;
}
