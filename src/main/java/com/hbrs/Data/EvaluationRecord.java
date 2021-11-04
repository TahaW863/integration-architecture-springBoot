package com.hbrs.Data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class EvaluationRecord {
    @Id
    private String id;
    private Integer year;
    private List<Product> productList;
    private SocialPerformance socialPerformance;
    private Integer sid;

    public EvaluationRecord(Integer year, List<Product> productList, SocialPerformance socialPerformance, Integer sid) {
        this.year = year;
        this.productList = productList;
        this.socialPerformance = socialPerformance;
        this.sid = sid;
    }
}
