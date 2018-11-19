package com.example.jpafall2018.repositories;

import com.example.jpafall2018.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.jpafall2018.models.Faculty;
import org.springframework.data.repository.query.Param;


public interface FacultyRepository extends CrudRepository<Faculty, Integer> {


    @Query("SELECT user FROM User user WHERE username.username=:username")
    public Faculty findUserByUsername(
            @Param("username") String username);

}
