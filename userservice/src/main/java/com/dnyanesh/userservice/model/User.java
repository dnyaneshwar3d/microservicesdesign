package com.dnyanesh.userservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "userId", callSuper = false)
@Entity
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = { "username", "emailid" }) })
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userid")
	private Integer userId;
	@Column(name = "firstname")
	private String firstName;
	@Column(name = "lastname")
	private String lastName;
	@Column(name = "username", unique = true)
	private String userName;
	@Column(name = "userpassword")
	private String password;
	@Column(name = "emailid", unique = true)
	private String emailId;
	@Column(name = "mobilenumber")
	private String mobileNumber;
	@Column(name = "birthdate")
	private Date birthDate;
	@Column(name = "createdon")
	private Date createdOn;
	@Column(name = "updatedon")
	private Date updatedOn;

	@OneToOne(mappedBy = "user")
	private Address address;

}
