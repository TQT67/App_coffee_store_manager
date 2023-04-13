package com.example.app_coffee_store_manager.CustomAdapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.app_coffee_store_manager.R;
import java.util.List;

public class AdapterDisplayMenu extends BaseAdapter {

    Context context;
    int layout;

    Viewholder viewholder;

    //constructor

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            viewholder = new Viewholder();
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,parent,false);

            view.setTag(viewholder);
        }else {
            viewholder = (Viewholder) view.getTag();
        }
        return view;
    }

    //tạo viewholer lưu trữ component
    public class Viewholder{
        ImageView img_custommenu_HinhMon;
        TextView txt_custommenu_TenMon, txt_custommenu_GiaTien,txt_custommenu_TinhTrang;

    }
}
