package com.sampleaopproject.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sampleaopproject.app.entities.UserEntity;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer>{

}
