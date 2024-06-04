package com.totalplay_user.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.totalplay_user.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    
    @Query("SELECT COUNT(u) FROM User u WHERE u.nombre = :nombre AND u.apPaterno = :apPaterno AND u.apMaterno = :apMaterno")
    int countUsers(@Param("nombre") String nombre, @Param("apPaterno") String apPaterno, @Param("apMaterno") String apMaterno);

    
}
