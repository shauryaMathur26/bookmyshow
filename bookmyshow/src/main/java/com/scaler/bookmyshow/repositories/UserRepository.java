package com.scaler.bookmyshow.repositories;

import com.scaler.bookmyshow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    //Query -> select * from user where id = ?
    @Override
    Optional<User> findById(Long aLong);

    Optional<User> findByEmail(String email);

    @Override
    User save(User user);

}
