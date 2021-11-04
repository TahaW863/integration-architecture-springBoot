package com.hbrs.Service;

import com.hbrs.Data.EvaluationRecord;
import com.hbrs.Repository.EvaluationRecordRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EvaluationRecordService {
    private  final EvaluationRecordRepo evaluationRecordRepo;

    public List<EvaluationRecord> getAll() {
        return evaluationRecordRepo.findAll();
    }

    public void createEV(EvaluationRecord evaluationRecord) {
        evaluationRecordRepo.insert(evaluationRecord);
    }
    //It may give problems later -- later to be fixed
    public void updateEV(EvaluationRecord evaluationRecord) {
        EvaluationRecord ev=evaluationRecordRepo.findEvaluationRecordBySid(evaluationRecord.getSid()).get();
        evaluationRecord.setId(ev.getId());
        evaluationRecordRepo.save(evaluationRecord);
    }

    public void deleteEVs(int sid) {
        evaluationRecordRepo.deleteAllBySid(sid);
    }
}
