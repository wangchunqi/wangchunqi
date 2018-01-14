package bawei.com.sunyandong20171221.View;


import bawei.com.sunyandong20171221.Bean.MsgBean;
import bawei.com.sunyandong20171221.Bean.ShopCarBean;

/**
 * Created by ZMoffice on 2018.1.8.
 */

public interface IMainActivity {
    //展示购物车数据
    public void showShopCar(ShopCarBean shopCarBean);
    //删除购物车数据
    public void showDelCar(MsgBean msgBean);
}
