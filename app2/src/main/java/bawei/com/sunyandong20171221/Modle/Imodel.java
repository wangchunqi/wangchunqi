package bawei.com.sunyandong20171221.Modle;


import bawei.com.sunyandong20171221.Bean.Detail;
import bawei.com.sunyandong20171221.net.NetWorkListener;

/**
 * Created by ZMoffice on 2018.1.8.
 */

public interface Imodel {
    public void getdetail(NetWorkListener<Detail> netWorkListener);
}
