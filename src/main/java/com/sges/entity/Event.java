package com.sges.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "event")
public class Event implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@Column(name = "name")
	private String name;

	@NotNull
	@Column(name = "start_time")
	private Date start;
	
	@NotNull
	@Column(name = "end_time")
	private Date end;
	
	@OneToMany(mappedBy = "event")
	@JsonIgnore
	private List<Voucher> vouchers;
	
}
