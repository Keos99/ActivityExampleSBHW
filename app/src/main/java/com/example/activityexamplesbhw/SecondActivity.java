package com.example.activityexamplesbhw;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class SecondActivity extends Activity {

    private String mFirstString;
    private String mSecondString;
    private List<Integer> mFirstCollection;
    private List<Integer> mSecondCollection;
    private TestModel mTestModel;
    private TextView mTextViewFirstString;
    private TextView mTextViewSecondString;
    private TextView mTextViewFirstCollection;
    private TextView mTextViewSecondCollection;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initUI();
        initListeners();
        initData();
        showData();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(getString(R.string.TestModel), mTestModel);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mTestModel = savedInstanceState.getParcelable(getString(R.string.TestModel));
        setDataFromTestModel();
        showData();
    }

    private void initData(){
        mTestModel = new TestModel(getResources().getStringArray(R.array.chars));
        setDataFromTestModel();
    }

    public void initUI(){
        mTextViewFirstString = findViewById(R.id.tv_map_first_string);
        mTextViewSecondString = findViewById(R.id.tv_map_second_string);
        mTextViewFirstCollection = findViewById(R.id.tv_map_first_list);
        mTextViewSecondCollection = findViewById(R.id.tv_map_second_list);
        mButton = findViewById(R.id.button_map);
    }

    private void initListeners(){
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick();
            }
        });
    }

    private void onButtonClick(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    private void setDataFromTestModel(){
        mFirstString = mTestModel.getFirstString();
        mSecondString = mTestModel.getSecondString();
        mFirstCollection = mTestModel.getFirstCollection();
        mSecondCollection = mTestModel.getSecondCollection();
    }

    private void showData(){
        mTextViewFirstString.setText(mFirstString);
        mTextViewSecondString.setText(mSecondString);
        mTextViewFirstCollection.setText(mFirstCollection.toString());
        mTextViewSecondCollection.setText(mSecondCollection.toString());
    }
}
