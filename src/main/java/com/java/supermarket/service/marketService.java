package com.java.supermarket.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.java.supermarket.Model.market;
import com.java.supermarket.repository.marketRepo;

import java.util.List;

@Service
public class marketService {

    @Autowired
    private marketRepo marketRepo;

    public Page<market> getAllMarkets(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return marketRepo.findAll(pageable);
    }

    public market createMarket(@NonNull market inventory) {
        return marketRepo.save(inventory);
    }

    public List<market> getAllMarkets() {
        return marketRepo.findAll();
    }

    public market getMarketById(@NonNull Integer id) {
        return marketRepo.findById(id).orElse(null);
    }

    public boolean updateMarket(int id, market newMarket) {
        market existingMarket = marketRepo.findById(id).orElse(null);
        if (existingMarket == null) {
            return false; // Inventory with given ID not found
        }
        try {
            // Update the existing market with new data
            existingMarket.setSymbol(newMarket.getSymbol());
            existingMarket.setPrice(newMarket.getPrice());
            marketRepo.save(existingMarket);
        } catch (Exception e) {
            return false; // Update failed
        }
        return true; // Update successful
    }

    public boolean deleteMarket(int id) {
        if (getMarketById(id) == null) {
            return false;
        }
        marketRepo.deleteById(id);
        return true;
    }

}
