package com.zhuandian.schoolsocialmanagersystem.business;


import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.zhuandian.schoolsocialmanagersystem.adapter.PostListAdapter;
import com.zhuandian.schoolsocialmanagersystem.adapter.TopicAdapter;
import com.zhuandian.schoolsocialmanagersystem.entity.PostEntity;
import com.zhuandian.schoolsocialmanagersystem.entity.TopicEntity;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.UpdateListener;

public class DynamicListActivity extends BaseListActivity {


    @Override
    protected void initList() {
        this.setTitle("动态管理");
        BmobQuery<PostEntity> query = new BmobQuery<>();
        query.order("-updatedAt");
        query.findObjects(new FindListener<PostEntity>() {
            @Override
            public void done(List<PostEntity> list, BmobException e) {
                if (e==null){
                    final PostListAdapter adapter = new PostListAdapter(DynamicListActivity.this, list);
                    rvList.setAdapter(adapter);
                    rvList.setLayoutManager(new LinearLayoutManager(DynamicListActivity.this));
                    adapter.setClickListener(new PostListAdapter.ItemClickListener() {
                        @Override
                        public void onItemClick(PostEntity heartShareEntity) {
                            heartShareEntity.delete(heartShareEntity.getObjectId(), new UpdateListener() {
                                @Override
                                public void done(BmobException e) {
                                    if (e==null){
                                        Toast.makeText(DynamicListActivity.this, "删除成功...", Toast.LENGTH_SHORT).show();
                                        initList();
                                        adapter.notifyDataSetChanged();
                                    }

                                }
                            });
                        }
                    });
                }
            }
        });
    }
}
