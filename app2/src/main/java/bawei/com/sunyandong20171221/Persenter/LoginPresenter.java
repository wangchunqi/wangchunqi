package bawei.com.sunyandong20171221.Persenter;

import android.os.Handler;

import bawei.com.sunyandong20171221.Modle.LoginModel;
import bawei.com.sunyandong20171221.Modle.LoginModelImpl;
import bawei.com.sunyandong20171221.Bean.User;
import bawei.com.sunyandong20171221.View.LoginView;

/**
 * Created by 悻 on 2017/12/21.
 */

public class LoginPresenter {
    private LoginView loginView;
    private LoginModel loginModel;
    private Handler mHandler;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
        loginModel = new LoginModelImpl();
        mHandler = new Handler();
    }

    public void login() {
        loginView.showLoading();
        loginModel.login(loginView.getUsername(), loginView.getPassword(), new LoginModel.OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                //模拟登录成功后，返回信息到Activity,吐出成功信息
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.showSuccessMsg(user);
                        loginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed(final String s) {
                //模拟登录失败后，返回信息，吐出错误信息
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.showFailedMsg(s);
                        loginView.hideLoading();
                    }
                });
            }
        },loginView.context());
    }

    public void clear(){
        loginView.clearEditText();
    }
}