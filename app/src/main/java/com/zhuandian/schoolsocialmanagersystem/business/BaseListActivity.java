package com.zhuandian.schoolsocialmanagersystem.business;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.zhuandian.base.BaseActivity;
import com.zhuandian.schoolsocialmanagersystem.R;

import butterknife.BindView;
import butterknife.ButterKnife;

abstract public class BaseListActivity extends BaseActivity {


    @BindView(R.id.rv_list)
    RecyclerView rvList;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_dynamic_list;
    }

    @Override
    protected void setUpView() {
        initList();

    }

    protected abstract void initList();


}
