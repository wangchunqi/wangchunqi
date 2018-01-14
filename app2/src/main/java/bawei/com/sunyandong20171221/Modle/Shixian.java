package bawei.com.sunyandong20171221.Modle;


import bawei.com.sunyandong20171221.Bean.Detail;
import bawei.com.sunyandong20171221.net.NetWorkListener;
import bawei.com.sunyandong20171221.utils.RetrofitHelper;
import bawei.com.sunyandong20171221.utils.ServerApi;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ZMoffice on 2018.1.8.
 */

public class Shixian  implements Imodel{
    @Override
    public void getdetail(final NetWorkListener<Detail> netWorkListener) {
        ServerApi serverApi = RetrofitHelper.getServerApi();
        serverApi.getxq()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Detail>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Detail detail) {
                        netWorkListener.onSuccess(detail);
                    }
                });
    }
}
