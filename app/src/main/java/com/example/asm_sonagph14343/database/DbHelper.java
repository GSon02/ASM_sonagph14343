package com.example.asm_sonagph14343.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context){
        super(context, "ASM_SONAGPH14343",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE PHANLOAI(Maloai integer primary key autoincrement," +
                "Tenloai text, TrangThai text)";
        db.execSQL(sql);
        sql = "INSERT INTO PHANLOAI VALUES(null, 'Luong' + 'Thu')";
        db.execSQL(sql);
        sql = "INSERT INTO PHANLOAI VALUES(null, 'Thu No' + 'Thu')";
        db.execSQL(sql);
        sql = "INSERT INTO PHANLOAI VALUES(null, 'Khac' + 'Thu')";
        db.execSQL(sql);
        sql = "INSERT INTO PHANLOAI VALUES(null, 'Du Lich' + 'Chi')";
        db.execSQL(sql);
        sql = "INSERT INTO PHANLOAI VALUES(null, 'Sinh Hoat' + 'Chi')";
        db.execSQL(sql);

        sql = "CREATE TABLE GIAODICH(MaGD integer primary key autoincrement," +
                "TieuDe text, Ngay text,Tien text,MoTa text," +
                "MaLoai integer references PHANLOAI(MaLoai))";
        sql = "INSERT INTO GIAODICH VALUES(null,'Luong Thang 7', '2021-08-07',1000,'Luong Thang 7, on dinh',1)";
        db.execSQL(sql);
        sql = "INSERT INTO GIAODICH VALUES(null,'Tien mua thuc an hang ngay', '2021-08-07',1000,'Luong Thang 7, on dinh',1)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS PHANLOAI");
        db.execSQL("DROP TABLE IF EXISTS GIAODICH");
        onCreate(db);
    }
}
