package com.example.tutorial3;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;



public class PostActivity extends AppCompatActivity {

    EditText EditText_title;
    EditText EditText_context;
    Button Button_post;
    String input_title="";
    String input_context="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        EditText_title = findViewById(R.id.EditText_title);
        EditText_context = findViewById(R.id.EditText_context);
        Button_post = findViewById(R.id.Button_post);


        Button_post.setEnabled(false);
        EditText_title.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if( s != null){
                    input_title = s.toString();
                    Button_post.setEnabled((input_title!="") && (input_context!=""));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        EditText_context.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                Log.d("Senti", s + "," + count);
                if( s != null) {//이렇게 해야 안전
                    input_context = s.toString();
                    Button_post.setEnabled((input_title!="") && (input_context!=""));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        Button_post.setOnClickListener(new View.OnClickListener() { // 클릭 리스너를 달아줌 +  클릭 리스너를 바로 정의
            @Override
            public void onClick(View v) { //클릭을 감지하면 입력된 문자를 가져옴
                String title = EditText_title.getText().toString();//TextInputEditText에서 getText를 이용하여 가져온 문자의 타입은 Editable이므로 이를 다시 string으로 바꿔준다
                String context = EditText_context.getText().toString();

                Intent intent = new Intent(PostActivity.this, PostResultActivity.class);// Intent라는 방식을 통해 현재 액티비티(LoginActivity)에서 목표 액티비티(MainActivity)로 넘김
                intent.putExtra("title", title);
                intent.putExtra("context", context); // 값을 넘겨주는 함수 (값의 이름-string, 값-value)
                startActivity(intent); // 넘겨줄 값을 가지고 있는 intent를 가진채로 새 액티비티를 시작함
            }
        });

    }

//    public boolean validation(){
//        return (input_title!="") && (input_context!="");
//    }
}