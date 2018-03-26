package com.prateek.army.Repository.com.prateek.army;

import com.prateek.army.Repository.LoginRepository;
import com.prateek.army.model.Login;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LoginRepositoryTest {

    LoginRepository loginRepository = new LoginRepository();

    @Test
    public void findAll() {
        List<Login> logins = loginRepository.findAll();
        for(Login login : logins)
        {
            System.out.println(login.getEmailId());
        }
    }

    @Test
    public void countAll() {
        assertEquals(Long.valueOf(0),loginRepository.countAll());
    }

    @Test
    public void find(){
        assertEquals(null,(loginRepository.find(3)));
    }

    @Test
    public void create() {
//        Owners owner = new Owners();
//        owner.setFirstName("Prateek");
//        owner.setMiddleName("Kumar");
//        owner.setLastName("Maurya");
//        owner.setRank("Major");
//        owner.setQtrsId(1);
//        ownersRepository.create(owner);

        Login login = new Login();
        login.setEmailId("prateekmaurya10@gmail.com");
        login.setOwnerId(1);
        login.setPassword("jsdcnsk");
        loginRepository.create(login);
    }

    @Test
    public void delete(){
        loginRepository.delete(4);
    }
}
