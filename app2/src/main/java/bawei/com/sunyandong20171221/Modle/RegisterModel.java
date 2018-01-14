package bawei.com.sunyandong20171221.Modle;

import android.content.Context;

import bawei.com.sunyandong20171221.Bean.User;

/**
 * Created by 悻 on 2017/12/21.
 */

public interface RegisterModel {
    void register(String username, String password, OnRegisterListener onRegisterListener, Context context);

    interface OnRegisterListener {
        void registerSuccess(User user);

        void registerFailed(String s);
    }
}