package com.raka.myapp2.login;

import com.raka.myapp2.model.UserAccount;

public interface LoginContracts {
    interface view{
         String getUname();
         String getPassword();
         void showWarning(String message);
         void openEmployeeActivity();
         void showToast();
    }
    interface presenter{
         void checkLogin();
    }
    interface repository{
             Boolean checkLogin(UserAccount acc);
    }
}
