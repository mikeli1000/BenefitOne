package com.itf.benefitone;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends FragmentActivity {
    private FrameLayout mTopContent;
    private RadioGroup mTopRadioGroup;
    private RadioButton mTodayRb;
    private RadioButton mHosuuRb;
    private RadioButton mWeightRb;
    private RadioButton mSettingRb;

    //Fragment数
    static final int NUM_ITEMS = 4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_top_layout);
        initview();
        initdata();
    }

    FragmentStatePagerAdapter fragments = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
        //Fragmentの初期化
        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch(position) {
                case 0:
                    fragment = new TodayFragment();
                    break;
                case 1:
                    fragment = new HosuuFragment();
                    break;
                case 2:
                    fragment = new WeightFragment();
                    break;
                case 3:
                    fragment = new SettingFragment();
                    break;
                default:
                    fragment = new TodayFragment();
                    break;
            }
            return fragment;
        };
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }
    };
    @Override
    protected void onStart() {
        super.onStart();
        mTopRadioGroup.check(R.id.todayRB);
    }

    protected void initdata() {}
    protected void initview() {
        mTopContent = (FrameLayout) findViewById(R.id.topContents);
        mTopRadioGroup = (RadioGroup) findViewById(R.id.topRadioGroup);
        mTodayRb = (RadioButton) findViewById(R.id.todayRB);
        mHosuuRb = (RadioButton) findViewById(R.id.hosuuRB);
        mWeightRb = (RadioButton) findViewById(R.id.weightRB);
        mSettingRb = (RadioButton) findViewById(R.id.settingRB);

        //mTopRadioGroupのListener
        mTopRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int index = 0;
                 switch (checkedId) {
                     case R.id.todayRB:
                         index = 0;
                         break;
                     case R.id.hosuuRB:
                         index = 1;
                         break;
                     case R.id.weightRB:
                         index = 2;
                         break;
                     case R.id.settingRB:
                         index = 3;
                         break;
                 }
                //index及びFragmentにて、レイアウトの内容を入れ替え
                Fragment fragment = (Fragment) fragments.instantiateItem(mTopContent, index);
                //初期値
                fragments.setPrimaryItem(mTopContent,0,fragment);
                fragments.finishUpdate(mTopContent);
            }
        });
    }
}
