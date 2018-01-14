package bawei.com.sunyandong20171221.Modle;

import android.content.Context;

import bawei.com.sunyandong20171221.Bean.User;

/**
 * Created by 悻 on 2017/12/21.
 */

public interface LoginModel {
    void login(String username, String password, OnLoginListener onLoginListener, Context context);

    interface OnLoginListener {
        void loginSuccess(User user);

        void loginFailed(String s);
    }
}
