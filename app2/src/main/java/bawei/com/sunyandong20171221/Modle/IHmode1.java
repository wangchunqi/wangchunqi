package bawei.com.sunyandong20171221.Modle;

import bawei.com.sunyandong20171221.Bean.Bean2;

/**
 * Created by 悻 on 2017/12/21.
 */

public interface IHmode1 {

    void Shar1(HomeBake1 bake1);

    interface HomeBake1 {
        void Success(Bean2 bean2);
    }
}
