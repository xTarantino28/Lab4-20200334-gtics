package com.example.lab420200334.repository;


import com.example.lab420200334.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from user where email = ?1 and password = ?2 ",
            nativeQuery = true)
    User encontrarUsuario(String email,String contrasena);



}
