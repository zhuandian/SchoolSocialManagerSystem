package com.zhuandian.schoolsocialmanagersystem.business;

import android.text.TextUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.zhuandian.base.BaseActivity;
import com.zhuandian.schoolsocialmanagersystem.R;
import com.zhuandian.schoolsocialmanagersystem.entity.TopicEntity;


import butterknife.BindView;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * 发布公告
 */
public class ReleaseTopicActivity extends BaseActivity {
    @BindView(R.id.blog_title)
    EditText blogTitle;
    @BindView(R.id.blog_content)
    EditText blogContent;
    @BindView(R.id.commit_content)
    LinearLayout commitContent;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_release_topic;
    }

    @Override
    protected void setUpView() {
        this.setTitle("发布公告");

    }


    @OnClick(R.id.commit_content)
    public void onClick() {
        String blogTitleStr = blogTitle.getText().toString();
        String blogContentStr = blogContent.getText().toString();
        if (TextUtils.isEmpty(blogTitleStr) || TextUtils.isEmpty(blogContentStr)) {
            Toast.makeText(this, "标题跟内容都不允许为空...", Toast.LENGTH_SHORT).show();
        } else {
            TopicEntity topicEntity = new TopicEntity();

            topicEntity.setTopicTitle(blogTitleStr);
            topicEntity.setTopicContent(blogContentStr);
            topicEntity.save(new SaveListener<String>() {
                @Override
                public void done(String s, BmobException e) {
                    if (e == null) {
                        Toast.makeText(ReleaseTopicActivity.this, "发布成功...", Toast.LENGTH_SHORT).show();
                        ReleaseTopicActivity.this.finish();
                    }
                }
            });
        }
    }
}
