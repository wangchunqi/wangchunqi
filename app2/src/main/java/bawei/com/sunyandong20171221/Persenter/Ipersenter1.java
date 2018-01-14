package bawei.com.sunyandong20171221.Persenter;

import bawei.com.sunyandong20171221.Bean.Bean2;
import bawei.com.sunyandong20171221.Modle.IHmode1;
import bawei.com.sunyandong20171221.Modle.Imodel2;
import bawei.com.sunyandong20171221.View.Iview1;

/**
 * Created by 悻 on 2017/12/21.
 */

public class Ipersenter1 {
    private Imodel2 imodel2;
    private Iview1 iview1;

    public Ipersenter1(Iview1 iview1) {
        this.iview1 = iview1;
        imodel2=new Imodel2();
    }

    public void Sharrrr(){
        imodel2.Shar1(new IHmode1.HomeBake1() {
            @Override
            public void Success(Bean2 bean2) {
                iview1.success(bean2);
            }
        });
    }
}
