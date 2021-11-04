package com.hbrs.Repository;

import com.hbrs.Data.EvaluationRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EvaluationRecordRepo extends MongoRepository<EvaluationRecord,String> {
    Optional<EvaluationRecord> findEvaluationRecordBySid(int sid);
    void deleteAllBySid(int sid);
}
