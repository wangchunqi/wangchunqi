package bawei.com.sunyandong20171221;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import bawei.com.sunyandong20171221.Bean.User;
import bawei.com.sunyandong20171221.Persenter.RegisterPresenter;
import bawei.com.sunyandong20171221.View.RegisterView;

public class RegisterActivity extends AppCompatActivity implements RegisterView{
    private ImageView align;
    private ProgressBar progressBar;
    private EditText et_password;
    private EditText et_userName;
    private RegisterPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        align = (ImageView) findViewById(R.id.align);
        progressBar = (ProgressBar) findViewById(R.id.main_progressBar);
        et_password = (EditText) findViewById(R.id.main_et_password);
        et_userName = (EditText) findViewById(R.id.main_et_username);
      TextView tv1= (TextView) findViewById(R.id.xyhzc);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(RegisterActivity.this,MainActivity2.class);
                startActivity(it);
            }
        });

        presenter = new RegisterPresenter(this);
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
        Toast.makeText(RegisterActivity.this, "用户 " + user.getUsername() + " 登陆成功", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void showFailedMsg(String s) {
        Toast.makeText(RegisterActivity.this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearEditText() {
        et_userName.setText("");
        et_password.setText("");
    }

    public void RegisterClick(View view) {
        presenter.register();
        Intent it=new Intent(RegisterActivity.this,MainActivity3.class);
        startActivity(it);
    }
}
