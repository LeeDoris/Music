package com.example.lee.musicg.activities;

import android.os.Bundle;
import android.transition.Transition;
import android.view.View;

import com.andremion.music.MusicCoverView;
import com.example.lee.musicg.R;
import com.example.lee.musicg.view.TransitionAdapter;

public class DetailActivity extends PlayerActivity {

    private MusicCoverView mCoverView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_detail);

        mCoverView = (MusicCoverView) findViewById(R.id.cover);
        mCoverView.setCallbacks(new MusicCoverView.Callbacks() {
            @Override
            public void onMorphEnd(MusicCoverView coverView) {
                // Nothing to do
            }

            @Override
            public void onRotateEnd(MusicCoverView coverView) {
                supportFinishAfterTransition();
            }
        });

        getWindow().getSharedElementEnterTransition().addListener(new TransitionAdapter() {
            @Override
            public void onTransitionEnd(Transition transition) {
                play();
                mCoverView.start();
            }
        });
    }

    @Override
    public void onBackPressed() {
        onFabClick(null);
    }

    public void onFabClick(View view) {
        pause();
        mCoverView.stop();
    }

}
