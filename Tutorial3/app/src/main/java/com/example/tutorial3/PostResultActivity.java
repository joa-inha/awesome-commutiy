package com.example.tutorial3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class PostResultActivity extends AppCompatActivity {

TextView TextView_get;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //main이 아니라 여기서 시작
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //xml이랑 매칭시켜주는 코드
        TextView_get=findViewById(R.id.TextView_get);

        //값을 받을 intent 만들기
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();  // 일단 extra들을 bundle에 갖고옴
        String title = bundle.getString("title");
        String context = bundle.getString("context");
        TextView_get.setText(title+" / "+context);
    }
}