package com.sges.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@Length(min = 0, max = 200)
	@Column(name = "address")
	private String address;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "username")
	private User user;
	
	@NotBlank
	@Length(max = 45)
	@Column(name = "receiver")
	private String receiver;
	
	@NotBlank
	@Column(name = "phone")
	private String phone;
	
	
	@NotNull
	@Column(name = "status")
	private int status;
	
}
