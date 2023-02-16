package com.ayush.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayush.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
