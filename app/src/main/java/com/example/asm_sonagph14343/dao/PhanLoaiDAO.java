package com.example.asm_sonagph14343.dao;

import android.content.ContentValues;
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
        cs.close();
        db.close();
        return ds;
    }
    public boolean insert(PhanLoai phanLoai){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("TenLoai",phanLoai.getTenLoai());
        contentValues.put("TrangThai", phanLoai.getTrangThai());
        long row = db.insert("PHANLOAI",null,contentValues);
        return (row > 0);
    }
    public boolean insert(String tenLoai, String trangThai){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("TenLoai",tenLoai);
        contentValues.put("TrangThai", trangThai);
        long row = db.insert("PHANLOAI",null,contentValues);
        return (row > 0);
    }
    public boolean update(PhanLoai phanLoai){
        //String sql = "UPDATE PHANLOAI SET  TenLoai=?, TrangThai=? WHERE MaLoai=?";
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("TenLoai",phanLoai.getTenLoai());
        contentValues.put("TrangThai", phanLoai.getTrangThai());
        int row = db.update("PHANLOAI", contentValues, "WHERE MaLoai=?",
                new String[]{phanLoai.getMaLoai()+""});
        return (row>0);
    }
    public boolean delete(int maLoai){
        //String sql = "DELETE FROM PHANLOAI WHERE MaLoai=?";
        SQLiteDatabase db = helper.getWritableDatabase();
        int row = db.delete("PHANLOAI","WHERE MaLoai=?",
                new String[]{maLoai+""});
        return(row>0);
    }
}
