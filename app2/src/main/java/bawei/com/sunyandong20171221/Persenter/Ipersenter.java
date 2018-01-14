package bawei.com.sunyandong20171221.Persenter;

import bawei.com.sunyandong20171221.Bean.Beanlb;
import bawei.com.sunyandong20171221.Modle.IHmodle;
import bawei.com.sunyandong20171221.Modle.Imodle;
import bawei.com.sunyandong20171221.View.IFenView;

/**
 * Created by 悻 on 2017/12/21.
 */

public class Ipersenter {
    private Imodle imodle;
    private IFenView iFenView;

    public Ipersenter(IFenView iFenView) {
        this.iFenView = iFenView;
        imodle =new Imodle();
    }

    public void Shaddd(){
        imodle.Shard(new IHmodle.HomeBake() {
            @Override
            public void Success(Beanlb beanlb) {
                iFenView.onZuo(beanlb);
            }
        });
    }
}
