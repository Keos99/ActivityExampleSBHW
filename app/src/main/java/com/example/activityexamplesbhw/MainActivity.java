package com.example.activityexamplesbhw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TestModel mTestModel;
    private TextView mTextViewFirstString;
    private TextView mTextViewSecondString;
    private TextView mTextViewFirstCollection;
    private TextView mTextViewSecondCollection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    public void initUI(){
        mTextViewFirstString = findViewById(R.id.tv_catalog_first_string);
        mTextViewSecondString = findViewById(R.id.tv_catalog_second_string);
        mTextViewFirstCollection = findViewById(R.id.tv_catalog_first_list);
        mTextViewSecondCollection = findViewById(R.id.tv_catalog_second_list);
    }




}
