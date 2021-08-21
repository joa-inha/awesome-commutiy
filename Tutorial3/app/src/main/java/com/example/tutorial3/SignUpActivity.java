package com.example.tutorial3;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class SignUpActivity extends AppCompatActivity {

    TextInputEditText TextInputEditText_ID;
    TextInputEditText TextInputEditText_Password;
    TextInputEditText TextInputEditText_Birth_Date;
    TextInputEditText TextInputEditText_Nickname;
    RelativeLayout RelativeLayout_Done;

    class myTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(s!=null){
                RelativeLayout_Done.setEnabled(validation());
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }

    boolean isEmpty(TextInputEditText a){
        return a.getText().toString().isEmpty();
    }

    boolean validation(){
        return !(isEmpty(TextInputEditText_ID) || isEmpty(TextInputEditText_Password) || isEmpty(TextInputEditText_Birth_Date) || isEmpty(TextInputEditText_Nickname));
    }

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        TextInputEditText_ID = findViewById(R.id.TextInputEditText_ID);
        TextInputEditText_Password = findViewById(R.id.TextInputEditText_Password);
        TextInputEditText_Birth_Date = findViewById(R.id.TextInputEditText_Birth_Date);
        TextInputEditText_Nickname = findViewById(R.id.TextInputEditText_Nickname);
        RelativeLayout_Done = findViewById(R.id.RelativeLayout_Done);

        RelativeLayout_Done.setEnabled(false);

        myTextWatcher mtwID = new myTextWatcher();
        myTextWatcher mtwPassword = new myTextWatcher();
        myTextWatcher mtwBirthDate = new myTextWatcher();
        myTextWatcher mtwNickname = new myTextWatcher();


        TextInputEditText_ID.addTextChangedListener(mtwID);
        TextInputEditText_Password.addTextChangedListener(mtwPassword);
        TextInputEditText_Birth_Date.addTextChangedListener(mtwBirthDate);
        TextInputEditText_Nickname.addTextChangedListener(mtwNickname);

        RelativeLayout_Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validation()){
                   Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                   intent.putExtra("ID", TextInputEditText_ID.getText().toString());
                   intent.putExtra("Password", TextInputEditText_Password.getText().toString());
                   intent.putExtra("BirthDate", TextInputEditText_Birth_Date.getText().toString());
                   intent.putExtra("Nickname", TextInputEditText_Nickname.getText().toString());
                   startActivity(intent);

                }
            }
        });
    }
}