package com.example.app_coffee_store_manager.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.sinhvien.orderdrinkapp.DTO.ThanhToanDTO;
import com.sinhvien.orderdrinkapp.Database.CreateDatabase;

import java.util.ArrayList;
import java.util.List;

public class ThanhToanDAO {

    SQLiteDatabase database;
    public ThanhToanDAO(Context context){
        CreateDatabase createDatabase = new CreateDatabase(context);
        database = createDatabase.open();
    }

    public List<ThanhToanDTO> LayDSMonTheoMaDon(int madondat){
        List<ThanhToanDTO> thanhToanDTOS = new ArrayList<ThanhToanDTO>();
        String query = "SELECT * FROM "+CreateDatabase.TBL_CHITIETDONDAT+" ctdd,"+CreateDatabase.TBL_MON+" mon WHERE "
                +"ctdd."+CreateDatabase.TBL_CHITIETDONDAT_MAMON+" = mon."+CreateDatabase.TBL_MON_MAMON+" AND "
                +CreateDatabase.TBL_CHITIETDONDAT_MADONDAT+" = '"+madondat+"'";

        Cursor cursor = database.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            ThanhToanDTO thanhToanDTO = new ThanhToanDTO();
            thanhToanDTO.setSoLuong(cursor.getInt(cursor.getColumnIndex(CreateDatabase.TBL_CHITIETDONDAT_SOLUONG)));
            thanhToanDTO.setGiaTien(cursor.getInt(cursor.getColumnIndex(CreateDatabase.TBL_MON_GIATIEN)));
            thanhToanDTO.setTenMon(cursor.getString(cursor.getColumnIndex(CreateDatabase.TBL_MON_TENMON)));
            thanhToanDTO.setHinhAnh(cursor.getBlob(cursor.getColumnIndex(CreateDatabase.TBL_MON_HINHANH)));
            thanhToanDTOS.add(thanhToanDTO);

            cursor.moveToNext();
        }

        return thanhToanDTOS;
    }
}
