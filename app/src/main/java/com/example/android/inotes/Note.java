package com.example.android.inotes;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {
    private int textIndex;
    private String noteName;

    public Note(int textIndex, String noteName){
        this.textIndex = textIndex;
        this.noteName = noteName;
    }

    protected Note(Parcel in) {
        textIndex = in.readInt();
        noteName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getTextIndex());
        dest.writeString(getNoteName());
    }

    @Override
    public int describeContents() {
        return 0;
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

    public int getTextIndex() {
        return textIndex;
    }

    public String getNoteName() {
        return noteName;
    }
}

