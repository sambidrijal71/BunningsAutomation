package com.planit.sdet.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.planit.sdet.model.pages.HomePage;

import org.junit.jupiter.api.Test;

public class SignUpTest extends BaseTest{
    
    @Test
    public  void validateSignUp(){
        var signUp=open(HomePage.class)
        .clickSignUpMenu()
        .setFirstName("sambid")
        .setLastName("rijal")
        .setEmail("sam@ab.com")
        .setPassword("Apple-1")
        .clickCheckBox()
        .clickCreateAccount();
    }

    @Test
    public  void validateSignUpError(){
        var signUp=open(HomePage.class)
        .clickSignUpMenu()
        .clickCreateAccount();
        var firstNameError=signUp.firstNameError();
        var lastNameerror=signUp.lastNameError();
        var emailError=signUp.emailError();
        var passwordError=signUp.passwordError();
        // var passwordHelper=signUp.passwordHelper();
        assertEquals("This field is required", firstNameError);
        assertEquals("This field is required", lastNameerror);
        assertEquals("This field is required", emailError);
        assertEquals("This field is required", passwordError);
        // assertEquals("At least 1 upper and 1 lower case letter
        // A number and a special character
        // Minimum 8 characters", passwordHelper);

    }
}
