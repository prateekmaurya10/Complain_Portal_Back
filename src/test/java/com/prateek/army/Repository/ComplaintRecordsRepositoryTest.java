package com.prateek.army.Repository;

import com.prateek.army.model.Complaintrecords;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ComplaintRecordsRepositoryTest {

    ComplaintRecordsRepository complaintRecordsRepository = new ComplaintRecordsRepository();

    @Test
    public void findAll() {
        List<Complaintrecords> complaintrecords = complaintRecordsRepository.findAll();
        for(Complaintrecords complaintrecord : complaintrecords)
        {
            System.out.println(complaintrecord.getSummary());
        }
    }

    @Test
    public void countAll() {
        assertEquals(Long.valueOf(1),complaintRecordsRepository.countAll());
    }

    @Test
    public void find() {
        assertEquals("Water Tap Leaking",(complaintRecordsRepository.find(1)).getSummary());
    }

    @Test
    public void create() {
        Complaintrecords complaintrecords = new Complaintrecords();
        complaintrecords.setComplaintId(1);
        complaintrecords.setOwnerId(4);
        complaintrecords.setSummary("Gyser Not Working");
        complaintRecordsRepository.create(complaintrecords);
    }

    @Test
    public void delete() {
        complaintRecordsRepository.delete(1);
    }
}