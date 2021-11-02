package com.sges.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Address invalid!")
	@NotNull(message = "Address invalid!")
	@Column(name = "address")
	private String address;
	
	@NotNull(message = "Username invalid!")
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@NotNull(message = "Receiver invalid!")
	@NotBlank(message = "Receiver invalid!")
	@Column(name = "receiver")
	private String receiver;

	@NotNull(message = "Phone invalid!")
	@NotBlank(message = "Phone invalid!")
	@Column(name = "phone")
	private String phone;
	
	@NotNull
	@Column(name = "status")
	private int status;
	
}
