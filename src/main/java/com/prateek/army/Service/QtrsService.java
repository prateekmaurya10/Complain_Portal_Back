package com.prateek.army.Service;

import com.prateek.army.model.Qtrs;

import java.util.List;

public interface QtrsService {

    List<Qtrs> getQtrs();

    List<Qtrs> getQtrsByArea(int id);

    int getQtrId(int areaId,int qtrNo);
}
