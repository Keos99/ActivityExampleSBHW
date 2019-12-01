package com.example.activityexamplesbhw;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestModel implements Parcelable {

    private final int mBound = 100;
    private final int mCount = 20;
    private String mFirstString;
    private String mSecondString;
    private List<Integer> mFirstCollection;
    private List<Integer> mSecondCollection;
    private Random mRandom;

    public String getFirstString() {
        return mFirstString;
    }

    public String getSecondString() {
        return mSecondString;
    }

    public List<Integer> getFirstCollection() {
        return mFirstCollection;
    }

    public List<Integer> getSecondCollection() {
        return mSecondCollection;
    }

    public TestModel(String[] strings) {
        StringBuilder sB = new StringBuilder();
        StringBuilder sB1 = new StringBuilder();
        mFirstCollection = new ArrayList<>();
        mSecondCollection = new ArrayList<>();
        mRandom = new Random();
        for (int i = 0; i < mCount; i++) {
            sB.append(strings[mRandom.nextInt(mCount - 1)]);
            sB1.append(strings[mRandom.nextInt(mCount - 1)]) ;
            mFirstCollection.add(mRandom.nextInt(mBound));
            mSecondCollection.add(mRandom.nextInt(mBound));
        }
        mFirstString = sB.toString();
        mSecondString = sB1.toString();
    }

    public TestModel(String FirstString, String SecondString, List<Integer> FirstCollection,
                     List<Integer> SecondCollection) {
        mFirstString = FirstString;
        mSecondString = SecondString;
        mFirstCollection = FirstCollection;
        mSecondCollection = SecondCollection;
    }

    private TestModel(Parcel parcel) {
        mFirstString = parcel.readString();
        mSecondString = parcel.readString();
        parcel.readList(mFirstCollection, Integer.class.getClassLoader());
        parcel.readList(mSecondCollection, Integer.class.getClassLoader());
    }

    public static final Creator<TestModel> CREATOR = new Creator<TestModel>() {
        @Override
        public TestModel createFromParcel(Parcel in) {
            return new TestModel(in);
        }

        @Override
        public TestModel[] newArray(int size) {
            return new TestModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mFirstString);
        dest.writeString(mSecondString);
        dest.writeList(mFirstCollection);
        dest.writeList(mSecondCollection);
    }
}
