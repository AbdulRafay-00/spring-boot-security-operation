package com.example.security.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.security.DB_Connection.UserAuth_DB;
import java.util.Optional;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth_DB, Integer> {
@Query("SELECT u FROM UserAuth_DB u WHERE u.user_name = :user_name")
    Optional<UserAuth_DB>  findByUser_name(String user_name);
}

