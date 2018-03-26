package com.prateek.army.Service;

import com.prateek.army.Repository.AreasRepository;
import com.prateek.army.model.Area;

import java.util.List;

public class AreaServiceImpl implements AreaService {

    private AreasRepository areasRepository = new AreasRepository();

    @Override
    public List<Area> getAreas() {
        List<Area> areasList = areasRepository.findAll();
       /* List<String> areaNames = new ArrayList<>();
        for(Area area : areas)
        {
            areaNames.add(area.getAreaName());
        }*/
        return areasList;
    }

    @Override
    public int getAreaId(String areaName){
        List<Area> areas = areasRepository.findAll();
        int areaId = 0;
        for(Area area : areas){
            if(area.getAreaName() == areaName)
                areaId = area.getId();
        }
        return areaId;
    }
}
