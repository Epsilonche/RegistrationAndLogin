package org.hbrs.se2.project.collhbrs.repository;

import org.hbrs.se2.project.collhbrs.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.hbrs.se2.project.collhbrs.dtos.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    /*
    @Query("  SELECT  u.id, u.username, u.password" +
            " FROM  User u " +
            " WHERE  u.id = u.id ")
    List<Object[]> findAllById();
    */

    @Query("  SELECT u.userId, u.username, u.password" +
            " FROM User u  ")
    List<UserDTO> findAllUsers();

    List<User> findAll();

    UserDTO findUserByUsernameAndPassword(String username,String password);

    int deleteByUsername(String username);

    List<UserDTO> findAllByUsername(String username);

    List<UserDTO> findUsersByUserIdIsNotNull();









}
