package com.sges.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reviews")
public class Reviews implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Min(message = "Rate invalid!", value = 0)
	@Column(name = "rate")
	private int rate;

	@NotNull(message = "Comment invalid!")
	@NotBlank(message = "Comment invalid!")
	@Column(name = "comment")
	private String comment;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "username")
	private User user;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "combo_is")
	private Combo combo;
}
