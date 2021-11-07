package com.hbrs.Controller;

import com.hbrs.Data.SalesMan;
import com.hbrs.Service.SalesManService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//CRUD
@RestController //localhost:8080/api/v1/salesman
@RequestMapping("api/v1/salesman")
@AllArgsConstructor
public class SalesManController {

    private final SalesManService salesManService;
    @GetMapping
    public ResponseEntity<List<SalesMan>> fetchAllSalesMan(){
        List<SalesMan> list;
        try{
           return new ResponseEntity<>(salesManService.getAllSalesMan(), HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND );
        }

    }
    @GetMapping(path = "{sid}")
    public ResponseEntity<SalesMan> fetchSalesMan(@PathVariable("sid")int sid){
        try {
            return new ResponseEntity<>(salesManService.getSalesManBySid(sid),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping
    public ResponseEntity updateSalesMan(@RequestBody SalesMan salesMan){
        try {
            salesManService.updateSalesMan(salesMan);
            return  ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }
    @PostMapping
    public ResponseEntity registerNewSalesMan(@RequestBody SalesMan salesMan){
        try {
            salesManService.addNewSalesMan(salesMan);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }
    @DeleteMapping(path="{sid}")
    public ResponseEntity deleteSalesMan(@PathVariable("sid") int sid){
        try {
            salesManService.deleteSaleMan(sid);
            return ResponseEntity.accepted().build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
