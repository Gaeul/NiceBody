package com.example.kobot.myposition;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.List;





/**
 * Created by kobot on 2017-09-12.
 */

public class Sub2Activity extends AppCompatActivity implements View.OnClickListener{

    //레이아웃 선언 위한 레이아웃 변수 선언
    ConstraintLayout daily;
    LinearLayout weekly;
    LinearLayout monthly;

    //daily의 pie chart 3개에 대한 정보
    float firstPie[]={10.3f, 89.7f};
    String firstPieNames[]= {"Braided", "Not Braided"};

    float secondPie[]={70.8f, 29.2f};
    String secondPieNames[]= {"Correct", "Incorrect"};

    float thirdPie[]={70.0f, 30.0f};
    String thirdPieNames[]= {"Correct", "InCorrect"};


    //weekly의 그래프뷰 graphView
    GraphView graphView;
    LineGraphSeries<DataPoint> series;

    //monthly의 그래프뷰 graphViewMonthly
    GraphView graphViewMonthly;
    LineGraphSeries<DataPoint> seriesMonthly;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph_activity);

        //선언한 변수에 생성한 레이아웃 설정
        daily=(ConstraintLayout)findViewById(R.id.daily);
        weekly=(LinearLayout)findViewById(R.id.weekly);
        monthly=(LinearLayout)findViewById(R.id.monthly);

        //버튼 선언 _ daily weekly monthly
        Button bt1=(Button) findViewById(R.id.button1);
        Button bt2=(Button) findViewById(R.id.button2);
        Button bt3=(Button) findViewById(R.id.button3);

        //버튼 클릭 이벤트 처리
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);

        //daily의 PieChart함수(맨 밑에 정의)
        setupPieChart();

        //weekly 그래프뷰
        graphView=(GraphView) findViewById(R.id.graphView);
        series=new LineGraphSeries<>(getDataPoint());
        graphView.addSeries(series);

        //monthly 그래프뷰
        graphViewMonthly=(GraphView)findViewById(R.id.graphViewMonthly);
        seriesMonthly=new LineGraphSeries<>(getDataPointMonthly());
        graphViewMonthly.addSeries(seriesMonthly);


        //weekly x축과 y축 표시방법
        graphView.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            public String formatLabel(double value, boolean isValueX){
                if(isValueX){
                    return "day"+super.formatLabel(value,isValueX);
                } else{
                    return super.formatLabel(value,isValueX);
                }
            }
        });

        //monthly x축과 y축 표시방법
        graphViewMonthly.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            public String formatLabel(double value, boolean isValueX){
                if(isValueX){
                    return "day"+super.formatLabel(value,isValueX);
                } else{
                    return super.formatLabel(value,isValueX);
                }
            }
        });
    }

    //weekly dataPoint
    private DataPoint[] getDataPoint(){
        DataPoint[] dp=new DataPoint[]{
                new DataPoint(1,11),
                new DataPoint(2,3),
                new DataPoint(3,2),
                new DataPoint(4,5),
                new DataPoint(5,7),
                new DataPoint(6,4),
                new DataPoint(7,9)
        };
        return dp;
    }

    //monthly dataPoint
    private DataPoint[] getDataPointMonthly(){
        DataPoint[] dpMonthly=new DataPoint[]{
                new DataPoint(1,11),
                new DataPoint(2,6),
                new DataPoint(3,1),
                new DataPoint(4,2),
                new DataPoint(5,6),
                new DataPoint(6,2),
                new DataPoint(7,9),
                new DataPoint(8,6),
                new DataPoint(9,2),
                new DataPoint(10,3),
                new DataPoint(11,6),
                new DataPoint(12,9),
                new DataPoint(13,6),
                new DataPoint(14,2),
                new DataPoint(15,3),
                new DataPoint(16,1),
                new DataPoint(17,13),
                new DataPoint(18,3),
                new DataPoint(19,7),
                new DataPoint(20,4),
                new DataPoint(21,5),
                new DataPoint(22,5),
                new DataPoint(23,6),
                new DataPoint(24,7),
                new DataPoint(25,8),
                new DataPoint(26,9),
                new DataPoint(27,10),
                new DataPoint(28,2),
                new DataPoint(29,3),
                new DataPoint(30,5),
                new DataPoint(31,6)
        };
        return dpMonthly;
    }


    public void onClick(View arg0){
        //버튼 클릭시 이벤트 처리
        switch (arg0.getId()){
            case R.id.button1:
                // 버튼1이 눌렸을때 1번째 레이아웃 보이고 나머지는 숨기게
                daily.setVisibility(View.VISIBLE);
                weekly.setVisibility(View.GONE);
                monthly.setVisibility(View.GONE);

                break;

            case R.id.button2:
                // 버튼2이 눌렸을때 2번째 레이아웃 보이고 나머지는 숨기게
                daily.setVisibility(View.GONE);
                weekly.setVisibility(View.VISIBLE);
                monthly.setVisibility(View.GONE);

                break;
            case R.id.button3:
                // 버튼3이 눌렸을때 3번째 레이아웃 보이고 나머지는 숨기게
                daily.setVisibility(View.GONE);
                weekly.setVisibility(View.GONE);
                monthly.setVisibility(View.VISIBLE);

                break;
        }
    }

    private void setupPieChart(){
        //populating a list of PieEntries;
        List<PieEntry> pieEntries = new ArrayList<>();
        for(int i=0; i<firstPie.length; i++){
            pieEntries.add(new PieEntry(firstPie[i], firstPieNames[i]));
        }


        List<PieEntry> pieEntries2 = new ArrayList<>();
        for(int i=0; i<secondPie.length; i++){
            pieEntries2.add(new PieEntry(secondPie[i], secondPieNames[i]));
        }

        List<PieEntry> pieEntries3 = new ArrayList<>();
        for(int i=0; i<thirdPie.length; i++){
            pieEntries3.add(new PieEntry(thirdPie[i], thirdPieNames[i]));
        }

        //차트1 start
        PieDataSet dataSet = new PieDataSet(pieEntries, "");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData data=new PieData(dataSet);

        PieChart chart = (PieChart) findViewById(R.id.chart);
        chart.setData(data);
        chart.animateY(1000);
        chart.invalidate();


        //차트2
        PieDataSet dataSet2 = new PieDataSet(pieEntries2, "");
        dataSet2.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData data2=new PieData(dataSet2);

        PieChart chart2 = (PieChart) findViewById(R.id.chart2);
        chart2.setData(data2);
        chart2.animateY(1000);
        chart2.invalidate();


        //차트3
        PieDataSet dataSet3 = new PieDataSet(pieEntries3, "");
        dataSet3.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData data3=new PieData(dataSet3);

        PieChart chart3 = (PieChart) findViewById(R.id.chart3);
        chart3.setData(data3);
        chart3.animateY(1000);
        chart3.invalidate();


    }
}


