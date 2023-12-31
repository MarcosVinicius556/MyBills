package com.dev.marcos.mybills.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.marcos.mybills.entities.User;

public interface UserRepository extends JpaRepository<User,Long>{
    
    public User findByUserName(String userName);

    public boolean existsByUserName(String username);

}
