package com.raka.myapp2.employeeform;

import com.raka.myapp2.model.Employee;

interface EmployeeContracts {
    interface view {
        String getNik();

        String getFullName();

        String getBirthDate();

        String getBirthPlace();

        Boolean getReading();

        Boolean getTravelling();

        String getAddress();

        String getGender();

        void showWarning(String message);

        void closeWarning();

        void setTextDate(String date);


        void showToast();
        void openMapActivity();
    }

    interface repository {
        Boolean checkEmployee(Employee data);

        void insertEmployee(Employee data);
    }

    interface presenter {
        void onSubmit();

        String convertDate(int month);
    }
}
