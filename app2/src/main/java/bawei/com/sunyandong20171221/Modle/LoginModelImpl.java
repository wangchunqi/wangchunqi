package bawei.com.sunyandong20171221.Modle;

import android.content.Context;
import android.content.SharedPreferences;

import bawei.com.sunyandong20171221.Bean.User;

/**
 * Created by 悻 on 2017/12/21.
 */

public class LoginModelImpl implements LoginModel{
    @Override
    public void login(final String username, final String password, final OnLoginListener onLoginListener, Context context) {
        final SharedPreferences user = context.getSharedPreferences("user", Context.MODE_APPEND);
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(3000);
                    if (username.isEmpty()||password.isEmpty()){
                        onLoginListener.loginFailed("Incorrect username or password.");
                        return;

                    }
                    if (username.equals(user.getString("name","")) && password.equals(user.getString("pwd",""))) {
                        onLoginListener.loginSuccess(new User(username,password));
                    } else {
                        onLoginListener.loginFailed("Incorrect username or password.");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
    }

