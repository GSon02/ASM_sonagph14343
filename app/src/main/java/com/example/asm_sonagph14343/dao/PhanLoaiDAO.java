package com.example.asm_sonagph14343.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.asm_sonagph14343.database.DbHelper;
import com.example.asm_sonagph14343.model.PhanLoai;

import java.util.ArrayList;

public class PhanLoaiDAO {
    DbHelper helper;
    public PhanLoaiDAO(Context context){
       helper = new DbHelper(context);
    }
    /**
     * @param: no param
     * @return: ArrayList<PhanLoai>
     */
    public ArrayList<PhanLoai> getALL(){
        ArrayList<PhanLoai> ds = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "SELECT * FROM PHANLOAI";
        Cursor cs = db.rawQuery(sql, null);
        cs.moveToFirst();
        while (cs.isAfterLast() == false){
            int ma = cs.getInt(0);
            String ten = cs.getString(1);
            String trangthai = cs.getString(2);
            PhanLoai Pl = new PhanLoai(ma,ten,trangthai);
            ds.add(Pl);
            cs.moveToNext();
        }
        return ds;
    }
    public void insert(){}
    public void update(){}
    public void delete(){}
}
