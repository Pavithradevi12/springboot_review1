package com.java.supermarket.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@Table(name = "market_detail")
public class marketDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "detail")
    private String detail;

    @OneToOne
    @JoinColumn(name = "market_id")
    private market market;

    public marketDetail(String detail) {
        this.detail = detail;
    }
}