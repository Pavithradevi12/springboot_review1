package com.java.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.supermarket.Model.market;

@Repository
public interface marketRepo extends JpaRepository<market, Integer> {
}