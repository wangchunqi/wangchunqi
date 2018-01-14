package bawei.com.sunyandong20171221.Modle;

import bawei.com.sunyandong20171221.Bean.Beanlb;

/**
 * Created by 悻 on 2017/12/21.
 */

public interface IHmodle {

    void Shard(HomeBake bake);

    interface HomeBake {
        void Success(Beanlb beanlb);
    }

}
