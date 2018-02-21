package com.prateek.army.Repository;

import com.prateek.army.model.Area;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AreasRepositoryTest {

    AreasRepository areasRepository = new AreasRepository();

    @Test
    public void findAll() {
        List<Area> areas = areasRepository.findAll();
        for(Area area : areas)
        {
            System.out.println(area.getAreaName());
        }
    }

    @Test
    public void countAll() {
        assertEquals(Long.valueOf(6),areasRepository.countAll());
    }

    @Test
    public void find() {
        assertEquals("SARVATRA",(areasRepository.find(3)).getAreaName());
    }

    @Test
    public void create() {
        Area area = new Area();
        area.setAreaName("RK PURAM");
        areasRepository.create(area);
    }

    @Test
    public void delete() {
        areasRepository.delete(3);
    }
}