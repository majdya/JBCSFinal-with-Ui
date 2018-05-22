package com.example.demo.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity
@SuppressWarnings("serial")
public class Company implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "comp_name")
	private String compName;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "comp_id")
	@OrderColumn
	private List<Coupon> coupons;

	public Company() {
	}

	public Company(String compName, String password, String email) {
		super();
		this.compName = compName;
		this.password = password;
		this.email = email;
	}

	public Company(int id, String compName, String password, String email) {
		this(compName, password, email);
		this.id = id;
	}

	public Company(int id, String compName, String password, String email, List<Coupon> coupons) {
		this(id, compName, password, email);
		this.coupons = coupons;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Coupon> getCoupons() {
		return coupons;
	}
	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", compName=" + compName + ", password=" + password + ", email=" + email
				+ ", coupons=\n" + coupons + "]\n";
	}

	public void addCoupon(Coupon coupon) {
		if (coupons == null)
			coupons = new ArrayList<Coupon>();
		if (coupon != null)
			coupons.add(coupon);
	}
}
