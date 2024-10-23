package com.eidantechie.demo.repo;

import com.eidantechie.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByRole(String username);
}

