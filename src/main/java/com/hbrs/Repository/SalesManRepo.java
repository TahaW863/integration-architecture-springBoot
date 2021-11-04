package com.hbrs.Repository;

import com.hbrs.Data.SalesMan;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SalesManRepo extends MongoRepository<SalesMan,String> {
    Optional<SalesMan> findSalesManBySid(int sid);

    void deleteSaleManBySid(int sid);
}
