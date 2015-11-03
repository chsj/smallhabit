package com.chsj.smallhabit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.*;
import android.widget.Button;
import android.widget.ImageView;


import java.util.LinkedList;
import java.util.List;

public class FirstViewPager extends Activity implements ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private List<ImageView> imageViews;
    private int resIds[]  = new int[4];
    private ImageView skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_first_view_pager);
        skip = (ImageView) findViewById(R.id.activity_first_viewpager_skip);
        viewPager = (ViewPager) findViewById(R.id.activity_first_viewpager);
        imageViews = new LinkedList<>();
         resIds[0] = R.mipmap.guide_v3_page1_0;
        resIds[1] = R.mipmap.guide_v3_page3_0;
        resIds[2] = R.mipmap.guide_v3_page4_0;
        resIds[3] = R.mipmap.guide_v3_page5_0;
        for (int i = 0; i < resIds.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(resIds[i]);
            imageViews.add(imageView);
        }
        WelcomePageAdapter adapter = new WelcomePageAdapter();
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(this);
    }


    public void btnMain(View view) {
        Intent intent  = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
           if(position==imageViews.size()-1){
               skip.setVisibility(View.GONE);
           }else{
               skip.setVisibility(View.VISIBLE);
           }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    class WelcomePageAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return imageViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(imageViews.get(position));
            return imageViews.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
           container.removeView(imageViews.get(position));
        }
    }
}
