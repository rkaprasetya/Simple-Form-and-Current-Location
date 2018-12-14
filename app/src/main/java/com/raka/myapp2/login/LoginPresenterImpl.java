package com.raka.myapp2.login;

import com.raka.myapp2.model.UserAccount;

public class LoginPresenterImpl implements LoginContracts.presenter {
    private LoginContracts.view view;
    private LoginContracts.repository repo;
    public LoginPresenterImpl(LoginContracts.view view, LoginContracts.repository repo) {
        this.view = view;
        this.repo = repo;
    }

    @Override
    public void checkLogin() {
        UserAccount account = new UserAccount();
       if (view.getUname().isEmpty()){
           view.showWarning("Please fill all the fields");
       } else if (view.getPassword().isEmpty()){
           view.showWarning("Please fill all the fields");
       }else{
           account.setUname(view.getUname());
           account.setPassword(view.getPassword());
           Boolean result = repo.checkLogin(account);
           if (!result){
               view.showWarning("Username or Password is wrong");
           }else{
                    view.showToast();
                   view.openEmployeeActivity();
           }
       }
    }
}
