package com.raka.myapp2.employeeform;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.raka.myapp2.MapsActivity;
import com.raka.myapp2.R;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EmployeeActivity extends AppCompatActivity implements EmployeeContracts.view, DatePickerDialog.OnDateSetListener {


    @BindView(R.id.tv_personal_edit_title)
    TextView tvPersonalEditTitle;
    @BindView(R.id.btn_personal_edit_close)
    RelativeLayout btnPersonalEditClose;
    @BindView(R.id.app_bar_personal_edit)
    AppBarLayout appBarPersonalEdit;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.tv_personal_warning)
    TextView tvPersonalWarning;
    @BindView(R.id.btn_personal_warning_close)
    ImageView btnPersonalWarningClose;
    @BindView(R.id.rl_personal_warning)
    RelativeLayout rlPersonalWarning;
    @BindView(R.id.tv_personal_edit_position)
    TextView tvPersonalEditPosition;
    @BindView(R.id.et_personal_name)
    EditText etPersonalName;
    @BindView(R.id.tv_personal_nik)
    TextView tvPersonalNik;
    @BindView(R.id.et_personal_nik)
    EditText etPersonalNik;
    @BindView(R.id.tv_personal_birth)
    TextView tvPersonalBirth;
    @BindView(R.id.et_personal_birth)
    EditText etPersonalBirth;
    @BindView(R.id.tv_birth_title)
    TextView tvBirthTitle;
    @BindView(R.id.tv_birth_hint)
    TextView tvBirthHint;
    @BindView(R.id.btn_personal_date)
    RelativeLayout btnPersonalDate;
    @BindView(R.id.tv_personal_gender)
    TextView tvPersonalGender;
    @BindView(R.id.tv_hobby_title)
    TextView tvHobbyTitle;
    @BindView(R.id.cb_travel)
    CheckBox cbTravel;
    @BindView(R.id.cb_reading)
    CheckBox cbReading;

    @BindView(R.id.rl_hobby)
    RelativeLayout rlHobby;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.et_contact_address)
    EditText etContactAddress;
    @BindView(R.id.sv_personal_info)
    ScrollView svPersonalInfo;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    @BindView(R.id.spinner)
    Spinner spinner;
    private EmployeeRepositoryImpl repo = new EmployeeRepositoryImpl(this);
    private EmployeePresenterImpl presenter = new EmployeePresenterImpl(this, repo);
    private String gender = "";
    private DatePickerDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        ButterKnife.bind(this);
        //initRadioGroupListener();
        initSpinner();
        initCalendar();
    }


    @Override
    public String getNik() {
        return etPersonalNik.getText().toString().trim();
    }

    @Override
    public String getFullName() {
        return etPersonalName.getText().toString().trim();
    }

    @Override
    public String getBirthDate() {
        return tvBirthHint.getText().toString().trim();
    }

    @Override
    public String getBirthPlace() {
        return tvBirthHint.getText().toString().trim();
    }

    @Override
    public Boolean getReading() {
        return cbReading.isChecked();
    }

    @Override
    public Boolean getTravelling() {
        return cbTravel.isChecked();
    }


    @Override
    public String getAddress() {
        return etContactAddress.getText().toString().trim();
    }

    @Override
    public String getGender() {
        return spinner.getSelectedItem().toString();
    }

    @Override
    public void showWarning(String message) {
        rlPersonalWarning.setVisibility(View.VISIBLE);
        tvPersonalWarning.setText(message);

    }

    @Override
    public void closeWarning() {
        rlPersonalWarning.setVisibility(View.GONE);
    }

    @Override
    public void setTextDate(String date) {
        tvBirthHint.setText(date);
        tvBirthHint.setTextColor(getResources().getColor(R.color.black));
    }

    private void initSpinner() {
        String[] items = new String[]{"Choose Gender", "Male", "Female"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinner.setAdapter(adapter);
    }

    @Override
    public void showToast() {
        Toast.makeText(this, "Input Data succeed!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void openMapActivity() {
        Intent i = new Intent(this, MapsActivity.class);
        startActivity(i);
    }

    @OnClick({R.id.btn_personal_edit_close, R.id.btn_personal_warning_close, R.id.btn_personal_date, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_personal_edit_close:
                closeWarning();
                break;
            case R.id.btn_personal_warning_close:
                closeWarning();
                break;
            case R.id.btn_personal_date:
                dialog.show();
                break;
            case R.id.btn_submit:
                presenter.onSubmit();
                break;
        }
    }

    private void initCalendar() {
        dialog = new DatePickerDialog(this, this, 1940, Calendar.MONTH, Calendar.DAY_OF_MONTH);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String mDate = Integer.toString(dayOfMonth) + " " + presenter.convertDate(month) + " " + year;
        if (mDate != "") {
            setTextDate(mDate);
        }
    }

}