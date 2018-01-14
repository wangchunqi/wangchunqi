package bawei.com.sunyandong20171221.Modle;


import bawei.com.sunyandong20171221.Bean.Bean2;
import bawei.com.sunyandong20171221.utils.Inters;
import bawei.com.sunyandong20171221.utils.UtilsURL;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ZMoffice on 2018.1.8.
 */

public class Imodel2 implements IHmode1{
    @Override
    public void Shar1(final HomeBake1 bake1) {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(UtilsURL.BASE_HOST_URL1)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Inters serviceAPI = retrofit.create(Inters.class);
        final Call<Bean2> bean = serviceAPI.You();

        bean.enqueue(new Callback<Bean2>() {
            @Override
            public void onResponse(Call<Bean2> call, Response<Bean2> response) {
                Bean2 bean2=response.body();
                bake1.Success(bean2);
            }

            @Override
            public void onFailure(Call<Bean2> call, Throwable t) {

            }
        });
    }
}
