package com.example.kobot.myposition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //버튼 생성하여 블루투스 화면 전환
        Button button_bluetooth_btn = (Button) findViewById(R.id.bluetooth_btn);
        button_bluetooth_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivity(intent);
            }
        });

        //버튼 생성하여 데이터 보기(daily,weekly,monthly 그래프) 화면 전환
        Button button_data_btn = (Button) findViewById(R.id.data_btn);
        button_data_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Sub2Activity.class);
                startActivity(intent);
            }
        });
    }


}
