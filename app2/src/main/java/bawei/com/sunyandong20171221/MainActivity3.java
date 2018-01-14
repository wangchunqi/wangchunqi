package bawei.com.sunyandong20171221;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import bawei.com.sunyandong20171221.Adapter.Myadapter;
import bawei.com.sunyandong20171221.Bean.Beanlb;
import bawei.com.sunyandong20171221.Persenter.Ipersenter;
import bawei.com.sunyandong20171221.View.IFenView;

public class MainActivity3 extends AppCompatActivity implements IFenView{


    private RecyclerView rec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();
        Ipersenter ipersenter=new Ipersenter(this);
        ipersenter.Shaddd();

    }

    private void init() {
        rec = (RecyclerView) findViewById(R.id.rec);
        LinearLayoutManager lin=new LinearLayoutManager(this);
        rec.setLayoutManager(lin);
    }

    @Override
    public void onZuo(Beanlb beanlb) {
Myadapter myadapter=new Myadapter(beanlb.getData(),MainActivity3.this);
      rec.setAdapter(myadapter);

        myadapter.setmOnItemClickListener(new Myadapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent=new Intent(MainActivity3.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
