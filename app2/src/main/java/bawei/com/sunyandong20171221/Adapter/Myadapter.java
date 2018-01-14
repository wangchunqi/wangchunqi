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

import bawei.com.sunyandong20171221.Bean.Beanlb;
import bawei.com.sunyandong20171221.R;

/**
 * Created by 悻 on 2017/12/21.
 */

public class Myadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>implements View.OnClickListener{

    private List<Beanlb.DataBean> list=new ArrayList<>();
    private Context context;
    private OnItemClickListener mOnItemClickListener = null;

    public Myadapter(List<Beanlb.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }


    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }
    public static interface OnItemClickListener {
        void onItemClick(View view, int position);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View inflat=LayoutInflater.from(context).inflate(R.layout.itemlb,parent,false);
        inflat.setOnClickListener(this);

        return new sViewHodler(inflat);

    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        sViewHodler sViewHodler= (Myadapter.sViewHodler) holder;

        String str=list.get(position).getImages();

        String[] strs=str.split("\\|");
        sViewHodler.img.setImageURI(strs[0]);
        sViewHodler.tv1.setText(list.get(position).getPrice()+"");
        sViewHodler.tv2.setText(list.get(position).getTitle());

        holder.itemView.setTag(position);

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v, (int) v.getTag());
        }
    }

    private class sViewHodler extends RecyclerView.ViewHolder{

        private SimpleDraweeView img;
        private TextView tv1;
        private TextView tv2;
        public sViewHodler(View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            tv1=itemView.findViewById(R.id.tvprice);
            tv2=itemView.findViewById(R.id.tvxq);
        }
    }
}
