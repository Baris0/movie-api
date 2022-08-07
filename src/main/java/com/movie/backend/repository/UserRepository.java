package com.movie.backend.repository;

import com.movie.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUsersByUserName(String userName);
    User findUsersByMail(String mail);
}
