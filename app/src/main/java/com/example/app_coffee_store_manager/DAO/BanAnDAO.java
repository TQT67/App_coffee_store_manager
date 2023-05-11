    package com.example.app_coffee_store_manager.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.app_coffee_store_manager.DataBase.CreateDatabase;

    public class BanAnDAO { SQLiteDatabase database;
    public BanAnDAO(Context context){
        CreateDatabase createDatabase = new CreateDatabase(context);
        database = createDatabase.open();
    }

        //Hàm thêm bàn ăn mới
        public boolean ThemBanAn(String tenban){
            ContentValues contentValues = new ContentValues();
            contentValues.put(CreateDatabase.TBL_BAN_TENBAN,tenban);
            contentValues.put(CreateDatabase.TBL_BAN_TINHTRANG,"false");

            long ktra = database.insert(CreateDatabase.TBL_BAN,null,contentValues);
            if(ktra != 0){
                return true;
            }else {
                return false;
            }
        }

        //Hàm xóa bàn ăn theo mã
        public boolean XoaBanTheoMa(int maban){
            long ktra =database.delete(CreateDatabase.TBL_BAN,CreateDatabase.TBL_BAN_MABAN+" = "+maban,null);
            if(ktra != 0){
                return true;
            }else {
                return false;
            }
        }

        //Sửa tên bàn
        public boolean CapNhatTenBan(int maban, String tenban){
            ContentValues contentValues = new ContentValues();
            contentValues.put(CreateDatabase.TBL_BAN_TENBAN,tenban);

            long ktra = database.update(CreateDatabase.TBL_BAN,contentValues,CreateDatabase.TBL_BAN_MABAN+ " = '"+maban+"' ",null);
            if(ktra != 0){
                return true;
            }else {
                return false;
            }
        }

}
