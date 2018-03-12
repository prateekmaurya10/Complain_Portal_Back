package com.prateek.army.Service;

import com.prateek.army.model.Complaintrecords;

import java.util.List;

public interface ComplaintRecordsSevice {

    List<Integer> getComplaintId();

    public List<String> getSummary();

    public List<Complaintrecords> addComplaint(Complaintrecords complaintrecords);
}
