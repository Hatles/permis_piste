package com.polytech.permis_piste.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.polytech.permis_piste.model.ApprenantEntity;

import javax.persistence.*;
import java.time.Instant;
//import com.polytech.permis_piste.model.ApprenantEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "account", schema = "permispiste")
public class Account implements java.io.Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String email;

	@JsonIgnore
	private String password;

	private String role = "ROLE_USER";

	private Instant created;

    protected Account() {

	}

	public Account(String email, String password, String role) {
		this.email = email;
		this.password = password;
		this.role = role;
		this.created = Instant.now();
	}

	public Long getId() {
		return id;
	}

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Instant getCreated() {
		return created;
	}

	@OneToOne(optional = false, fetch = FetchType.EAGER)
	private ApprenantEntity apprenant;

	public ApprenantEntity getApprenant() {
		return apprenant;
	}

	public void setApprenant(ApprenantEntity apprenant) {
		this.apprenant = apprenant;
	}
}
