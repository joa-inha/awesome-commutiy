package com.example.tutorial3;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class replyActivity extends AppCompatActivity {

    private RecyclerView my_recycler_view;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    RequestQueue queue;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_hongchan);
        my_recycler_view = (RecyclerView)findViewById(R.id.Recycler_view_reply);

        my_recycler_view.setHasFixedSize(true); // row의 크기를 고정되게

        mLayoutManager = new LinearLayoutManager(this);
        my_recycler_view.setLayoutManager(mLayoutManager);


        //1. 화면이 로딩 -> 뉴스 정보를 받아온다
        queue = Volley.newRequestQueue(this);// network통신을 하라고 volley에 요청(queue를 초기화 / queue를 이용하여 통신)
        getreply();
        //2. 정보 -> 어댑터에 넘겨준다
        //3. 어댑터 -> 셋팅


    }

    public void getreply(){

        String url ="https://newsapi.org/v2/top-headlines?country=kr&apiKey=20b1370b225d490196ffcadb7f463873"; // newsapi에서 얻은 주소 입력

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) { // 뉴스를 받아오면 동작할 코드를 입력 - 뉴스를 정상적으로 받아온다면 어댑터로 넘김(2번)

                        //String의 형태로 받아오기 때문에 이를 JSON으로 바꿔줘야함
                        //response ->> Newsdata Class로 분류
                        List<replyData> reply = new ArrayList<>(); // 여러개의 뉴스를 불러올 것이므로 List이용

                        try {
                            JSONObject jsonObj = new JSONObject(response);

                            JSONArray arrayArticles = jsonObj.getJSONArray("articles"); // articles라는 이름을 가진 배열을 가져와라

                            for(int i = 0; i<arrayArticles.length(); i++){
                                JSONObject obj = arrayArticles.getJSONObject(i);


                                replyData replydata = new replyData();
                                replydata.setTextView_writer_name(obj.getString("Writer_name"));// value값의 형태가 String인 것을 가져옴
                                replydata.setImageView_writer_image(obj.getString("Writer_image"));
                                replydata.setTextView_reply(obj.getString("reply"));
                                replydata.setTextView_reply_time(obj.getString("reply_time"));

                                reply.add(replydata);
                            }




                            mAdapter = new replyAdapter(reply, replyActivity.this); // dataset으로 서버 등에서 받아온 dataset을 어댑터로 넘겨줌
                            my_recycler_view.setAdapter(mAdapter); //어댑터 연결
                        } catch (JSONException e) { // response가 JSON의 형태가 아닐경우의 오류를 처리
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) { // 에러인 경우
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest); // 뉴스를 받아오라는 작업을 queue에 추가
    }

}
