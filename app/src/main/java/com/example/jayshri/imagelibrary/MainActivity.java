package com.example.jayshri.imagelibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.jayshri.imagelibrary.utilities.NetworkUtils;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private TextView mErrorMessageDisplay;
    private ProgressBar mLoadingIndicator;
    private LinearLayoutManager mLinearLayoutManager;
    private ImageAdapter imageAdapter;
    private List<String> imageUrls ;
    NetworkUtils networkUtils = new NetworkUtils();

    int previousTotal = 0;
    boolean loading = true;
    int visibleThreshold = 10;
    int firstVisibleItem = 0;
    int visibleItemCount = 0;
    int totalItemCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        networkUtils = new NetworkUtils();;
        initView();
        initRecyclerView();
        setRecyclerView();

    }

    private void initView(){
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mErrorMessageDisplay = (TextView) findViewById(R.id.tv_error_message_display);
        mLoadingIndicator = (ProgressBar) findViewById(R.id.pb_loading_indicator);
    }

    private void initRecyclerView(){

        imageUrls = networkUtils.getImageUrlList();
        mLinearLayoutManager =  new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener()
        {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy)
            {
                if(dy > 0) //check for scroll down
                {
                    visibleItemCount = mLinearLayoutManager.getChildCount();
                    totalItemCount = mLinearLayoutManager.getItemCount();
                    firstVisibleItem = mLinearLayoutManager.findFirstVisibleItemPosition();

                    if (loading)
                    {
                        if ( (visibleItemCount + firstVisibleItem) >= totalItemCount)
                        {
                            loading = false;
                            imageUrls.addAll(networkUtils.getImageUrlList());
                            setRecyclerView();
                            loading = true;
                        }
                    }
                }
            }
        });
    }

    private void setRecyclerView(){
        imageAdapter= new ImageAdapter(imageUrls, this);
        mRecyclerView.setAdapter(imageAdapter);
        imageAdapter.notifyDataSetChanged();
    }
}
