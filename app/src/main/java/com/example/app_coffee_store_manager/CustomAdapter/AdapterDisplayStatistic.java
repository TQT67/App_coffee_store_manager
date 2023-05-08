package com.example.app_coffee_store_manager.CustomAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.app_coffee_store_manager.DAO.BanAnDAO;
import com.example.app_coffee_store_manager.DAO.NhanVienDAO;
import com.example.app_coffee_store_manager.DTO.DonDatDTO;
import com.example.app_coffee_store_manager.DTO.NhanVienDTO;
import com.example.app_coffee_store_manager.R;

import java.util.List;

public class AdapterDisplayStatistic extends BaseAdapter {

    Context context;
    int layout;
    List<DonDatDTO> donDatDTOS;
    ViewHolder viewHolder;
    NhanVienDAO nhanVienDAO;
    BanAnDAO banAnDAO;

    public AdapterDisplayStatistic(Context context, int layout, List<DonDatDTO> donDatDTOS){
        this.context = context;
        this.layout = layout;
        this.donDatDTOS = donDatDTOS;
    }

    @Override
    public int getCount() {
        return donDatDTOS.size();
    }

    @Override
    public Object getItem(int position) {
        return donDatDTOS.get(position);
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
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,parent,false);

            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        DonDatDTO donDatDTO = donDatDTOS.get(position);

        return view;
    }
    public class ViewHolder{
        TextView txt_customstatistic_MaDon, txt_customstatistic_NgayDat, txt_customstatistic_TenNV
                ,txt_customstatistic_TongTien,txt_customstatistic_TrangThai, txt_customstatistic_BanDat;

    }
}
