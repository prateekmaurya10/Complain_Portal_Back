package com.prateek.army.Service;

import com.prateek.army.model.Area;

import java.util.List;

public interface AreaService {

    List<Area> getAreas();

    int getAreaId(String areaName);
}
