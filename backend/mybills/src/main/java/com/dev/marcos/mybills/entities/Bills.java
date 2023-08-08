package com.dev.marcos.mybills.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table( name = "tb_bills" )
public class Bills implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "bills_sequence" )
    @SequenceGenerator( name = "bills_sequence", sequenceName = "bills_sequence", allocationSize = 1 )
    private Long id;

    @Column( name = "description", length = 255 )
    private String description;

    @Column( name = "amountspent", precision = 11, scale = 4 )
    private BigDecimal amountSpent;

    @Column( name = "date", columnDefinition = "DATE" )
    private Instant date;

    @Column( name = "paymenttype" )
    private Integer paymentType;

    @ManyToOne
    @JoinColumn( name = "userid" )
    @JsonIgnore
    private User user = new User();

    public Bills(){

    }

    public Bills(String description, BigDecimal value, Instant date, Integer paymentType, User user) {
        this.description = description;
        this.amountSpent = value;
        this.date = date;
        this.paymentType = paymentType;
        this.user = user;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Bills other = (Bills) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    

}
