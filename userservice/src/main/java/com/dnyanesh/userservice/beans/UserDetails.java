package com.dnyanesh.userservice.beans;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author dnyanesh
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "userId", callSuper = false)
public class UserDetails {

	private Integer userId;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String emailId;
	private String mobileNumber;
	private Date birthDate;
	private Date createdOn;
	private Date updatedOn;

	private UserAddress address;

}
