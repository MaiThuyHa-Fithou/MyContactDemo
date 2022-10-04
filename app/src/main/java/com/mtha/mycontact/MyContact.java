package com.mtha.mycontact;

public class MyContact {
    int imgId;
    String name, phone;

    public MyContact(int imgId, String name, String phone) {
        this.imgId = imgId;
        this.name = name;
        this.phone = phone;
    }

    public MyContact() {
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
