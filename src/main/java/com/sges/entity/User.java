package com.sges.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "username")
	@NotNull(message = "Username invalid!")
	@NotBlank(message = "Username invalid!")
	@Length(message = "Username invalid!", min = 6, max = 45)
	private String username;

	@NotNull(message = "Password invalid!")
	@NotBlank(message = "Password invalid!")
	@Length(message = "Password invalid!", min = 6)
	@Column(name = "password")
	private String password;

	@Column(name = "avatar")
//	@NotBlank
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
//	@NotNull(message = "Phone invalid!")
//	@NotBlank(message = "Phone invalid!")
	@Column(name = "phone")
	private String phone;

	@NotNull(message = "Gender invalid!")
	@Column(name = "gender")
	private Integer gender;

	@NotNull(message = "Status invalid!")
	@Column(name = "status")
	private Integer status;

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

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "authority",
				joinColumns = @JoinColumn(name = "user_id"),
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public User(String username, String password, String avatar, String fullname, String email, String phone, Integer gender, Integer status) {
		this.username = username;
		this.password = password;
		this.avatar = avatar;
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.status = status;
	}

	//	@OneToMany(mappedBy = "user")
//	@JsonIgnore
//	private List<Authority> authorities;
}
