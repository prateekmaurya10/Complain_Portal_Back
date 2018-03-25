package com.prateek.army.Service;

import com.prateek.army.model.Qtrs;

import java.util.List;

public interface QtrsService {

    public List<Qtrs> getQtrs();

    public List<Qtrs> getQtrsByArea(int id);
}
