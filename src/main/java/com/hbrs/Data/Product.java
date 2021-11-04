package com.hbrs.Data;

import lombok.Data;

import java.util.List;

@Data
public class Product {
    private String name;
    private List<Customer> customerList;
}
