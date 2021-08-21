package com.example.tutorial3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText TextInputEditText_Email;
    TextInputEditText TextInputEditText_Password;
    RelativeLayout RelativeLayout_Login;
    RelativeLayout RelativeLayout_Sign_Up; // RelativeLayout, TextInputEditText는 컴포넌트이름, int double등과 같이 (변수타입) (변수이름)으로 지역변수를 선언헀다고 생각하면 쉬움
    String emailOK = "123@gmail.com";
    String passwordOK = "1234"; // 원래는 이렇게 하면 안된다. 아이디와 비밀번호가 노출되기 떄문
    String inputemail = "";
    String inputpassword = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // 화면 매칭 R.layout.activity_login은 Resource의 layout인데 이름이 activity_login인 것과 화면 매칭하겠다는 뜻

        TextInputEditText_Email = findViewById(R.id.TextInputEditText_Email);
        TextInputEditText_Password = findViewById(R.id.TextInputEditText_Password);
        RelativeLayout_Login = findViewById(R.id.RelativeLayout_Login);
        RelativeLayout_Sign_Up = findViewById(R.id.RelativeLayout_Sign_Up);// findViewById를 통해 각 변수와 xml파일의 것들을 매칭 시켜줌
        // R.id.xxxx Resource의 id인데 이름이 xxxx인 것과 매칭

        //1. 값을 가져온다 - 검사 (123@gmail.com / 1234) -> xml에서 무조건 클릭할수 있는 clickalbe지움
        //2. 클릭을 감지한다
        //3. 1번의 값을 다음 액티비티로 넘긴다
        RelativeLayout_Login.setEnabled(false);
        TextInputEditText_Email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Log.d("Senti", s + "," + count); d는 debug를 의미. 즉, 디버그시 로그를 찍어보는 함수
                if( s != null){//이렇게 해야 안전
                    inputemail = s.toString();
                    RelativeLayout_Login.setEnabled(validation());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        TextInputEditText_Password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                Log.d("Senti", s + "," + count);
                if( s != null) {//이렇게 해야 안전
                    inputpassword = s.toString();
                    RelativeLayout_Login.setEnabled(validation());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

//        RelativeLayout_Login.setClickable(true);//클릭 가능 여부 설정 xml파일에서 해도 되고 java파일엣 해도 되는데 여기서 한번 더해줌
        RelativeLayout_Login.setOnClickListener(new View.OnClickListener() { // 클릭 리스너를 달아줌 +  클릭 리스너를 바로 정의
            @Override
            public void onClick(View v) { //클릭을 감지하면 입력된 문자를 가져옴
                String email = TextInputEditText_Email.getText().toString();//TextInputEditText에서 getText를 이용하여 가져온 문자의 타입은 Editable이므로 이를 다시 string으로 바꿔준다
                String password = TextInputEditText_Password.getText().toString();

                Intent intent = new Intent(MainActivity.this, MainActivity.class);// Intent라는 방식을 통해 현재 액티비티(LoginActivity)에서 목표 액티비티(MainActivity)로 넘김
                intent.putExtra("email", email);
                intent.putExtra("password", password); // 값을 넘겨주는 함수 (값의 이름-string, 값-value)
                startActivity(intent); // 넘겨줄 값을 가지고 있는 intent를 가진채로 새 액티비티를 시작함
            }
        });

        RelativeLayout_Sign_Up.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    public boolean validation(){
        return inputemail.equals(emailOK) && inputpassword.equals(passwordOK);
    }
}
