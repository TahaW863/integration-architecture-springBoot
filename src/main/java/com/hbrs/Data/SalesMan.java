package com.hbrs.Data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class SalesMan {
    @Id
    private String id;
    private Integer sid;
    private String name;
    private String department;

    public SalesMan(Integer sid, String name, String department) {
        this.sid = sid;
        this.name = name;
        this.department = department;
    }
}
