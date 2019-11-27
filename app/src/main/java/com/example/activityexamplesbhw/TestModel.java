package com.example.activityexamplesbhw;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class TestModel implements Parcelable {

    private String mFirstString;
    private String mSecondString;
    private List<Integer> mFirstCollection;
    private List<Integer> mSecondCollection;

    private TestModel(Parcel parcel) {
        mFirstCollection = new ArrayList<>();
        mSecondCollection = new ArrayList<>();
        mFirstString = parcel.readString();
        mSecondString = parcel.readString();
        parcel.readList(mFirstCollection, Integer.class.getClassLoader());
        parcel.readList(mSecondCollection, Integer.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel){
        parcel.writeString(mFirstString);
        parcel.writeString(mSecondString);
        parcel.writeList(mFirstCollection);
        parcel.writeList(mSecondCollection);
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
    }
}
