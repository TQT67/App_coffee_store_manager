package com.example.app_coffee_store_manager.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import com.example.app_coffee_store_manager.Activities.HomeActivity;
import com.example.app_coffee_store_manager.CustomAdapter.AdapterRecycleViewCategory;

import com.example.app_coffee_store_manager.DAO.DonDatDAO;
import com.example.app_coffee_store_manager.DAO.LoaiMonDAO;
import com.example.app_coffee_store_manager.DTO.DonDatDTO;
import com.example.app_coffee_store_manager.DTO.LoaiMonDTO;
import com.example.app_coffee_store_manager.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class DisplayHomeFragment extends Fragment implements View.OnClickListener {

    RecyclerView rcv_displayhome_LoaiMon, rcv_displayhome_DonTrongNgay;
    RelativeLayout layout_displayhome_ThongKe,layout_displayhome_XemBan, layout_displayhome_XemMenu, layout_displayhome_XemNV;
    TextView txt_displayhome_ViewAllCategory, txt_displayhome_ViewAllStatistic;
    LoaiMonDAO loaiMonDAO;
    DonDatDAO donDatDAO;
    List<LoaiMonDTO> loaiMonDTOList;
    List<DonDatDTO> donDatDTOS;
    AdapterRecycleViewCategory adapterRecycleViewCategory;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        setHasOptionsMenu(true);
        //endregion

        //khởi tạo kết nối

        HienThiDSLoai();
        HienThiDonTrongNgay();

        layout_displayhome_ThongKe.setOnClickListener(this);
        layout_displayhome_XemBan.setOnClickListener(this);
        layout_displayhome_XemMenu.setOnClickListener(this);
        layout_displayhome_XemNV.setOnClickListener(this);
        txt_displayhome_ViewAllCategory.setOnClickListener(this);
        txt_displayhome_ViewAllStatistic.setOnClickListener(this);

        return null;
    }

    private void HienThiDSLoai(){
        rcv_displayhome_LoaiMon.setHasFixedSize(true);
        rcv_displayhome_LoaiMon.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        rcv_displayhome_LoaiMon.setAdapter(adapterRecycleViewCategory);
        adapterRecycleViewCategory.notifyDataSetChanged();
    }

    private void HienThiDonTrongNgay(){
        rcv_displayhome_DonTrongNgay.setHasFixedSize(true);
        rcv_displayhome_DonTrongNgay.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String ngaydat= dateFormat.format(calendar.getTime());

        adapterRecycleViewCategory.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        NavigationView navigationView = (NavigationView)getActivity().findViewById(R.id.navigation_view_trangchu);
    }
}

