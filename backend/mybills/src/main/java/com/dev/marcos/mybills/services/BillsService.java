package com.dev.marcos.mybills.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.marcos.mybills.entities.Bills;
import com.dev.marcos.mybills.repositories.BillsRepository;

@Service
public class BillsService {
    
    @Autowired
    private BillsRepository billsRepository;

    public Bills findById(Long id){
        return billsRepository.findById(id).get();
    }

}
