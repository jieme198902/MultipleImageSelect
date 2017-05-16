package com.darsh.multipleimageselect.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Darshan on 4/18/2015.
 */
public class Image2 implements Parcelable {
    public long id;
    public String name;
    public String path;
    public boolean isSelected;

    public Image2(long id, String name, String path, boolean isSelected) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.isSelected = isSelected;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeString(path);
    }

    public static final Parcelable.Creator<Image2> CREATOR = new Parcelable.Creator<Image2>() {
        @Override
        public Image2 createFromParcel(Parcel source) {
            return new Image2(source);
        }

        @Override
        public Image2[] newArray(int size) {
            return new Image2[size];
        }
    };

    private Image2(Parcel in) {
        id = in.readLong();
        name = in.readString();
        path = in.readString();
    }
}
