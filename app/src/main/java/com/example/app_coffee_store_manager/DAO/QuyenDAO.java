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
}
