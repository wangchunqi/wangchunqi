package bawei.com.sunyandong20171221.Persenter;

import android.content.Context;

import bawei.com.sunyandong20171221.Bean.Add;
import bawei.com.sunyandong20171221.Modle.IModel22;
import bawei.com.sunyandong20171221.Modle.Shixian2;
import bawei.com.sunyandong20171221.View.Iview2;
import bawei.com.sunyandong20171221.net.NetWorkListener;


/**
 * Created by ZMoffice on 2018.1.8.
 */

public class P3 {
    Iview2 iview2;
    IModel22 imodel2;
    Context context;

String pid;

    public P3(Iview2 iview2, Context context, String pid) {
        this.iview2 = iview2;
        this.context = context;
        imodel2=new Shixian2();
        this.pid = pid;
    }

    public void getadd()
    {
        imodel2.getAdd(pid,new NetWorkListener<Add>() {
            @Override
            public void onError(Exception e) {

            }

            @Override
            public void onSuccess(Add detail) {
                iview2.getbean(detail);
            }
        });
    }
}
