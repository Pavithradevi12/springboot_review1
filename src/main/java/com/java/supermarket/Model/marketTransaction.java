package com.java.supermarket.Model;

import lombok.Data;
import lombok.NoArgsConstructor;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@Table(name = "market_transaction")
public class marketTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "market_id")
    private market market;

    public marketTransaction(String type) {
        this.type = type;
    }
}

