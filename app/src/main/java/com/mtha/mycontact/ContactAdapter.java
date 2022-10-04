package com.mtha.mycontact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter<MyContact> {

    //khai bao 1 so thuoc tinh cua adapter
    ArrayList<MyContact> mData;
    Context mContext;
    public ContactAdapter(@NonNull Context context, ArrayList<MyContact> data) {
        super(context, R.layout.item_contact,data);
        this.mContext =context;
        this.mData = data;
    }
    //tao mot lop view lookup
    private static class ViewHolder{
        ImageView imgProfile;
        TextView tvName;
        TextView tvPhone;
        ImageButton imgCall, imgSend, imgDel;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Nullable
    @Override
    public MyContact getItem(int position) {
        return mData.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        MyContact contact = getItem(position);
        //kiem tra xem view da co chua
        ViewHolder viewHolder;
        if(convertView ==null){
            //khoi tao doi tuong viewholder va thuc hien set view
            viewHolder= new ViewHolder();
            LayoutInflater inflater =LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_contact,
                    parent,false);
            viewHolder.imgProfile = convertView.findViewById(R.id.imgProfile);
            viewHolder.tvName = convertView.findViewById(R.id.tvName);
            viewHolder.tvPhone = convertView.findViewById(R.id.tvPhone);
            viewHolder.imgCall = convertView.findViewById(R.id.imgCall);
            viewHolder.imgSend = convertView.findViewById(R.id.imgSend);
            viewHolder.imgDel = convertView.findViewById(R.id.imgDel);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //xet data cho cac view
        viewHolder.imgProfile.setImageResource(contact.getImgId());
        viewHolder.tvName.setText(contact.getName());
        viewHolder.tvPhone.setText(contact.getPhone());
        //xu ly su kien tren cac imagebutton
        viewHolder.imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Thuc hien cuoc goi " + contact.getPhone(),
                        Toast.LENGTH_LONG).show();
            }
        });
        viewHolder.imgSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Thuc hien gui tin nhan",
                        Toast.LENGTH_LONG).show();
            }
        });
        return convertView;
    }
}
