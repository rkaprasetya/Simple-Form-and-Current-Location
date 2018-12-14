package com.raka.myapp2.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.raka.myapp2.R;
import com.raka.myapp2.employeeform.EmployeeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginContracts.view {

    @BindView(R.id.et_login_username)
    EditText etLoginUsername;
    @BindView(R.id.tv_login_warning)
    TextView tvLoginWarning;
    @BindView(R.id.btn_login_warning_close)
    ImageView btnLoginWarningClose;
    @BindView(R.id.rl_login_warning)
    RelativeLayout rlLoginWarning;
    @BindView(R.id.et_login_password)
    EditText etLoginPassword;
    @BindView(R.id.rl_old_password)
    RelativeLayout rlOldPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.progress_login)
    ProgressBar progressLogin;
    private LoginRepositoryImpl repo = new LoginRepositoryImpl(this);
    private LoginPresenterImpl presenter = new LoginPresenterImpl(this, repo);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @Override
    public String getUname() {
        return etLoginUsername.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return etLoginPassword.getText().toString().trim();
    }

    @Override
    public void showWarning(String message) {
        rlLoginWarning.setVisibility(View.VISIBLE);
        tvLoginWarning.setText(message);
    }

    @Override
    public void openEmployeeActivity() {
        Intent i = new Intent(this, EmployeeActivity.class);
        startActivity(i);
    }

    @Override
    public void showToast() {
        Toast.makeText(this, "Login succeedd!", Toast.LENGTH_SHORT).show();
    }

    private void hideWarning() {
        rlLoginWarning.setVisibility(View.GONE);
    }
    @OnClick({R.id.btn_login_warning_close, R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login_warning_close:
                hideWarning();
                break;
            case R.id.btn_login:
                presenter.checkLogin();
                break;
        }
    }
}