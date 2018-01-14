package bawei.com.sunyandong20171221.Modle;


import bawei.com.sunyandong20171221.Bean.Add;
import bawei.com.sunyandong20171221.net.NetWorkListener;
import bawei.com.sunyandong20171221.utils.RetrofitHelper;
import bawei.com.sunyandong20171221.utils.ServerApi;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ZMoffice on 2018.1.8.
 */

public class Shixian2 implements IModel22 {
    @Override
    public void getAdd(String pid,final NetWorkListener<Add> netWorkListener) {
        ServerApi serverApi = RetrofitHelper.getServerApi();
        serverApi.getadd(pid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Add>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Add detail) {
                        netWorkListener.onSuccess(detail);
                    }
                });
    }

}
