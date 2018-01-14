package bawei.com.sunyandong20171221;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import bawei.com.sunyandong20171221.Bean.EventBean;
import bawei.com.sunyandong20171221.Bean.EventBusBool;
import bawei.com.sunyandong20171221.Bean.MsgBean;
import bawei.com.sunyandong20171221.Bean.ShopCarBean;
import bawei.com.sunyandong20171221.Persenter.MainPresenter;
import bawei.com.sunyandong20171221.View.IMainActivity;
import bawei.com.sunyandong20171221.adp.MyExAdapter;


public class MainActivity4 extends AppCompatActivity implements IMainActivity {


    List<ShopCarBean.DataBean> groupList;
    private ExpandableListView mMexl;
    MyExAdapter adapter;
    MainPresenter presenter;
    private CheckBox mCheck;
    /**
     * 价格:0
     */
    private TextView mAllprice;
    /**
     * 结算
     */
    private TextView mJiesuan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main4);
        EventBus.getDefault().register(this);
        initView();
        presenter = new MainPresenter(this);
        presenter.postShopCar();
    }
    //购物车数据
    @Override
    public void showShopCar(ShopCarBean shopCarBean) {
        groupList = new ArrayList<>();
        groupList = shopCarBean.getData();
        adapter = new MyExAdapter(MainActivity4.this, groupList,this);
        mMexl.setAdapter(adapter);
        //默认展开
        mMexl.setGroupIndicator(null);
        for (int i = 0; i < groupList.size(); i++) {
            mMexl.expandGroup(i);
        }

        mCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mCheck.isChecked())
                {
                    isAllPrice(true);
                }
                else
                {
                    isAllPrice(false);
                }
                adapter.notifyDataSetChanged();
            }
        });
    }

    //删除购物车
    @Override
    public void showDelCar(MsgBean msgBean) {
        Toast.makeText(MainActivity4.this,msgBean.getMsg(),Toast.LENGTH_SHORT).show();
        presenter.postShopCar();

    }

    private void initView() {
        mMexl = (ExpandableListView) findViewById(R.id.mexl);

        mCheck = (CheckBox) findViewById(R.id.check);
        mAllprice = (TextView) findViewById(R.id.allprice);
        mJiesuan = (TextView) findViewById(R.id.jiesuan);
    }

    @Subscribe
    public void getCheck(EventBusBool eventBusBool) {
        mCheck.setChecked(eventBusBool.isB());
    }
    @Subscribe
    public void getBean(EventBean eventBusBool) {
        mJiesuan.setText("结算:("+eventBusBool.getNum()+")");
        mAllprice.setText("￥"+eventBusBool.getPrice());
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        presenter.doDview();//解绑
    }
    //计算价格的方法
    public void isAllPrice(boolean b)
    {
        for(int i=0;i<groupList.size();i++)
        {
            groupList.get(i).setGroupCheck(b);
            List<ShopCarBean.DataBean.ListBean> listBeans=groupList.get(i).getList();
            for(int j=0;j<listBeans.size();j++)
            {
                listBeans.get(j).setChildCheck(b);
            }
        }
        adapter.isAllPrice();//计算价格和数量
    }
}
