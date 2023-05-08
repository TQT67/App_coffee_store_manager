package com.example.app_coffee_store_manager.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


import com.example.app_coffee_store_manager.Activities.HomeActivity;

import com.example.app_coffee_store_manager.DAO.DonDatDAO;
import com.example.app_coffee_store_manager.DTO.DonDatDTO;
import com.example.app_coffee_store_manager.R;

import java.util.List;

public class DisplayStatisticFragment extends Fragment {

    ListView lvStatistic;
    List<DonDatDTO> donDatDTOS;
    DonDatDAO donDatDAO;

    FragmentManager fragmentManager;
    int madon, manv, maban;
    String ngaydat, tongtien;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        setHasOptionsMenu(true);


        lvStatistic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });

        return null;
    }
}
