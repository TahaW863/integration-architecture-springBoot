package com.hbrs.Controller;

import com.hbrs.Data.SalesMan;
import com.hbrs.Service.SalesManService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//CRUD
@RestController
@RequestMapping("api/v1/salesman")
@AllArgsConstructor
public class SalesManController {

    private final SalesManService salesManService;
    @GetMapping
    public List<SalesMan> fetchAllSalesMan(){
        return salesManService.getAllSalesMan();
    }
    @GetMapping(path = "{sid}")
    public SalesMan fetchSalesMan(@PathVariable("sid")int sid){
        return salesManService.getSalesManBySid(sid);
    }
    @PutMapping
    public void updateSalesMan(@RequestBody SalesMan salesMan){
        salesManService.updateSalesMan(salesMan);
    }
    @PostMapping
    public void registerNewSalesMan(@RequestBody SalesMan salesMan){
        salesManService.addNewSalesMan(salesMan);
    }
    @DeleteMapping(path="{sid}")
    public void deleteSalesMan(@PathVariable("sid") int sid){
        salesManService.deleteSaleMan(sid);
    }
}
