package com.dnyanesh.userservice.beans;

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
public class UserAddress {

	private Integer id;
	private String line1;
	private String line2;
	private String city;
	private String pincode;
	private String state;
	private String country;
	private String mobileNumber;

}
