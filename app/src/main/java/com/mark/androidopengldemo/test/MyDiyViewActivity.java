package com.mark.androidopengldemo.test;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mark.androidopengldemo.MyLineView;
import com.mark.androidopengldemo.R;

import java.util.ArrayList;

public class MyDiyViewActivity extends AppCompatActivity {

    private MyLineView lineView;

    private ArrayList<Integer> timList = new ArrayList<>();
    private ArrayList<String> bottomList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diy_line);
        lineView = findViewById(R.id.diy_line);
        timList.add(100);
        timList.add(75);
        timList.add(60);
        timList.add(20);
        timList.add(80);
        timList.add(40);
        timList.add(70);
        bottomList.add("一");
        bottomList.add("一");
        bottomList.add("一");
        bottomList.add("一");
        bottomList.add("一");
        bottomList.add("一");
        bottomList.add("一");
        lineView.updateTime(timList, bottomList);
    }
}
