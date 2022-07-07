package com.selflearning.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "isactive")
	private boolean isActive;

	@Column(name = "roles")
	private String roles;
	
}
