package com.prateek.army.Service;

import com.prateek.army.Utility.LoginUtility;
import com.prateek.army.model.Login;
import com.prateek.army.model.Owners;

public class SignUpServiceImpl implements SignUpService {

    private OwnersService ownersService = new OwnersServiceImpl();
    private LoginService loginService = new LoginServiceImpl();

    @Override
    public LoginUtility loginInsert(LoginUtility loginUtility) {

        Owners owner = loginUtility.createOwnerObj(loginUtility);
        ownersService.addOwner(owner);

        Login loginObj = loginUtility.createLoginObj(loginUtility, owner);
        loginService.addLogin(loginObj);

        return loginUtility;
    }
}

//    private void insertLogin(LoginUtility loginUtility, Owners owner) {
//        Login login = new Login();
//        login.setEmailId(loginUtility.getEmailAddress());
//        login.setPassword(loginUtility.getPassword());
//        login.setOwnerId(getOwnerId(owner));
//
//        loginService.addLogin(login);
//    }
//
//    private Owners insertOwner(LoginUtility loginUtility) {
//
//        //Get qtrId by using below methods
//        int qtrId = getQtrId(getAreaId(loginUtility.getArea()),loginUtility.getQtrNo());
//
//        Owners owner = new Owners();
//        owner.setFirstName(loginUtility.getFirstName());
//        owner.setMiddleName(loginUtility.getMiddleName());
//        owner.setLastName(loginUtility.getLastName());
//        owner.setRank(loginUtility.getRank());
//        owner.setQtrsId(qtrId);
//
//        ownersService.addOwner(owner);
//        return owner;
//    }
//
//
//    //Get Area Id which will be used to get the qtr Id.
//    public int getAreaId(String areaName){
//        AreaService areaService = new AreaServiceImpl();
//        List<Area> areas = areaService.getAreas();
//        int areaId = 0;
//        for(Area area : areas){
//            if(area.getAreaName() == areaName)
//                areaId = area.getId();
//        }
//        return areaId;
//    }
//
//    //Get QtrId to be inserted in Owners table.
//    public int getQtrId(int areaId,int qtrNo){
//        QtrsService qtrsService = new QtrsServiceImpl();
//        List<Qtrs> qtrs = qtrsService.getQtrsByArea(areaId);
//        int qtrId = 0;
//        for(Qtrs qtr :qtrs){
//            if(qtr.getQtrNo() == qtrNo)
//                qtrId = qtr.getId();
//        }
//        return qtrId;
//    }
//
//    // Retrieve Owner Id.
//    public int getOwnerId(Owners owner){
//        List<Owners> allOwners = ownersService.findOwners();
//        int ownerId = 0;
//        for(Owners owner1 : allOwners){
//            if(owner1 == owner)
//                ownerId = owner1.getId();
//        }
//        return ownerId;
//    }
