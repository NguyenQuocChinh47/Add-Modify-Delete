package com.example.oop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvMonHoc;
    ArrayList<String> arrayList;
    EditText edtThem;
    Button btnThem, btnCapNhat;
    int viTri = -1;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList = new ArrayList<>();
        final ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);
        lvMonHoc = findViewById(R.id.lv_MonHoc);
        edtThem = findViewById(R.id.edt_Them);
        btnThem = findViewById(R.id.btn_Them);
        btnCapNhat =findViewById(R.id.btn_CapNhat);
        lvMonHoc.setAdapter(arrayAdapter);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monHoc = edtThem.getText().toString();
                if(monHoc.isEmpty() == false) {
                    arrayList.add(monHoc);
                    arrayAdapter.notifyDataSetChanged();
                    edtThem.setText("");
                }
                else {
                    Toast.makeText(MainActivity.this,"Dữ liệu nhập vào trống",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCapNhat.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   try {
                       arrayList.set(viTri, edtThem.getText().toString());
                       arrayAdapter.notifyDataSetChanged();
                       edtThem.setText("");
                   }catch (Exception ex){
                       Toast.makeText(MainActivity.this, "Chưa chọn vị trí để cập nhật", Toast.LENGTH_SHORT).show();
                   }
               }
        });


        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    edtThem.setText(arrayList.get(position));
                    viTri = position;
            }
        });

        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrayList.remove(position);
                arrayAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Đã xóa", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}