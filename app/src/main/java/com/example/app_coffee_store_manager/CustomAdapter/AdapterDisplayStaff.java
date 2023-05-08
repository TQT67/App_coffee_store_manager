package com.example.app_coffee_store_manager.CustomAdapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app_coffee_store_manager.DAO.QuyenDAO;
import com.example.app_coffee_store_manager.DTO.NhanVienDTO;
import com.example.app_coffee_store_manager.R;

import java.util.List;

public class AdapterDisplayStaff extends BaseAdapter {

    Context context;
    int layout;
    List<NhanVienDTO> nhanVienDTOS;
    ViewHolder viewHolder;
    QuyenDAO quyenDAO;

    public AdapterDisplayStaff(Context context, int layout, List<NhanVienDTO> nhanVienDTOS){
        this.context = context;
        this.layout = layout;
        this.nhanVienDTOS = nhanVienDTOS;
    }
    @Override
    public int getCount() {
        return nhanVienDTOS.size();
    }

    @Override
    public Object getItem(int position) {
        return nhanVienDTOS.get(position);
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
        NhanVienDTO nhanVienDTO = nhanVienDTOS.get(position);

        return view;
    }

    public class ViewHolder{
        ImageView img_customstaff_HinhNV;
        TextView txt_customstaff_TenNV, txt_customstaff_TenQuyen,txt_customstaff_SDT, txt_customstaff_Email;
    }
}
