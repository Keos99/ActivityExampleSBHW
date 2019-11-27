package com.example.activityexamplesbhw;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class MyObject implements Parcelable {

    public String mFirstString;
    public String mSecondString;
    public List<Integer> mFirstCollection;
    public List<Integer> mSecondCollection;

    private MyObject(Parcel parcel) {
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

    public static final Creator<MyObject> CREATOR = new Creator<MyObject>() {
        @Override
        public MyObject createFromParcel(Parcel in) {
            return new MyObject(in);
        }

        @Override
        public MyObject[] newArray(int size) {
            return new MyObject[size];
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
