package com.zhuandian.schoolsocialmanagersystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zhuandian.base.BaseActivity;
import com.zhuandian.schoolsocialmanagersystem.business.DynamicListActivity;
import com.zhuandian.schoolsocialmanagersystem.business.ReleaseTopicActivity;
import com.zhuandian.schoolsocialmanagersystem.business.TopicListActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setUpView() {
        this.setTitle("管理系统");
    }


    @OnClick({R.id.tv_manager_dynamic, R.id.tv_manager_topic, R.id.tv_release_topic})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_manager_dynamic:
                startActivity(new Intent(MainActivity.this, DynamicListActivity.class));
                break;
            case R.id.tv_manager_topic:
                startActivity(new Intent(MainActivity.this, TopicListActivity.class));
                break;
            case R.id.tv_release_topic:
                startActivity(new Intent(MainActivity.this, ReleaseTopicActivity.class));
                break;
        }
    }
}
