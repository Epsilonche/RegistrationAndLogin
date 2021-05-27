package org.hbrs.se2.project.hellocar.repository;

import org.hbrs.se2.project.hellocar.control.User;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.hbrs.se2.project.hellocar.dtos.impl.UserDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    /*
    @Query("  SELECT  u.id, u.username, u.password" +
            " FROM  User u " +
            " WHERE  u.id = u.id ")
    List<Object[]> findAllById();
    */

    @Query("  SELECT u.id, u.username, u.password" +
            " FROM User u  ")
    List<UserDTO> findAllUsers();

    List<User> findAll();

    UserDTO findUserByUseridAndPassword(String username,String password);







}
