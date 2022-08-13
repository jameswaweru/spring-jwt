package com.jameswaweru.jwt.repository;

import com.jameswaweru.jwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByUserNameAndPassword(String username, String password);

    User getUserByUserName(String username);

    Boolean existsByUserName(String username);

}
