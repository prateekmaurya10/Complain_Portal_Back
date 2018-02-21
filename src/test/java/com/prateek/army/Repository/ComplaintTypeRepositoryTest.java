package com.prateek.army.Repository;

import com.prateek.army.model.Complainttype;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ComplaintTypeRepositoryTest {

    ComplaintTypeRepository complaintTypeRepository = new ComplaintTypeRepository();

    @Test
    public void findAll() {
        List<Complainttype> complainttypes = complaintTypeRepository.findAll();
        for(Complainttype complainttype : complainttypes)
        {
            System.out.println(complainttype.getComplaintType());
        }
    }

    @Test
    public void countAll() {
        assertEquals(Long.valueOf(2),complaintTypeRepository.countAll());
    }

    @Test
    public void find() {
        assertEquals("E&M",(complaintTypeRepository.find(1)).getComplaintType());
    }

    @Test
    public void create() {
        Complainttype complainttype = new Complainttype();
        complainttype.setComplaintType("Test");
        complaintTypeRepository.create(complainttype);
        complaintTypeRepository.create(complainttype);
    }

    @Test
    public void delete() {
        complaintTypeRepository.delete(2);
    }
}