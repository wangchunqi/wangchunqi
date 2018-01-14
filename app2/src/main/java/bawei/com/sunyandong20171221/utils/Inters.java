package bawei.com.sunyandong20171221.utils;

import bawei.com.sunyandong20171221.Bean.Bean2;
import bawei.com.sunyandong20171221.Bean.Beanlb;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 悻 on 2017/12/21.
 */

public interface Inters {
    @GET(UtilsURL.TAGS)
    Call<Beanlb> Zuo();

    @GET(UtilsURL.TAGS1)
    Call<Bean2> You();
}
