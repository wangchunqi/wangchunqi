package bawei.com.sunyandong20171221;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import bawei.com.sunyandong20171221.Bean.Add;
import bawei.com.sunyandong20171221.Bean.Detail;
import bawei.com.sunyandong20171221.Persenter.P2;
import bawei.com.sunyandong20171221.Persenter.P3;
import bawei.com.sunyandong20171221.View.Iview;
import bawei.com.sunyandong20171221.View.Iview2;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener,Iview,Iview2 {

    private SimpleDraweeView mBan;
    private TextView mTitle;
    private TextView mContent;
    private TextView mAdd;
    String pid;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        P2 p2=new P2(this,this);
        p2.getdetail();


    }

    private void initView() {
        mBan = (SimpleDraweeView) findViewById(R.id.ban);
        mTitle = (TextView) findViewById(R.id.title);
        mContent = (TextView) findViewById(R.id.content);
        mAdd = (TextView) findViewById(R.id.add);
        mAdd.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                // TODO 18/01/08
                P3 p3=new P3(this,this,pid);
                p3.getadd();
                Intent in=new Intent(MainActivity.this,MainActivity4.class);
                startActivity(in);
                break;
            default:
                break;
        }

    }

    @Override
    public void getbean(Add bean) {
        if(bean.getCode().equals("0"))
        {
            Toast.makeText(MainActivity.this,bean.getMsg(),Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(MainActivity.this,bean.getMsg(),Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void getbean(Detail bean) {
        String path=bean.getData().getImages();
        String[] is=path.split("\\|");
        Uri uri=Uri.parse(is[0]);
        mBan.setImageURI(uri);
        mTitle.setText(bean.getData().getTitle());
        mContent.setText(bean.getData().getSubhead());
        pid=bean.getData().getPid()+"";

    }
}
