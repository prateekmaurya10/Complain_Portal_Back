package com.prateek.army.Service;

import com.prateek.army.model.Login;

public interface LoginService {

    void addLogin(Login login);

    Login retrieveLoginObj(String emailAddress, String password);
}
