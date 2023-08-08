package com.dev.marcos.mybills.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.marcos.mybills.entities.Bills;

public interface BillsRepository extends JpaRepository<Bills,Long>{
    
}
