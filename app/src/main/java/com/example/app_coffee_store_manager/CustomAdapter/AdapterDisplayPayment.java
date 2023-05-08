package com.example.app_coffee_store_manager.CustomAdapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.app_coffee_store_manager.DTO.ThanhToanDTO;
import com.example.app_coffee_store_manager.R;

import java.util.List;


public class AdapterDisplayPayment extends BaseAdapter {

    Context context;
    int layout;
    List<ThanhToanDTO> thanhToanDTOList;
    ViewHolder viewHolder;

    public AdapterDisplayPayment(Context context, int layout, List<ThanhToanDTO> thanhToanDTOList){
        this.context = context;
        this.layout = layout;
        this.thanhToanDTOList = thanhToanDTOList;
    }
    @Override
    public int getCount() {
        return thanhToanDTOList.size();
    }

    @Override
    public Object getItem(int position) {
        return thanhToanDTOList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,parent,false);

            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)view.getTag();
        }
        ThanhToanDTO thanhToanDTO = thanhToanDTOList.get(position);

        return view;
    }

    public class ViewHolder{
        TextView txt_custompayment_TenMon, txt_custompayment_SoLuong, txt_custompayment_GiaTien;
    }
}
