package com.chsj.smallhabit;
 import android.app.Activity;
 import android.os.Bundle;
 import android.view.*;
 import android.widget.ImageButton;
 import android.widget.ImageView;
 import android.widget.RadioButton;
 import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    private long lastClick;

    // 签到按钮
    private ImageView qd;
    // 发现按钮
    private ImageView discover;
    // 我的按钮
    private ImageView personal;
    // 更多按钮
    private ImageView more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        qd = (ImageView) findViewById(R.id.activity_main_tab_qd);
        discover = (ImageView) findViewById(R.id.activity_main_tab_discover);
        personal = (ImageView) findViewById(R.id.activity_main_tab_personal);
        more = (ImageView) findViewById(R.id.activity_main_tab_more);
        setEvent(qd,discover,personal,more);

    }

    private void setEvent(View... views){
        if (views != null) {
            for (int i = 0; i < views.length; i++) {
                views[i].setOnClickListener(this);
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            long currentClick = System.currentTimeMillis();
            if (currentClick - lastClick < 3000) {
                finish();
            } else {
                lastClick = currentClick;
                Toast.makeText(this, "再次点击退出程序", Toast.LENGTH_SHORT).show();
            }
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        hideAll();//先使所有背景颜色变灰
        switch (v.getId()) {
            case R.id.activity_main_tab_qd:
                qd.setImageResource(R.mipmap.bottombar_participation_press);
                Toast.makeText(MainActivity.this, "点击了签到", Toast.LENGTH_SHORT).show();
                break;
            case R.id.activity_main_tab_discover:
                discover.setImageResource(R.mipmap.bottombar_discover_press);
                Toast.makeText(MainActivity.this, "点击了发现", Toast.LENGTH_SHORT).show();
                break;
            case R.id.activity_main_tab_personal:
                personal.setImageResource(R.mipmap.bottombar_personal_press);
                Toast.makeText(MainActivity.this, "点击了我的", Toast.LENGTH_SHORT).show();
                break;
            case R.id.activity_main_tab_more:
                more.setImageResource(R.mipmap.bottombar_more_press);
                Toast.makeText(MainActivity.this, "点击了更多", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //图片更换，先使所有的设为灰色
    private void hideAll() {
        qd.setImageResource(R.mipmap.bottombar_participation_none);
        discover.setImageResource(R.mipmap.bottombar_discover_none);
        personal.setImageResource(R.mipmap.bottombar_personal_none);
        more.setImageResource(R.mipmap.bottombar_more_none);
    }
}
