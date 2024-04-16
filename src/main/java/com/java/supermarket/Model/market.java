package com.java.supermarket.Model;
import lombok.NoArgsConstructor;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.List;


@Entity
@NoArgsConstructor
@Table(name = "market")
public class market {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "price")
    private double price;

    @OneToOne(mappedBy = "market", cascade = CascadeType.ALL)
    private marketDetail productDetail;

    @OneToMany(mappedBy = "market", cascade = CascadeType.ALL)
    private List<marketTransaction> transactions;

    public market(Integer id, String symbol, double price) {
        this.id = id;
        this.symbol = symbol;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public marketDetail getproductDetail() {
        return productDetail;
    }

    public void setproductDetail(marketDetail productDetail) {
        this.productDetail = productDetail;
    }

    public List<marketTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<marketTransaction> transactions) {
        this.transactions = transactions;
    }

    
}

