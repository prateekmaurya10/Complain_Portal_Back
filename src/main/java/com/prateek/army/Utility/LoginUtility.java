package com.prateek.army.Utility;
import com.prateek.army.Service.*;
import com.prateek.army.model.Login;
import com.prateek.army.model.Owners;

public class LoginUtility {

    private String firstName;
    private String lastName;
    private String middleName;
    private String emailAddress;
    private String password;
    private String area;
    private int qtrNo;
    private String rank;

    private OwnersService ownersService = new OwnersServiceImpl();
    private QtrsService qtrsService = new QtrsServiceImpl();
    private AreaService areaService = new AreaServiceImpl();

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getQtrNo() {
        return qtrNo;
    }

    public void setQtrNo(int qtrNo) {
        this.qtrNo = qtrNo;
    }

    public Login createLoginObj(LoginUtility loginUtility, Owners owner) {
        Login login = new Login();
        login.setEmailId(loginUtility.getEmailAddress());
        login.setPassword(loginUtility.getPassword());
        login.setOwnerId(ownersService.getOwnerId(owner));

        return login;
        //loginService.addLogin(login);
    }

    public Owners createOwnerObj(LoginUtility loginUtility){
        //int qtrId = qtrsService.getQtrId(areaService.getAreaId(loginUtility.getArea()),loginUtility.getQtrNo());

        Owners owner = new Owners();
        owner.setQtrsId(loginUtility.getQtrNo());
        owner.setFirstName(loginUtility.getFirstName());
        owner.setMiddleName(loginUtility.getMiddleName());
        owner.setLastName(loginUtility.getLastName());
        owner.setRank(loginUtility.getRank());

        return owner;
    }
}
