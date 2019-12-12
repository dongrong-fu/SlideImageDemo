package com.example.testslideimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by dongrong.fu on 2019/12/11
 */
public class MyAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private Bitmap mBmp;
    public MyAdapter(Context context){
        this.mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == 1){
            ImageView imageView = new ImageView(mContext);
            return new ViewHolder1(imageView);
        }else {
            TextView textView = new TextView(mContext);
            return new ViewHolder2(textView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 6) return 1;
        return 2;
    }

    public void move(int y){
        if(mBmp == null){
            mBmp = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.hello);
        }
        if(y > 0 && y < mBmp.getHeight() - 400){
            Bitmap bitmap = Bitmap.createBitmap(mBmp,0,y,mBmp.getWidth(),400);
            iv.setImageBitmap(bitmap);
        } else if(y <0 && y > 400 - mBmp.getHeight()){
            Log.i("123","height:"+mBmp.getHeight()+",y:"+y);
            Bitmap bitmap = Bitmap.createBitmap(mBmp,0,mBmp.getHeight()+y-400,mBmp.getWidth(),400);
            iv.setImageBitmap(bitmap);
        }

    }
    ImageView iv;
    class ViewHolder1 extends RecyclerView.ViewHolder {

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            iv = (ImageView) itemView;
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,200);
            iv.setLayoutParams(lp);
            Bitmap bmp = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.hello);
            Bitmap bitmap = Bitmap.createBitmap(bmp,0,0,bmp.getWidth(),400);
            iv.setImageBitmap(bitmap);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {
        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            TextView tv = (TextView) itemView;
            tv.setText("hello world!");
            tv.setGravity(Gravity.CENTER);
            tv.setMinHeight(200);
        }
    }

}
