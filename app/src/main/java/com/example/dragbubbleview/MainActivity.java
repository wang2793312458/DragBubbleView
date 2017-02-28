package com.example.dragbubbleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/*
*画两个圆，一个黏连小球固定在一个点上，一个气泡小球跟随手指的滑动改变坐标。随着两个圆间距越来越大，黏连小球半径越来越小。

当间距小于一定值，松开手指气泡小球会恢复原来位置；

当间距超过一定值之后，黏连小球消失，气泡小球继续跟随手指移动，此时手指松开，气泡小球消失
*
*
*
* */


public class MainActivity extends AppCompatActivity implements View.OnClickListener, DragBubbleView.OnBubbleStateListener {

    private DragBubbleView mDragBubbleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button reCreateBtn = (Button) findViewById(R.id.reCreateBtn);
        reCreateBtn.setOnClickListener(this);
        mDragBubbleView = (DragBubbleView) findViewById(R.id.dragBubbleView);
        mDragBubbleView.setText("99+");
        mDragBubbleView.setOnBubbleStateListener(this);
    }

    @Override
    public void onClick(View v) {
        mDragBubbleView.reCreate();
    }

    @Override
    public void onDrag() {
        Log.e("---> ", "拖拽气泡");
    }

    @Override
    public void onMove() {
        Log.e("---> ", "移动气泡");
    }

    @Override
    public void onRestore() {
        Log.e("---> ", "气泡恢复原来位置");
    }

    @Override
    public void onDismiss() {
        Log.e("---> ", "气泡消失");
    }
}
