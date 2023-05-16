package com.example.app_coffee_store_manager.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.app_coffee_store_manager.DTO.MonDTO;
import com.example.app_coffee_store_manager.DataBase.CreateDatabase;

import java.util.ArrayList;
import java.util.List;

public class MonDAO {
    SQLiteDatabase database;
    public MonDAO(Context context){
        CreateDatabase createDatabase = new CreateDatabase(context);
        database = createDatabase.open();
    }

    public boolean ThemMon(MonDTO monDTO){
        ContentValues contentValues = new ContentValues();
        contentValues.put(CreateDatabase.TBL_MON_MALOAI,monDTO.getMaLoai());
        contentValues.put(CreateDatabase.TBL_MON_TENMON,monDTO.getTenMon());
        contentValues.put(CreateDatabase.TBL_MON_GIATIEN,monDTO.getGiaTien());
        contentValues.put(CreateDatabase.TBL_MON_HINHANH,monDTO.getHinhAnh());
        contentValues.put(CreateDatabase.TBL_MON_TINHTRANG,"true");

        long ktra = database.insert(CreateDatabase.TBL_MON,null,contentValues);

        if(ktra !=0){
            return true;
        }else {
            return false;
        }
    }
    public boolean XoaMon(int mamon){
        long ktra = database.delete(CreateDatabase.TBL_MON,CreateDatabase.TBL_MON_MAMON+ " = " +mamon
                ,null);
        if(ktra !=0 ){
            return true;
        }else {
            return false;
        }
    }
}
