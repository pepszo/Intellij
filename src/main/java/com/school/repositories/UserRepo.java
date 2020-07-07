package com.school.repositories;

import com.school.beans.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

    @Query(value = "select * from users where idRole = 1", nativeQuery = true)
    Set<User> getAllProfs();

    @Query(value = "select * from users where idRole = 2", nativeQuery = true)
    Set<User> getAllStuds();

    Optional<User> findByEmail(String email);
}
