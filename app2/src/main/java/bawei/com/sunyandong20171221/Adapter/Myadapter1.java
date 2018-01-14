package bawei.com.sunyandong20171221.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import bawei.com.sunyandong20171221.Bean.Bean2;
import bawei.com.sunyandong20171221.R;

/**
 * Created by 悻 on 2017/12/21.
 */

public class Myadapter1 extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
private List<Bean2.TuijianBean.ListBean> listBeen=new ArrayList<>();
    private Context context;

    public Myadapter1(List<Bean2.TuijianBean.ListBean> listBeen, Context context) {
        this.listBeen = listBeen;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item1,parent,false);
        return new sViewHodler(view);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        sViewHodler sViewHodler= (Myadapter1.sViewHodler) holder;
        sViewHodler.imgg.setImageURI(listBeen.get(position).getImages());
        sViewHodler.tv1.setText(listBeen.get(position).getTitle());
        sViewHodler.tv2.setText("¥"+listBeen.get(position).getPrice()+"");

    }

    @Override
    public int getItemCount() {
        return 1;
    }
    private class sViewHodler extends RecyclerView.ViewHolder{
   private SimpleDraweeView imgg;
        private TextView tv1;
        private TextView tv2;
        public sViewHodler(View itemView) {
            super(itemView);
            imgg=itemView.findViewById(R.id.imgg);
            tv1=itemView.findViewById(R.id.tv1);
            tv2=itemView.findViewById(R.id.tv2);
        }
    }
}
