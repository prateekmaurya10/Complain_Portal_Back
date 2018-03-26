package com.prateek.army.Service;

import com.prateek.army.Repository.QtrsRepository;
import com.prateek.army.model.Qtrs;

import java.util.List;

public class QtrsServiceImpl implements QtrsService {

    private QtrsRepository qtrsRepository = new QtrsRepository();

    @Override
    public List<Qtrs> getQtrs() {
        List<Qtrs> qtrs = qtrsRepository.findAll();
        return qtrs;
    }

    @Override
    public List<Qtrs> getQtrsByArea(int id) {

        return qtrsRepository.findByArea(id);
    }

    //Get QtrId to be inserted in Owners table.
    @Override
    public int getQtrId(int areaId,int qtrNo){
        List<Qtrs> qtrs = qtrsRepository.findByArea(areaId);
        int qtrId = 0;
        for(Qtrs qtr :qtrs){
            if(qtr.getQtrNo() == qtrNo)
                qtrId = qtr.getId();
        }
        return qtrId;
    }
}