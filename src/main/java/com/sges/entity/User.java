package com.sges.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
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
@Table(name = "user")
public class User implements Serializable {

	@Id
	@Column(nullable = false)
	@NotNull(message = "Username invalid!")
	@NotBlank(message = "Username invalid!")
	@Length(message = "Username invalid!", min = 6, max = 45)
	private String username;

	@NotNull(message = "Password invalid!")
	@NotBlank(message = "Password invalid!")
	@Length(message = "Password invalid!", min = 6, max = 45)
	@Column(name = "password")
	private String password;

	@Column(name = "avatar")
	@NotBlank
	private String avatar;

	@NotNull(message = "Fullname invalid!")
	@NotBlank(message = "Fullname invalid!")
	@Column(name = "fullname")
	private String fullname;

	@Email(message = "Email invalid!")
	@NotNull(message = "Email invalid!")
	@NotBlank(message = "Email invalid!")
	@Column(name = "email")
	private String email;

	@Length(message = "Phone invalid!", min = 8, max = 15)
	@NotNull(message = "Phone invalid!")
	@NotBlank(message = "Phone invalid!")
	@Column(name = "phone")
	private String phone;

	@NotNull(message = "Gender invalid!")
	@Column(name = "gender")
	private int gender;

	@NotNull(message = "Status invalid!")
	@Column(name = "status")
	private int status;

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Address> addresses;

	@Column(name = "otp_code")
	private String otpCode;

	@Column(name = "end_time")
	private Date endTime;

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Order> orders;

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Reviews> reviews;

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Authority> authorities;
}
