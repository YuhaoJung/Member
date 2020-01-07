package com.fju.member;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText name;
    private EditText age;
    private EditText gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        gender = findViewById(R.id.gender);
    }

    public void ok(View view){
        String okname = name.getText().toString();
        String okage = age.getText().toString();
        String okgender = gender.getText().toString();
        if(TextUtils.isEmpty(okname)||TextUtils.isEmpty(okage)||TextUtils.isEmpty(okgender)){
            Intent intent = new Intent(MainActivity.this,NicknameActivity.class);
            startActivityForResult(intent,9);
        }
        else {
            new AlertDialog.Builder(this)
                    .setMessage("成功")
                    .setPositiveButton("ok",null)
                    .show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        name.setText(getSharedPreferences("test",MODE_PRIVATE).getString("niceName",""));
        age.setText(getSharedPreferences("test",MODE_PRIVATE).getString("age",""));
        gender.setText(getSharedPreferences("test",MODE_PRIVATE).getString("gender",""));
    }
}
