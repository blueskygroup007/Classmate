package com.bluesky.classmate.ui.main;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;

import com.bluesky.classmate.R;
import com.bluesky.classmate.bean.Sence;
import com.bluesky.classmate.databinding.ActivityMainBinding;
import com.bluesky.classmate.ui.main.GridAdapter;
import com.bluesky.classmate.ui.play.PlayActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private GridAdapter mAdapter;
    private List<Sence> mSenceList=new ArrayList<>();
    private ActivityResultLauncher<Intent> mContracts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        //setContentView(R.layout.activity_main);

        mContracts = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {

            }
        });



        mSenceList.add(new Sence("第一项", "path"));
        mSenceList.add(new Sence("第二项", "path"));
        mSenceList.add(new Sence("第三项", "path"));


        mBinding.rvList.setLayoutManager(new GridLayoutManager(this, 3));
        mAdapter=new GridAdapter(mSenceList, new MyItemClickerListener());
        mBinding.rvList.setAdapter(mAdapter);
    }


    class MyItemClickerListener implements GridAdapter.ItemClickListener{

        @Override
        public void onItemClicked(int position) {
            //TODO 转到播放页面
            Intent intent=new Intent(MainActivity.this,PlayActivity.class);
            Bundle bundle=new Bundle();
            bundle.putSerializable("SENCE", mSenceList.get(position));
            intent.putExtras(bundle);
            startActivity(intent);
        }

        @Override
        public void onAddClicked() {
            //TODO 转到添加页面
            Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("video/*");
            startActivity(intent);
            mContracts.launch(intent);
        }
    }
}