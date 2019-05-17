package com.zhuandian.schoolsocialmanagersystem.business;

import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.zhuandian.schoolsocialmanagersystem.adapter.TopicAdapter;
import com.zhuandian.schoolsocialmanagersystem.entity.TopicEntity;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.UpdateListener;

public class TopicListActivity extends BaseListActivity {
    @Override
    protected void initList() {
        this.setTitle("公告管理");
        BmobQuery<TopicEntity> query = new BmobQuery<>();
        query.order("-updatedAt");
        query.findObjects(new FindListener<TopicEntity>() {
            @Override
            public void done(List<TopicEntity> list, BmobException e) {
                final TopicAdapter adapter = new TopicAdapter(TopicListActivity.this, list);
                rvList.setAdapter(adapter);
                rvList.setLayoutManager(new LinearLayoutManager(TopicListActivity.this));
                adapter.setOnItemClickListener(new TopicAdapter.OnItemClickListener() {
                    @Override
                    public void onClick(TopicEntity topicEntity) {
                        topicEntity.delete(topicEntity.getObjectId(), new UpdateListener() {
                            @Override
                            public void done(BmobException e) {
                                if (e == null) {
                                    Toast.makeText(TopicListActivity.this, "删除成功...", Toast.LENGTH_SHORT).show();
                                    initList();
                                    adapter.notifyDataSetChanged();
                                }
                            }
                        });
                    }
                });
            }
        });
    }

}
