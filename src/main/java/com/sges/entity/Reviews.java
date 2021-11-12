package com.sges.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reviews")
public class Reviews implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Min(message = "Rate invalid!", value = 0)
	@Column(name = "rate")
	private Integer rate;

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
	@JoinColumn(name = "user_id")
	private User user;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "combo_id")
	private Combo combo;
}
