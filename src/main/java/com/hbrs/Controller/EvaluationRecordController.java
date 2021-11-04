package com.hbrs.Controller;

import com.hbrs.Data.EvaluationRecord;
import com.hbrs.Service.EvaluationRecordService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/evaluationRecord")
@AllArgsConstructor
public class EvaluationRecordController {

    private final EvaluationRecordService evaluationRecordService;

    @GetMapping
    public List<EvaluationRecord> fetchAllEvaluationRecords(){
       return evaluationRecordService.getAll();
    }
    @PostMapping
    public void createEvaluationRecord(@RequestBody EvaluationRecord evaluationRecord){
        evaluationRecordService.createEV(evaluationRecord);
    }
    @PutMapping
    public void updateEvaluationRecord(@RequestBody EvaluationRecord evaluationRecord){
        evaluationRecordService.updateEV(evaluationRecord);
    }
    @DeleteMapping(path = "{sid}")
    public void deleteEvaluationRecords(@PathVariable("sid") int sid){
        evaluationRecordService.deleteEVs(sid);
    }
}
