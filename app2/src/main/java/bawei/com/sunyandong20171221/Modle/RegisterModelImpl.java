package bawei.com.sunyandong20171221.Modle;

import android.content.Context;
import android.content.SharedPreferences;

import bawei.com.sunyandong20171221.Bean.User;

/**
 * Created by 悻 on 2017/12/21.
 */

public class RegisterModelImpl implements RegisterModel{
    @Override
    public void register(final String username, final String password, final OnRegisterListener onRegisterListener, Context context) {
        final SharedPreferences user = context.getSharedPreferences("user", Context.MODE_APPEND);
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(3000);

                    if (username.isEmpty() || password.isEmpty()) {
                        onRegisterListener.registerFailed("用户或密码不能为空");
                        return;
                    }
                    if (username.equals(user.getString("name", ""))) {
                        onRegisterListener.registerFailed("用户已存在");
                    } else {
                        onRegisterListener.registerSuccess(new User(username, password));
                        SharedPreferences.Editor edit = user.edit();
                        edit.putString("name", username);
                        edit.putString("pwd", password);
                        edit.commit();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
    }

