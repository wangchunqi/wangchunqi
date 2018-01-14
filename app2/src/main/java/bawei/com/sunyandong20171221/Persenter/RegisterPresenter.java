package bawei.com.sunyandong20171221.Persenter;

import android.os.Handler;

import bawei.com.sunyandong20171221.Modle.RegisterModel;
import bawei.com.sunyandong20171221.Modle.RegisterModelImpl;
import bawei.com.sunyandong20171221.Bean.User;
import bawei.com.sunyandong20171221.View.RegisterView;

/**
 * Created by 悻 on 2017/12/21.
 */

public class RegisterPresenter {
    private RegisterView registerView;
    private RegisterModelImpl registerModelImpl;
    private Handler mHandler;

    public RegisterPresenter(RegisterView registerView) {
        this.registerView = registerView;
        registerModelImpl = new RegisterModelImpl();
        mHandler = new Handler();
    }

    public void register() {
        registerView.showLoading();
        registerModelImpl.register(registerView.getUsername(), registerView.getPassword(), new RegisterModel.OnRegisterListener() {
            @Override
            public void registerSuccess(final User user) {
                //模拟注册成功后，返回信息到Activity,吐出成功信息
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        registerView.showSuccessMsg(user);
                        registerView.hideLoading();
                    }
                });
            }

            @Override
            public void registerFailed(final String s) {

                //模拟注册失败后，返回信息，吐出错误信息
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        registerView.showFailedMsg(s);
                        registerView.hideLoading();
                    }
                });
            }
        }, registerView.context());
    }

    public void clear() {
        registerView.clearEditText();
    }
}

