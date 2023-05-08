package com.example.app_coffee_store_manager.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


import com.example.app_coffee_store_manager.Activities.HomeActivity;
import com.example.app_coffee_store_manager.CustomAdapter.AdapterDisplayMenu;
import com.example.app_coffee_store_manager.DAO.MonDAO;
import com.example.app_coffee_store_manager.DTO.MonDTO;
import com.example.app_coffee_store_manager.R;

import java.util.List;

public class DisplayMenuFragment extends Fragment {

    int maloai, maban;
    String tenloai,tinhtrang;
    GridView gvDisplayMenu;
    MonDAO monDAO;
    List<MonDTO> monDTOList;
    AdapterDisplayMenu adapterDisplayMenu;

    ActivityResultLauncher<Intent> resultLauncherMenu = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent intent = result.getData();
                        boolean ktra = intent.getBooleanExtra("ktra",false);
                        String chucnang = intent.getStringExtra("chucnang");
                        if(chucnang.equals("themmon"))
                        {
                            if(ktra){
                                HienThiDSMon();
                                Toast.makeText(getActivity(),"Thêm thành công",Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(getActivity(),"Thêm thất bại",Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            if(ktra){
                                HienThiDSMon();
                                Toast.makeText(getActivity(),"Sửa thành công",Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(getActivity(),"Sửa thất bại",Toast.LENGTH_SHORT).show();
                            }
                        }

                    }
                }
            });


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        if(bundle !=null){
            maloai = bundle.getInt("maloai");
            tenloai = bundle.getString("tenloai");
            maban = bundle.getInt("maban");
            HienThiDSMon();

            gvDisplayMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //nếu lấy đc mã bàn mới mở

                    if(maban != 0){
                        if(tinhtrang.equals("true")){

                        }else {
                            Toast.makeText(getActivity(),"Món đã hết, không thể thêm", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        }
        setHasOptionsMenu(true);
        registerForContextMenu(gvDisplayMenu);
        return null;
    }

    //tạo 1 menu context show lựa chọn
    @Override
    public void onCreateContextMenu(ContextMenu menu,View v,ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

    }

    //Tạo phần sửa và xóa trong menu context
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int vitri = menuInfo.position;


        return true;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
    private void HienThiDSMon(){
        gvDisplayMenu.setAdapter(adapterDisplayMenu);
        adapterDisplayMenu.notifyDataSetChanged();
    }

}
