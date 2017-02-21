package com.androidbanners;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.view.cycleview.CycleModel;
import com.view.cycleview.CycleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @className: MainActivity
 * @classDescription: 一个广告轮播图Demo
 * @author: miao
 * @createTime: 2017年2月20日
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.cycleview)
    CycleView cycleview;

    //轮播图数据
    private List<CycleModel> mData = new ArrayList<CycleModel>();

    //图片地址
    public static final String url_1 = "http://upload.jianshu.io/admin_banners/web_images/2781/895f1a24cd0745da1fd8e79dd1f36e8b8bb77040.jpg";
    public static final String url_2 = "http://upload.jianshu.io/admin_banners/web_images/2771/eb70e179eeddedbbde81b9c3797dba62982f0ec9.png";
    public static final String url_3 = "http://upload.jianshu.io/admin_banners/web_images/2295/dcc46ceef44b1df38b934c68043e43b1dd7d6f4d.jpg";
    public static final String url_4 = "http://upload.jianshu.io/admin_banners/web_images/2474/259a36ccbca577c3064c68ab3c0f1834d77456d7.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //加载轮播图
        initView();
    }

    /**
     * initView 加载轮播图，轮播图相关设置
     * @author miao
     * @createTime 2017年2月20日
     * @lastModify 2017年2月20日
     * @param
     * @return
     */
    private void initView() {

        //设置数据
        mData.add(new CycleModel(url_1));
        mData.add(new CycleModel(url_2));
        mData.add(new CycleModel(url_3));
        mData.add(new CycleModel(url_4));
        //判空容错
        if (cycleview == null)
            return ;
        //设置显示方式（居中,内边距离下24dp）
        cycleview.setAlignParentCenter(24);
        //设置为有轮播功能
        cycleview.setIsHasWheel(true);
        //设置轮播时间为3000毫秒
        cycleview.setDelay(3000);
        //设置数据源并设置监听
        cycleview.setData(mData, this, new CycleView.CycleViewListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this,"第"+(position+1)+"张图",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
