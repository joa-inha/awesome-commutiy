//package com.example.tutorial3
//
//import android.os.Bundle
//import android.widget.LinearLayout
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//
//class MainActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_freeboard)
//
//        //임시로 사용할 데이터 실제로는 서버통신을 통해 db나 json에서 가져옵니다. 이름들은 걍 떠오르는 이름 아무거나 썼어요
//        val userList = arrayListOf(
//                Users("심효근", "shimhg02@naver.com", "ㅎㅇ"),
//                Users("홍석진", "shimhg02@naver.com", "ㄷ"),
//                Users("박채연", "shimhg02@naver.com", "ㅁㄴㄴㄴㄴㅇㄹ"),
//                Users("한규언", "shimhg02@naver.com", "ㅁㄴㄹㅇㅇㅇㄹ"),
//                Users("이소명", "shimhg02@naver.com", "ㅇ"),
//                Users("박태욱", "shimhg02@naver.com", "코틀린최고"),
//                Users("박서연", "shimhg02@naver.com", "ㅁㄴㅇㄹㅁㄴㅇㄹ"),
//                Users("김민식", "shimhg02@naver.com", "ㄷ"),
//                Users("김태양", "shimhg02@naver.com", "할말없다"),
//                Users("최성희", "shimhg02@naver.com", "나는 킹갓이다")
//        )
//
//        //레이아웃매니저를 설정해줍니다.
//        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
//        recyclerView.setHasFixedSize(true)
//
//        //어댑터도 설정해줍니다.
//        recyclerView.adapter = RecyclerAdapter(userList)
//
//    }
//}