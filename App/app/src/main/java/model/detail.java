package model;

import android.os.Parcel;
import android.os.Parcelable;

public class detail implements Parcelable {

    private String name, address;
    private int age;



    protected detail(Parcel in) {
        name = in.readString();
        age = in.readInt();
        address = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeString(address);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<detail> CREATOR = new Creator<detail>() {
        @Override
        public detail createFromParcel(Parcel in) {
            return new detail(in);
        }

        @Override
        public detail[] newArray(int size) {
            return new detail[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public detail(String name, int age, String address ) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
