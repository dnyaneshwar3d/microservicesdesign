package com.dnyanesh.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dnyanesh.userservice.model.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer> {

	UserDetails getUserByUserId(Integer userId);

}
