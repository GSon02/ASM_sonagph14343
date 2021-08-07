package com.example.asm_sonagph14343;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.asm_sonagph14343.dao.PhanLoaiDAO;
import com.example.asm_sonagph14343.model.PhanLoai;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    PhanLoaiDAO phanLoaiDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phanLoaiDAO = new PhanLoaiDAO(MainActivity.this);
        ArrayList<PhanLoai> list = phanLoaiDAO.getALL();
        Log.i("data", list.get(0).getTenLoai());
    }
}