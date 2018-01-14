package bawei.com.sunyandong20171221.Modle;


import java.util.HashMap;

import bawei.com.sunyandong20171221.Bean.MsgBean;
import bawei.com.sunyandong20171221.Bean.ShopCarBean;
import bawei.com.sunyandong20171221.net.NetWorkListener;

/**
 * Created by ZMoffice on 2018.1.8.
 */

public interface IMainModle {
    //展示购物车数据
    public void postCar(String uid, NetWorkListener<ShopCarBean> netWorkListener);
    //删除购物车
    public void postDelCar(HashMap<String, String> hashMap, NetWorkListener<MsgBean> netWorkListener);
    //更新购物车
    public void postUpdaterCar(HashMap<String, String> hashMap, NetWorkListener<MsgBean> netWorkListener);
}
