package com.sps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sps.modal.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
