package bawei.com.sunyandong20171221.net;

/**
 * Created by ZMoffice on 2018.1.8.
 */

public interface NetWorkListener<T>{

    public void onError(Exception e);
    public void onSuccess(T t);
}
