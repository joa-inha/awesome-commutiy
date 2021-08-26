package com.example.tutorial3;

// newsapi에서 정보를 가져올때 우리는 모든 정보를 가져올 필요가 없기 때문에
// 일부만 가져오기 위해 그것을 거르는 클래스 생성

import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class replyData implements Serializable { // Serializable는 직렬화라고 해서 데이터가 많고 형태가 이상할때 하나의 데이터 구조로 넘겨주고 받을 수 있게 함
    public String TextView_writer_name;
    public String TextView_reply;
    public String ImageView_writer_image;
    public String TextView_reply_time;


    public String getTextView_writer_name() {
        return TextView_writer_name;
    }

    public void setTextView_writer_name(String textView_writer_name) {
        TextView_writer_name = textView_writer_name;
    }

    public String getTextView_reply() {
        return TextView_reply;
    }

    public void setTextView_reply(String textView_reply) {
        TextView_reply = textView_reply;
    }

    public String getImageView_writer_image() {
        return ImageView_writer_image;
    }

    public void setImageView_writer_image(String imageView_writer_image) {
        ImageView_writer_image = imageView_writer_image;
    }

    public String getTextView_reply_time() {
        return TextView_reply_time;
    }

    public void setTextView_reply_time(String textView_reply_time) {
        TextView_reply_time = textView_reply_time;
    }




}
