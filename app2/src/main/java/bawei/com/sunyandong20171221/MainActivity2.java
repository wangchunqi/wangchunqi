package bawei.com.sunyandong20171221;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import bawei.com.sunyandong20171221.Bean.User;
import bawei.com.sunyandong20171221.Persenter.LoginPresenter;
import bawei.com.sunyandong20171221.View.LoginView;

public class MainActivity2 extends AppCompatActivity implements LoginView{
    private EditText et_userName;
    private EditText et_password;
    private ProgressBar progressBar;
    private LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initview();
        loginPresenter = new LoginPresenter(this);
    }

    private void initview() {
        et_userName = (EditText) findViewById(R.id.main_et_username);
        et_password = (EditText) findViewById(R.id.main_et_password);
        progressBar = (ProgressBar) findViewById(R.id.main_progressBar);
    }

    @Override
    public String getUsername() {
        return et_userName.getText().toString();
    }

    @Override
    public String getPassword() {
        return et_password.getText().toString();
    }

    @Override
    public Context context() {
        return this;
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showSuccessMsg(User user) {
        Toast.makeText(MainActivity2.this, "User " + user.getUsername() + " Login Sccess!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedMsg(String s) {
        Toast.makeText(MainActivity2.this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearEditText() {
        et_userName.setText("");
        et_password.setText("");

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
    public void Register(View view) {

        startActivity(new Intent(this,RegisterActivity.class));
        Toast.makeText(MainActivity2.this,"注册成功",Toast.LENGTH_LONG).show();
    }
}
