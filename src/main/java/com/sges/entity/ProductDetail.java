package com.sges.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_detail")
public class ProductDetail implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Min(message = "Price invalid!", value = 0)
	@NotNull
	@Column(name = "price")
	private BigDecimal price;

	@NotNull
	@Min(message = "Quantity invalid!", value = 0)
	@Column(name = "quantity")
	private Integer quantity;

	@NotNull
	@Min(message = "Sold invalid!", value = 0)
	@Column(name = "sold")
	private Integer sold;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@Column(name = "size")
	private String size;

	@Column(name = "color")
	private String color;

	@Column(name = "image")
	private String image;

	@ManyToOne
	@JoinColumn(name = "inventory_id")
	private Inventory inventory;

	@OneToMany(mappedBy = "productDetail")
	@JsonIgnore
	private List<OrderDetail> orderDetails;
	
}
