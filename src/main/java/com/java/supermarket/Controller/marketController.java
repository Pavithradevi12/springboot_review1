package com.java.supermarket.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.java.supermarket.Model.market;
import com.java.supermarket.service.marketService;

@RestController
@RequestMapping("/api")
public class marketController {

    @Autowired
    private marketService marketService;

    @PostMapping("/markets")
    public ResponseEntity<market> addMarket(@RequestBody market market) {
        market newMarket = marketService.createMarket(market);
        if (newMarket != null) {
            return new ResponseEntity<>(newMarket, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/markets")
    public ResponseEntity<Page<market>> getAllMarkets(
            @RequestParam int pageNo,
            @RequestParam int pageSize,
            @RequestParam String sortBy) {
        Page<market> markets = marketService.getAllMarkets(pageNo, pageSize, sortBy);
        if (!markets.isEmpty()) {
            return new ResponseEntity<>(markets, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/markets/{marketId}")
    public ResponseEntity<market> updateMarket(@PathVariable int marketId, @RequestBody market market) {
        boolean updated = marketService.updateMarket(marketId, market);
        if (updated) {
            return new ResponseEntity<>(market, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/markets/{marketId}")
    public ResponseEntity<Boolean> deleteMarket(@PathVariable int marketId) {
        boolean deleted = marketService.deleteMarket(marketId);
        if (deleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}
