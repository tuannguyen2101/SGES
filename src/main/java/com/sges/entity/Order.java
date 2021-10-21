package com.sges.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order")
public class Order implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@NotBlank
	@Length(message = "Length invalid", min = 9, max = 12)
	@Column(name = "phone")
	private String phone;

	@NotNull
	@Column(name = "created")
	private Date created;

	@NotNull
	@NotBlank
	@Length(message = "Length invalid!", min = 10, max = 200)
	@Column(name = "address")
	private String adress;

	@Column(name = "status")
	private int status;

	@ManyToOne
	@JoinColumn(name = "voucher_id")
	private Voucher voucher;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "username")
	private User user;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "payment_id")
	private Payment payment;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "transport_id")
	private Transport transport;

	@OneToMany(mappedBy = "order")
	@JsonIgnore
	private List<OrderDetail> orderDetails;
	
}
