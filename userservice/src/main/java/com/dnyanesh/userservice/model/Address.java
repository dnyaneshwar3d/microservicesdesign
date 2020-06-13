package com.dnyanesh.userservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id", callSuper = false)
@Builder
@Entity
@Table(name = "table_address")
public class Address {
	@Id
	@Column(name = "addressid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "line1")
	private String line1;
	@Column(name = "line2")
	private String line2;
	@Column(name = "city")
	private String city;
	@Column(name = "pincode")
	private String pincode;
	@Column(name = "state")
	private String state;
	@Column(name = "country")
	private String country;
	@Column(name = "mobilenumber")
	private String mobileNumber;

	@OneToOne(mappedBy = "address")
	private User user;

}
