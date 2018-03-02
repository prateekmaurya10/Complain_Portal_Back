package com.prateek.army.Service;

import com.prateek.army.Repository.ComplaintTypeRepository;
import com.prateek.army.model.Complainttype;

import java.util.ArrayList;
import java.util.List;

public class ComplaintTypeServiceImpl implements ComplaintTypeService {

    private ComplaintTypeRepository complaintTypeRepository = new ComplaintTypeRepository();

    @Override
    public List<String> getComplaintTypes() {
        List<Complainttype> complaintTypes = complaintTypeRepository.findAll();
        List<String> complaints = new ArrayList<>();
        for(Complainttype complainttype : complaintTypes)
        {
            complaints.add(complainttype.getComplaintType());
        }
        return complaints;
    }
}
