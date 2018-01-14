package bawei.com.sunyandong20171221.utils;


import java.util.HashMap;

import bawei.com.sunyandong20171221.Bean.Add;
import bawei.com.sunyandong20171221.Bean.Detail;
import bawei.com.sunyandong20171221.Bean.MsgBean;
import bawei.com.sunyandong20171221.Bean.ShopCarBean;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by ZMoffice on 2018.1.8.
 */

public interface ServerApi {
    //查询购物车
    @POST(Api.SHOPCAR)
    Observable<ShopCarBean> shopCall(@Query("uid") String uid);
    //删除购物车
    @POST(Api.DELETECAR)
    Observable<MsgBean> msgCall(@QueryMap HashMap<String, String> hashMap);
    //更新购物车
    Observable<MsgBean> UpdaterCall(@QueryMap HashMap<String, String> hashMap);
    @GET("https://www.zhaoapi.cn/product/getProductDetail?pid=79&code=1")
    Observable<Detail> getxq();
    @GET("https://www.zhaoapi.cn/product/addCart?uid=4877&&token=416FAE4716C1A3832C42C4E7A8B20860")
    Observable<Add> getadd(@Query("pid") String pid);
}
