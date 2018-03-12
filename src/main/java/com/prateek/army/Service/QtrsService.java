package com.prateek.army.Service;

import java.util.List;

public interface QtrsService {

    public List<Integer> getQtrs();

    public List<Integer> getQtrsByArea(int id);
}
