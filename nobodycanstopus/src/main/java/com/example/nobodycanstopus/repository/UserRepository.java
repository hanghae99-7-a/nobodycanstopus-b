package com.example.nobodycanstopus.repository;


import com.example.nobodycanstopus.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    Optional<User> findByNickname(String nickanme);;
}
