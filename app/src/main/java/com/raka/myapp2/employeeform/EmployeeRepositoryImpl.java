package com.raka.myapp2.employeeform;

import android.content.Context;

import com.raka.myapp2.database.DBHandler;
import com.raka.myapp2.model.Employee;

public class EmployeeRepositoryImpl implements EmployeeContracts.repository {
    private Context mContext;
    public EmployeeRepositoryImpl(Context context) {
        mContext = context;
    }

    @Override
    public Boolean checkEmployee(Employee data) {
        DBHandler handler = new DBHandler(mContext, null,null,1);
        Boolean result = handler.checkNik(data);
        return result;
    }

    @Override
    public void insertEmployee(Employee data) {
        DBHandler handler = new DBHandler(mContext, null,null,1);
        handler.insertEmployeeHandler(data);
    }
}
