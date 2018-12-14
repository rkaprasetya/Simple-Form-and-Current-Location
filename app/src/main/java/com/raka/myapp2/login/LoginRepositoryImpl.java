package com.raka.myapp2.login;

import android.content.Context;

import com.raka.myapp2.database.DBHandler;
import com.raka.myapp2.model.UserAccount;

public class LoginRepositoryImpl implements LoginContracts.repository {
    private Context mContext;
    public LoginRepositoryImpl(Context context) {
        mContext = context;
    }

    @Override
    public Boolean checkLogin(UserAccount acc) {
        DBHandler handler = new DBHandler(mContext, null,null,1);
        Boolean result = handler.selectAccountHandler(acc);
        return result;
    }
}
