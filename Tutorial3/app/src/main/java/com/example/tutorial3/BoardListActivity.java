package com.example.tutorial3;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class BoardListActivity extends AppCompatActivity {
LinearLayout LinearLayout_free_board;
LinearLayout LinearLayout_private_board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boardlist);
        LinearLayout_free_board = findViewById(R.id.LinearLayout_free_board);
        LinearLayout_free_board.setClickable(true);

        LinearLayout_free_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),NewsActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout_private_board = findViewById(R.id.LinearLayout_private_board);
        LinearLayout_private_board.setClickable(true);

    }
}