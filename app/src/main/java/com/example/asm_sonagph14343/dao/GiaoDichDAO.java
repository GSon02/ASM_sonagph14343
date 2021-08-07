package com.example.asm_sonagph14343.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.asm_sonagph14343.database.DbHelper;
import com.example.asm_sonagph14343.model.GiaoDich;
import com.example.asm_sonagph14343.model.PhanLoai;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GiaoDichDAO {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    DbHelper helper;
    public GiaoDichDAO(Context context){
        helper = new DbHelper(context);
    }
    public ArrayList<GiaoDich> getALL(){
        ArrayList<GiaoDich> ds = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "SELECT * FROM GIAODICH";
        Cursor cs = db.rawQuery(sql, null);
        cs.moveToFirst();
        while (cs.isAfterLast() == false){
            int ma = cs.getInt(0);
            String tieuDe = cs.getString(1);
            Date ngay = simpleDateFormat.getCalendar().getTime();
            try {
                ngay = simpleDateFormat.parse(cs.getString(2));
            }catch (Exception e){
                e.printStackTrace();
            }
            double tien = cs.getDouble(3);
            String moTa = cs.getString(4);
            int maLoai = cs.getInt(5);

            GiaoDich giaoDich = new GiaoDich(ma,tieuDe,ngay,tien,moTa,maLoai);
            ds.add(giaoDich);
            cs.moveToNext();
        }
        cs.close();
        db.close();
        return ds;
    }
    public void insert(){}
    public void update(){}
    public void delete(){}
}
