package com.dev.marcos.mybills.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.marcos.mybills.entities.Bills;
import com.dev.marcos.mybills.services.BillsService;

@RestController
@RequestMapping("/bills")
public class BillsController {
    
    @Autowired
    private BillsService billsService;

    @GetMapping( value = "/{id}" )
    public ResponseEntity<Bills> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(billsService.findById(id));
    }

}
