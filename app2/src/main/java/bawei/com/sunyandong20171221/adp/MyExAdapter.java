package bawei.com.sunyandong20171221.adp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import bawei.com.sunyandong20171221.Bean.EventBean;
import bawei.com.sunyandong20171221.Bean.EventBusBool;
import bawei.com.sunyandong20171221.Bean.ShopCarBean;
import bawei.com.sunyandong20171221.Persenter.MainPresenter;
import bawei.com.sunyandong20171221.R;
import bawei.com.sunyandong20171221.View.IMainActivity;
import bawei.com.sunyandong20171221.net.MyView;
import bawei.com.sunyandong20171221.utils.Api;


/**
 * Created by ZMoffice on 2018.1.8.
 */

public class MyExAdapter extends BaseExpandableListAdapter {
    Context context;
    List<ShopCarBean.DataBean> list;
    int isxian= View.INVISIBLE;
    MainPresenter presenter;
    public MyExAdapter(Context context, List<ShopCarBean.DataBean> list, IMainActivity iMainActivity) {
        this.context = context;
        this.list = list;
        presenter=new MainPresenter(iMainActivity);
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return list.get(i).getList().size();
    }

    @Override
    public Object getGroup(int i) {
        return list.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return list.get(i).getList().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    class MyGroupHolder {
        TextView name;
        CheckBox checkBox;
        TextView bianji;
    }

    @Override
    public View getGroupView(final int i, boolean b, View view, ViewGroup viewGroup) {
        MyGroupHolder holder;
        if (view == null) {
            //加载布局
            view = View.inflate(context, R.layout.item_group, null);
            holder = new MyGroupHolder();
            holder.name = view.findViewById(R.id.group_name);
            holder.checkBox = view.findViewById(R.id.group_check);
            holder.bianji=view.findViewById(R.id.bianji);
            view.setTag(holder);
        }
        {
            holder = (MyGroupHolder) view.getTag();
        }

        //父数据
        final ShopCarBean.DataBean dataBean = list.get(i);
        holder.name.setText(dataBean.getSellerName());
        holder.checkBox.setChecked(dataBean.isGroupCheck());
        final MyGroupHolder finalHolder = holder;
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBusBool eventBusBool=new EventBusBool();
                if(finalHolder.checkBox.isChecked())
                {
                    dataBean.setGroupCheck(true);
                    isChild(i,true);
                    if(isGroupAll())
                    {
                        eventBusBool.setB(true);
                    }
                }
                else {
                    dataBean.setGroupCheck(false);
                    isChild(i,false);
                    eventBusBool.setB(false);
                }
                isAllPrice();
                EventBus.getDefault().post(eventBusBool);
                notifyDataSetChanged();//刷新适配器
            }
        });
        //编辑
        holder.bianji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isxian==View.INVISIBLE)
                {
                    isxian=View.VISIBLE;
                }
                else
                {
                    isxian=View.INVISIBLE;
                }
                notifyDataSetChanged();
            }
        });
        return view;
    }

    public class MyChildHolder {
        CheckBox checkBox;
        SimpleDraweeView simpleDraweeView;
        TextView name;
        TextView time;
        TextView price;
        MyView myView;
        TextView del;
    }

    @Override
    public View getChildView(final int i, final int i1, boolean b, View view, ViewGroup viewGroup) {
        MyChildHolder holder;
        if (view == null) {
            view = View.inflate(context, R.layout.item_child, null);
            holder = new MyChildHolder();
            holder.checkBox = view.findViewById(R.id.child_check);
            holder.name = view.findViewById(R.id.child_name);
            holder.price = view.findViewById(R.id.child_price);
            holder.time = view.findViewById(R.id.child_time);
            holder.simpleDraweeView = view.findViewById(R.id.simple);
            holder.del=view.findViewById(R.id.del);
            holder.myView=view.findViewById(R.id.myview);
            view.setTag(holder);
        }
        {
            holder = (MyChildHolder) view.getTag();
        }

        final ShopCarBean.DataBean.ListBean listBean = list.get(i).getList().get(i1);
        String str[] = listBean.getImages().split("\\|");
        holder.simpleDraweeView.setImageURI(str[0]);
        holder.time.setText(listBean.getCreatetime());
        holder.price.setText("￥" + listBean.getPrice());
        holder.name.setText(listBean.getSubhead().substring(0, 10));
        holder.checkBox.setChecked(listBean.isChildCheck());
        holder.del.setVisibility(isxian);
        holder.myView.setNum(listBean.getNum()+"");
        //点击事件
        final MyChildHolder finalHolder = holder;
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBusBool eventBusBool=new EventBusBool();
                if(finalHolder.checkBox.isChecked())
                {

                    listBean.setChildCheck(true);
                    if(isChildGroup(i))//判断二级是否全选
                    {
                        list.get(i).setGroupCheck(true);

                        if(isGroupAll())
                        {
                            eventBusBool.setB(true);
                        }
                    }
                }
                else
                {
                    listBean.setChildCheck(false);
                    list.get(i).setGroupCheck(false);
                    eventBusBool.setB(false);
                }
                EventBus.getDefault().post(eventBusBool);
                isAllPrice();
                notifyDataSetChanged();//刷新适配器
            }
        });
        //删除
        holder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  list.get(i).getList().remove(i1);*/
                presenter.postDelCar(Api.uid,listBean.getPid()+"");
                //notifyDataSetChanged();
            }
        });

        holder.myView.setAdditemClick(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num=listBean.getNum();
                num++;
                listBean.setNum(num);
                isAllPrice();
                finalHolder.myView.setNum(num+"");
            }
        });
        holder.myView.setJianitemClick(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num=listBean.getNum();
                if(num==1)
                {
                    Toast.makeText(context,"最小为1",Toast.LENGTH_SHORT).show();
                    return;
                }
                num--;
                listBean.setNum(num);
                isAllPrice();
                finalHolder.myView.setNum(num+"");
            }
        });

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
    //二级和一级联动
    public boolean isChildGroup(int position)
    {
        for(int i=0;i<list.get(position).getList().size();i++)
        {
            if(!list.get(position).getList().get(i).isChildCheck())
            {
                return false;
            }
        }
        return true;
    }
    //二级和全选
    public boolean isGroupAll()
    {
        for(int i=0;i<list.size();i++)
        {
            if(!list.get(i).isGroupCheck())
            {
                return false;
            }
        }
        return true;
    }
    //一级与二级
    public void isChild(int position,boolean b)
    {
        List<ShopCarBean.DataBean.ListBean> listBeans=list.get(position).getList();
        for(int i=0;i<listBeans.size();i++)
        {
            listBeans.get(i).setChildCheck(b);
        }
    }
    //计算价格的方法
    public void isAllPrice()
    {
        int num = 0;
        int price = 0;
        for(int i=0;i<list.size();i++)
        {
            List<ShopCarBean.DataBean.ListBean> listBeans=list.get(i).getList();
            for(int j=0;j<listBeans.size();j++)
            {
                if(listBeans.get(j).isChildCheck())
                {
                    num+=listBeans.get(j).getNum();
                    price+=listBeans.get(j).getNum()*listBeans.get(j).getPrice();
                }
            }
        }
        EventBean eventBean=new EventBean();
        eventBean.setNum(num+"");
        eventBean.setPrice(price+"");
        EventBus.getDefault().post(eventBean);
    }

}
