package com.prateek.army.Service;

import com.prateek.army.Repository.QtrsRepository;
import com.prateek.army.model.Qtrs;

import java.util.ArrayList;
import java.util.List;

public class QtrsServiceImpl implements QtrsService {

    private QtrsRepository  qtrsRepository = new QtrsRepository();

    @Override
    public List<Integer> getQtrs() {
        List<Qtrs> qtrs = qtrsRepository.findAll();
        List<Integer> qtrNos = new ArrayList<>();
        for(Qtrs qtr : qtrs)
        {
            qtrNos.add(qtr.getQtrNo());
        }
        return qtrNos;
    }
}
