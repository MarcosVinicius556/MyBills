package com.dev.marcos.mybills.dto;

import java.math.BigDecimal;
import java.util.List;

import com.dev.marcos.mybills.entities.Bills;

public record UserApplication(Long id,
                              String name, 
                              byte[] avatarImg, 
                              BigDecimal balance, 
                              String telephone, 
                              List<Bills> bills, 
                              String accesToken){

}
