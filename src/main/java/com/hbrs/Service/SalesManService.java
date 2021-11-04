package com.hbrs.Service;


import com.hbrs.Data.SalesMan;
import com.hbrs.Repository.SalesManRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class SalesManService {

    private final SalesManRepo salesManRepo;
    public List<SalesMan> getAllSalesMan(){
        return salesManRepo.findAll();
    }
    public void addNewSalesMan(SalesMan salesMan){
        salesManRepo.findSalesManBySid(salesMan.getSid())
                .ifPresentOrElse(s ->new IllegalStateException("Already Exists."),
                        ()->salesManRepo.insert(salesMan));
    }

    public void deleteSaleMan(int sid) {
        salesManRepo.deleteSaleManBySid(sid);
    }

    public SalesMan getSalesManBySid(int sid) {
        return salesManRepo.findSalesManBySid(sid).get();
    }

    public void updateSalesMan(SalesMan salesMan) {
        SalesMan s=salesManRepo.findSalesManBySid(salesMan.getSid()).get();
        if(s!=null){
            salesMan.setId(s.getId());
            salesManRepo.save(salesMan);
        }
    }
}
