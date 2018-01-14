package bawei.com.sunyandong20171221.Persenter;


import java.util.HashMap;

import bawei.com.sunyandong20171221.Bean.MsgBean;
import bawei.com.sunyandong20171221.Bean.ShopCarBean;
import bawei.com.sunyandong20171221.Modle.IMainModle;
import bawei.com.sunyandong20171221.Modle.MainModle;
import bawei.com.sunyandong20171221.View.IMainActivity;
import bawei.com.sunyandong20171221.net.NetWorkListener;
import bawei.com.sunyandong20171221.utils.Api;

/**
 * Created by ZMoffice on 2018.1.8.
 */

public class MainPresenter {
    IMainActivity iMainActivity;
    IMainModle iMainModle;

    public MainPresenter(IMainActivity iMainActivity) {
        this.iMainActivity = iMainActivity;
        iMainModle=new MainModle();
    }

    //购物车数据
    public void postShopCar()
    {
        iMainModle.postCar(Api.uid, new NetWorkListener<ShopCarBean>() {
            @Override
            public void onError(Exception e) {

            }

            @Override
            public void onSuccess(ShopCarBean shopCarBean) {
                iMainActivity.showShopCar(shopCarBean);
            }
        });
    }
    //删除购物车
    public void postDelCar(String uid,String pid)
    {
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("uid",uid);
        hashMap.put("pid",pid);
        iMainModle.postDelCar(hashMap, new NetWorkListener<MsgBean>() {
            @Override
            public void onError(Exception e) {

            }

            @Override
            public void onSuccess(MsgBean msgBean) {
                iMainActivity.showDelCar(msgBean);
            }
        });
    }

    //
    public void doDview()
    {
        iMainActivity=null;
    }
}
