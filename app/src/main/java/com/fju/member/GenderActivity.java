package com.fju.member;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class GenderActivity extends AppCompatActivity {

    private EditText edgender;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        edgender = findViewById(R.id.gender);
        intent = new Intent(GenderActivity.this,MainActivity.class);
    }
    public void next2(View view) {
        String gender = edgender.getText().toString();
        if(!TextUtils.isEmpty(gender)){
            SharedPreferences pref = getSharedPreferences("test",MODE_PRIVATE);
            pref.edit()
                    .putString("gender",gender)
                    .commit();
            startActivityForResult(intent,8);
            finish();
        }
        else {
            new AlertDialog.Builder(this)
                    .setTitle("錯誤")
                    .setMessage("資料不能為空")
                    .setPositiveButton("ok",null)
                    .show();
        }
    }
}
