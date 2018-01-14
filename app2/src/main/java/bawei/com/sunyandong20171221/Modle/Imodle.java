package bawei.com.sunyandong20171221.Modle;

import bawei.com.sunyandong20171221.Bean.Beanlb;
import bawei.com.sunyandong20171221.utils.Inters;
import bawei.com.sunyandong20171221.utils.UtilsURL;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 悻 on 2017/12/21.
 */

public class Imodle implements IHmodle{
    @Override
    public void Shard(final HomeBake bake) {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(UtilsURL.BASE_HOST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Inters serviceAPI = retrofit.create(Inters.class);
        final Call<Beanlb> bean = serviceAPI.Zuo();

        bean.enqueue(new Callback<Beanlb>() {
            @Override
            public void onResponse(Call<Beanlb> call, Response<Beanlb> response) {
                Beanlb beanlb=response.body();
                bake.Success(beanlb);
            }

            @Override
            public void onFailure(Call<Beanlb> call, Throwable t) {

            }
        });
    }
}
