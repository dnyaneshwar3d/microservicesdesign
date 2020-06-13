package com.dnyanesh.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dnyanesh.userservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User getUserByUserId(Integer userId);

}
