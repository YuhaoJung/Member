package com.fju.member;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class AgeActivity extends AppCompatActivity {

    private EditText edage;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        edage = findViewById(R.id.edage);
        intent = new Intent(AgeActivity.this,GenderActivity.class);
    }
    public void next1 (View view){
        String age = edage.getText().toString();
        if(!TextUtils.isEmpty(age)){
            SharedPreferences pref = getSharedPreferences("test",MODE_PRIVATE);
            pref.edit()
                    .putString("age",age)
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
