package bawei.com.sunyandong20171221.utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ZMoffice on 2018.1.8.
 */

public class RetrofitHelper {
    public static OkHttpClient okHttpClient;
    public static ServerApi serverApi;

    static
    {
        initOkHttpClient();
    }

    private static void initOkHttpClient() {
        if(okHttpClient==null)
        {
            synchronized (RetrofitHelper.class)
            {
                if(okHttpClient==null)
                {
                    okHttpClient=new OkHttpClient();
                }
            }
        }
    }

    //获取SverApi对象
    public static  ServerApi getServerApi()
    {
        if(serverApi==null)
        {
            synchronized (ServerApi.class)
            {
                if(serverApi==null)
                {
                    serverApi=onCreatApi(ServerApi.class, Api.HOST);
                }
            }
        }
        return serverApi;
    }

    //初始化ServerApi
    public  static<T> T onCreatApi(Class<T> tClass,String url)
    {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(tClass);
    }

      /* private<T> void toComurer(Observable<T> observable, Consumer<T> t,Consumer<Throwable> e)
       {
             observable.subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                       .observeOn(AndroidSchedulers.mainThread())
                       .subscribe(t,e);

       }*/
}
