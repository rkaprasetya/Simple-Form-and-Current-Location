package com.raka.myapp2.employeeform;

import android.util.Log;

import com.raka.myapp2.model.Employee;

public class EmployeePresenterImpl implements EmployeeContracts.presenter  {
    private EmployeeContracts.view view;
    private EmployeeContracts.repository repo;
    public EmployeePresenterImpl(EmployeeContracts.view view, EmployeeContracts.repository repo) {
        this.view = view;
        this.repo = repo;
    }

    @Override
    public void onSubmit() {

        Log.e("here","okay"+view.getBirthDate());
        if (view.getNik().isEmpty()){
            view.showWarning("Please fill all the fields");
        }else if (view.getFullName().equals("")){
            view.showWarning("Please fill all the fields");
        }else if (view.getBirthPlace().equals("")){
            view.showWarning("Please fill all the fields");
        }else if (view.getBirthDate().equals("Birth of date") ){
            view.showWarning("Please fill all the fields");
        }else if (view.getGender().equals("Choose Gender")){
            view.showWarning("Please fill all the fields");
        }else if (!view.getReading() && !view.getTravelling()){
            view.showWarning("Please fill all the fields");
        }else if (view.getAddress().equals("")){
            view.showWarning("Please fill all the fields");
        }else{
            String hobby = "";
            if (view.getTravelling()){
                hobby = "Travelling";
            }
            if (view.getReading()){
                hobby = hobby + " Reading";
            }
            int nik = Integer.parseInt(view.getNik());
            Employee data = new Employee(nik,view.getFullName(),view.getBirthPlace(), view.getBirthDate(), view.getAddress(), hobby, view.getGender());
            if (repo.checkEmployee(data)){
                view.showWarning("NIK is taken! Please input another NIK");
            }else{
                repo.insertEmployee(data);
                view.showToast();
                view.openMapActivity();
            }
        }
    }

    @Override
    public String convertDate(int month) {
        switch (month){
            case 0 : return "January";
            case 1 :return "February";
            case 2 : return "March";
            case 3 : return "April";
            case 4 : return "May";
            case 5: return "June";
            case 6 :return "July";
            case 7 : return "August";
            case 8 :return "September";
            case 9 : return "October";
            case 10 : return "November";
            case 11 :return "December";
        }
        return null;
    }
}
