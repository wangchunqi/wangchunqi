package bawei.com.sunyandong20171221.Persenter;

import android.content.Context;

import bawei.com.sunyandong20171221.Bean.Detail;
import bawei.com.sunyandong20171221.Modle.Imodel;
import bawei.com.sunyandong20171221.Modle.Shixian;
import bawei.com.sunyandong20171221.View.Iview;
import bawei.com.sunyandong20171221.net.NetWorkListener;


/**
 * Created by ZMoffice on 2018.1.8.
 */

public class P2 {
    Iview iview;
    Imodel imodel;
    Context context;

    public P2(Iview iview, Context context) {
        this.iview = iview;
        this.context = context;
        imodel=new Shixian();
    }
    public void getdetail()
    {
        imodel.getdetail(new NetWorkListener<Detail>() {
            @Override
            public void onError(Exception e) {

            }

            @Override
            public void onSuccess(Detail detail) {
                   iview.getbean(detail);
            }
        });
    }
}
