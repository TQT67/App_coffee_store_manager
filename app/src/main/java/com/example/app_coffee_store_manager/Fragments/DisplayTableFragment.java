package com.example.app_coffee_store_manager.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
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


import com.example.app_coffee_store_manager.Activities.HomeActivity;
import com.example.app_coffee_store_manager.CustomAdapter.AdapterDisplayTable;
import com.example.app_coffee_store_manager.DAO.BanAnDAO;
import com.example.app_coffee_store_manager.DTO.BanAnDTO;
import com.example.app_coffee_store_manager.R;

import java.util.List;

public class DisplayTableFragment extends Fragment {

    GridView GVDisplayTable;
    List<BanAnDTO> banAnDTOList;
    BanAnDAO banAnDAO;
    AdapterDisplayTable adapterDisplayTable;

    //Dùng activity result (activityforresult ko hổ trợ nữa) để nhận data gửi từ activity addtable
    ActivityResultLauncher<Intent> resultLauncherAdd = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent intent = result.getData();
                        boolean ktra = intent.getBooleanExtra("ketquathem",false);
                        if(ktra){
                            HienThiDSBan();
                            Toast.makeText(getActivity(),"Thêm thành công",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getActivity(),"Thêm thất bại",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });

    ActivityResultLauncher<Intent> resultLauncherEdit = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent intent = result.getData();
                        boolean ktra = intent.getBooleanExtra("ketquasua",false);
                        if(ktra){
                            HienThiDSBan();
                            Toast.makeText(getActivity(),getResources().getString(R.string.edit_sucessful),Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getActivity(),getResources().getString(R.string.edit_failed),Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.displaytable_layout,container,false);
        setHasOptionsMenu(true);
        GVDisplayTable = (GridView)view.findViewById(R.id.gvDisplayTable);
        HienThiDSBan();

        registerForContextMenu(GVDisplayTable);
        return view;
    }

    //tạo ra context menu khi longclick
    @Override
    public void onCreateContextMenu(ContextMenu menu,View v,ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    //Xử lí cho từng trường hợp trong contextmenu
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int vitri = menuInfo.position;


        return super.onContextItemSelected(item);
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

    @Override
    public void onResume() {
        super.onResume();
        adapterDisplayTable.notifyDataSetChanged();
    }

    private void HienThiDSBan(){
        GVDisplayTable.setAdapter(adapterDisplayTable);
        adapterDisplayTable.notifyDataSetChanged();
    }
}
