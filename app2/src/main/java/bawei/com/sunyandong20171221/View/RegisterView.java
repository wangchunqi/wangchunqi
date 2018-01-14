package bawei.com.sunyandong20171221.View;

import android.content.Context;

import bawei.com.sunyandong20171221.Bean.User;

/**
 * Created by 悻 on 2017/12/21.
 */

public interface RegisterView {
    //得到用户填写的信息
    String getUsername();
    String getPassword();

    Context context();
    //显示和隐藏登录ProgressBar
    void showLoading();
    void hideLoading();

    //注册成功或失败后，返回信息的方法
    void showSuccessMsg(User user);
    void showFailedMsg(String s);

    //清除数据
    void clearEditText();
}
