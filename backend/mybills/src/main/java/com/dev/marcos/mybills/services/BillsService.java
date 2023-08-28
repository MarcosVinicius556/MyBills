package com.dev.marcos.mybills.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.marcos.mybills.entities.Bills;
import com.dev.marcos.mybills.repositories.BillsRepository;
import com.dev.marcos.mybills.services.exceptions.ResourceNotFoundException;

@Service
public class BillsService {
    
    @Autowired
    private BillsRepository billsRepository;

    public Bills findById(Long id){
        Optional<Bills> bills = billsRepository.findById(id);
        return bills.orElseThrow(() -> new ResourceNotFoundException(id));
    }

}
