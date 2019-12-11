package com.example.testslideimage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecy;
    private float mY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecy = findViewById(R.id.recycler);
        mRecy.setLayoutManager(new LinearLayoutManager(this));
        final MyAdapter myAdapter = new MyAdapter(this);
        mRecy.setAdapter(myAdapter);
        mRecy.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        mY = motionEvent.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        myAdapter.move((int)(mY - motionEvent.getY()));
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                return false;
            }
        });
    }
}
