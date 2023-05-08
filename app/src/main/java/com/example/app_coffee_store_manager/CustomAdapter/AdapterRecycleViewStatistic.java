package com.example.app_coffee_store_manager.CustomAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_coffee_store_manager.DAO.BanAnDAO;
import com.example.app_coffee_store_manager.DAO.NhanVienDAO;
import com.example.app_coffee_store_manager.DTO.DonDatDTO;
import com.example.app_coffee_store_manager.DTO.NhanVienDTO;
import com.example.app_coffee_store_manager.R;

import java.util.List;

public class AdapterRecycleViewStatistic extends RecyclerView.Adapter<AdapterRecycleViewStatistic.ViewHolder>{

    Context context;
    int layout;
    List<DonDatDTO> donDatDTOList;
    NhanVienDAO nhanVienDAO;
    BanAnDAO banAnDAO;

    public AdapterRecycleViewStatistic(Context context, int layout, List<DonDatDTO> donDatDTOList){

        this.context =context;
        this.layout = layout;
        this.donDatDTOList = donDatDTOList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DonDatDTO donDatDTO = donDatDTOList.get(position);

    }

    @Override
    public int getItemCount() {
        return donDatDTOList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_customstatistic_MaDon, txt_customstatistic_NgayDat, txt_customstatistic_TenNV,
                txt_customstatistic_BanDat, txt_customstatistic_TongTien,txt_customstatistic_TrangThai;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
        }
    }
}
