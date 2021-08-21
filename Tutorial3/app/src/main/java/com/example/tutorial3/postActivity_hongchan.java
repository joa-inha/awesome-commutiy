package com.example.tutorial3;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class postActivity_hongchan extends AppCompatActivity {

    ImageView ImageView_logo;
    TextInputEditText TextInputEditText_search;
    RelativeLayout RelativeLayout_search;
    TextView TextView_title;
    TextView TextView_date;
    TextView TextView_writer_name;
    ImageView ImageView_writer_image;
    ImageView ImageView_postimage;
    TextView TextView_postcontent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        ImageView_logo.findViewById(R.id.ImageView_logo);
        TextInputEditText_search.findViewById(R.id.TextInputEditText_search);
        RelativeLayout_search.findViewById(R.id.RelativeLayout_search);
        TextView_title.findViewById(R.id.TextView_title);
        TextView_date.findViewById(R.id.TextView_date);
        TextView_writer_name.findViewById(R.id.TextView_writer_name);
        ImageView_writer_image.findViewById(R.id.ImageView_writer_image);
        ImageView_postimage.findViewById(R.id.ImageView_postimage);
        TextView_postcontent.findViewById(R.id.TextView_postcontent);

        Intent receive_intent = getIntent();

        Bundle bundle = receive_intent.getExtras();
        String title = bundle.getString("title");
        String date = bundle.getString("date");
        String writer_name = bundle.getString("writer_name");
        String postcontent = bundle.getString("postcontent");

        TextView_title.setText(title);
        TextView_date.setText(date);
        TextView_writer_name.setText(writer_name);
        TextView_postcontent.setText(postcontent);

        ImageView_logo.setEnabled(true);
        ImageView_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(postActivity_hongchan.this,MainActivity.class);
                startActivity(intent);
            }
        });

        RelativeLayout_search.setEnabled(false);
        TextInputEditText_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Log.d("Senti", s + "," + count); d는 debug를 의미. 즉, 디버그시 로그를 찍어보는 함수
                if( s != null){//이렇게 해야 안전
                    RelativeLayout_search.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        RelativeLayout_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search = TextInputEditText_search.getText().toString();

                Intent intent = new Intent(postActivity_hongchan.this, MainActivity.class);
                intent.putExtra("search", search);
                startActivity(intent);

            }
        });

    }

}
