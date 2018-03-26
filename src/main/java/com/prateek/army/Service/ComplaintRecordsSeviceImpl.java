package com.prateek.army.Service;

import com.prateek.army.Repository.ComplaintRecordsRepository;
import com.prateek.army.model.Complaintrecords;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ComplaintRecordsSeviceImpl implements ComplaintRecordsSevice {

    private ComplaintRecordsRepository  complaintRecordsRepository = new ComplaintRecordsRepository();

    @Override
    public List<Integer> getComplaintId() {

        List<Complaintrecords> complaintrecords = complaintRecordsRepository.findAll();
        List<Integer> complaintNo = new ArrayList<>();
        for(Complaintrecords complaints : complaintrecords)
        {
            complaintNo.add(complaints.getComplaintId());
        }

        return complaintNo;
    }

    @Override
    public List<String> getSummary() {

        List<Complaintrecords> complaintrecords = complaintRecordsRepository.findAll();
        List<String> summary = new ArrayList<>();
        for(Complaintrecords complaints : complaintrecords)
        {
            summary.add(complaints.getSummary());
        }

        return summary;
    }

    public List<Complaintrecords> addComplaint(Complaintrecords complaintrecords) {
        complaintrecords.setCreated(new Timestamp(System.currentTimeMillis()));
        complaintRecordsRepository.create(complaintrecords);
        return complaintRecordsRepository.findAll();
    }
}