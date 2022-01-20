package com.edu.phuxuan.cntt.k17.hlatuan.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="category")
	private String category;
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCccd() {
		return cccd;
	}

	public void setCccd(String cccd) {
		this.cccd = cccd;
	}

	@Column(name="email")
	private String email;
	
	@Column(name="date_time")
	private String datetime;
	
	@Column(name="sex")
	private String sex;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="cccd")
	private String cccd;
	
	@ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;
	
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "customers_hobbies",
	        joinColumns = @JoinColumn(name = "customer_id"),
	        inverseJoinColumns = @JoinColumn(name = "hobby_id")
	    )
	private List<Hobby> hobbies = new ArrayList();
	
	
	
	public Customer() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", datetime=" + datetime +", email=" + email + ", category=" + category + ", sex=" + sex + ", phone=" + phone + ", cccd=" + cccd +"]";
	}

	/**
	 * @return the province
	 */
	public Province getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(Province province) {
		this.province = province;
	}

	/**
	 * @return the hobbies
	 */
	public List<Hobby> getHobbies() {
		return hobbies;
	}

	/**
	 * @param hobbies the hobbies to set
	 */
	public void setHobbies(List<Hobby> hobbies) {
		this.hobbies = hobbies;
	}
	
	
}





