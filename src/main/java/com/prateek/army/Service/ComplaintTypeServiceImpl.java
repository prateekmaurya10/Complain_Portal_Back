package com.prateek.army.Service;

import com.prateek.army.Repository.ComplaintTypeRepository;
import com.prateek.army.model.Complainttype;

import java.util.List;

public class ComplaintTypeServiceImpl implements ComplaintTypeService {

    private ComplaintTypeRepository complaintTypeRepository = new ComplaintTypeRepository();

    @Override
    public List<Complainttype> getComplaintTypes() {
        List<Complainttype> complaintTypes = complaintTypeRepository.findAll();
        return(complaintTypes);
        /*List<String> complaints = new ArrayList<>();
        for(Complainttype complainttype : complaintTypes)
        {
            complaints.add(complainttype.getComplaintType());
        }
        return complaints;
*/    }
}
