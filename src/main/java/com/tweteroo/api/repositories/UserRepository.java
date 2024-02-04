package com.tweteroo.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tweteroo.api.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
  boolean existsByUsername(String username);
}
