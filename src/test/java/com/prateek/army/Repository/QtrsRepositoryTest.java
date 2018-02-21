package com.prateek.army.Repository;

import com.prateek.army.model.Qtrs;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class QtrsRepositoryTest {

    QtrsRepository qtrsRepository = new QtrsRepository();

    @Test
    public void findAll() {
        List<Qtrs> qtrs = qtrsRepository.findAll();
        for(Qtrs qtr : qtrs)
        {
            System.out.println(qtr.getQtrNo());
        }
    }

    @Test
    public void countAll() {
        assertEquals(Long.valueOf(30),qtrsRepository.countAll());
    }

    @Test
    public void find() {
        assertEquals(303,(qtrsRepository.find(3)).getQtrNo());
    }

    @Test
    public void create() {
        Qtrs qtr = new Qtrs();
        qtr.setQtrNo(808);
        qtr.setAreaId(3);
    }

    @Test
    public void delete() {
        qtrsRepository.delete(3);
    }
}