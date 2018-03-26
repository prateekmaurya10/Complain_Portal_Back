package com.prateek.army.Service;

import com.prateek.army.Repository.LoginRepository;
import com.prateek.army.model.Login;

import java.util.List;

public class LoginServiceImpl implements LoginService {

    private LoginRepository  loginRepository = new LoginRepository();

    @Override
    public void addLogin(Login login) {
        loginRepository.create(login);
    }

    @Override
    public Login retrieveLoginObj(String emailAddress, String password){
        List<Login> logins = loginRepository.findAll();
        Login responseLogin = null;
        for(Login login : logins){
            if(login.getEmailId() == emailAddress && login.getPassword() == password)
                responseLogin = login;
        }
        return responseLogin;
    }
}
