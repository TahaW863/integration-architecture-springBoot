package com.hbrs.Controller;

import com.hbrs.Data.EvaluationRecord;
import com.hbrs.Service.EvaluationRecordService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/evaluationRecord")
@AllArgsConstructor
public class EvaluationRecordController {

    private final EvaluationRecordService evaluationRecordService;

    @GetMapping
    public ResponseEntity<List<EvaluationRecord>> fetchAllEvaluationRecords(){
        try {
            return new ResponseEntity<>(evaluationRecordService.getAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

    }
    @PostMapping
    public ResponseEntity createEvaluationRecord(@RequestBody EvaluationRecord evaluationRecord){
        try {
            evaluationRecordService.createEV(evaluationRecord);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }
    @PutMapping
    public ResponseEntity updateEvaluationRecord(@RequestBody EvaluationRecord evaluationRecord){
        try {
            evaluationRecordService.updateEV(evaluationRecord);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }
    @DeleteMapping(path = "{sid}")
    public ResponseEntity deleteEvaluationRecords(@PathVariable("sid") int sid){
        try {
            evaluationRecordService.deleteEVs(sid);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }

    }
}
