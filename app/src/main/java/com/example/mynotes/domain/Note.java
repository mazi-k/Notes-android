package com.example.mynotes.domain;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.StringRes;

public class Note implements Parcelable {

    @StringRes
    private final int title;
    @StringRes
    private final int subscription;
    @StringRes
    private final int date;


    public Note(int title, int subscription, int date) {
        this.title = title;
        this.subscription = subscription;
        this.date = date;
    }

    protected Note(Parcel in) {
        title = in.readInt();
        subscription = in.readInt();
        date = in.readInt();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public int getTitle() {
        return title;
    }

    public int getSubscription() {
        return subscription;
    }

    public int getDate() {
        return date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(title);
        dest.writeInt(subscription);
        dest.writeInt(date);
    }
}