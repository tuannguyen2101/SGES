package com.sges.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_detail")
public class OrderDetail implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "quantity")
	@Min(message = "quantity invalid!", value = 1)
	private Integer quantity;

	@Column(name = "total")
	private BigDecimal total;

	@Column(name = "code")
	private String code;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	@ManyToOne
	@JoinColumn(name = "product_detail_id")
	private ProductDetail productDetail;

	@ManyToOne
	@JoinColumn(name = "combo_id")
	private Combo combo;
}
