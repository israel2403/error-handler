package com.huerta.errorhandler.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huerta.errorhandler.entity.User;

public interface UserRepository extends JpaRepository<User, UUID> {}
