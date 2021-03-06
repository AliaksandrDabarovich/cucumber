package com.epam.pageobject.service;

import com.epam.pageobject.model.User;

public class UserCreator {
    public static final String TESTDATA_USER_NAME = "testdata.user.name";
    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";
    public static User withCredentialsFromProperty(){
        return new User (TestDataReader.getTestData(TESTDATA_USER_NAME),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }
    public static User withEmptyUserName () {
        return new User ("", TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }
    public static User withEmptyPassword () {
        return new User (TestDataReader.getTestData(TESTDATA_USER_NAME), "");
    }

}
