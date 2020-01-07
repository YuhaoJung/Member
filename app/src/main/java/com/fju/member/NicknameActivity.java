package com.fju.member;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class NicknameActivity extends AppCompatActivity {


    private EditText nickname;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);
        nickname = findViewById(R.id.nickname);
        intent = new Intent(NicknameActivity.this,AgeActivity.class);

    }
    public void next (View view){
        String nextNickname = nickname.getText().toString();
        if(!TextUtils.isEmpty(nextNickname)){
            SharedPreferences pref = getSharedPreferences("test",MODE_PRIVATE);
            pref.edit()
                    .putString("nickName",nextNickname)
                    .commit();
            startActivityForResult(intent,10);
            setResult(RESULT_OK);
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

