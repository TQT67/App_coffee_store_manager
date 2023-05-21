package com.example.app_coffee_store_manager.DAO;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.app_coffee_store_manager.DTO.QuyenDTO;
import com.example.app_coffee_store_manager.DataBase.CreateDatabase;

import java.util.ArrayList;
import java.util.List;
public class QuyenDAO {

    SQLiteDatabase database;
    public QuyenDAO(Context context){
        CreateDatabase createDatabase = new CreateDatabase(context);
        database = createDatabase.open();
    }

    public void ThemQuyen(String tenquyen){
        ContentValues contentValues = new ContentValues();
        contentValues.put(CreateDatabase.TBL_QUYEN_TENQUYEN,tenquyen);
        database.insert(CreateDatabase.TBL_QUYEN,null,contentValues);
    }


    public String LayTenQuyenTheoMa(int maquyen){
        String tenquyen ="";
        String query = "SELECT * FROM "+CreateDatabase.TBL_QUYEN+" WHERE "+CreateDatabase.TBL_QUYEN_MAQUYEN+" = "+maquyen;
        Cursor cursor = database.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            tenquyen = cursor.getString(cursor.getColumnIndex(CreateDatabase.TBL_QUYEN_TENQUYEN));
            cursor.moveToNext();
        }
        return tenquyen;
    }
}

