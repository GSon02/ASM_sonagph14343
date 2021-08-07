package com.example.asm_sonagph14343;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.asm_sonagph14343.dao.PhanLoaiDAO;
import com.example.asm_sonagph14343.model.PhanLoai;

public class MainActivity extends AppCompatActivity {
    PhanLoaiDAO phanLoaiDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phanLoaiDAO = new PhanLoaiDAO(MainActivity.this);
        //ArrayList<PhanLoai> list = phanLoaiDAO.getALL();
        //Log.i("data", list.get(0).getTenLoai());

        PhanLoai phanLoai = new PhanLoai("Tien thue nha", "Chi");
        if(phanLoaiDAO.insert("Khac", "Chi")){
            Toast.makeText(MainActivity.this, "Thanh Cong !", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this, "That bai !", Toast.LENGTH_SHORT).show();
        }

    }
}