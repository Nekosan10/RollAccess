package com.sense.rollaccess;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button1, button2, button3, button4, button5, button6;
    private Intent intent;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitle("メイン画面");
        toolbar.setNavigationIcon(R.mipmap.android_icon);
        setSupportActionBar(toolbar);

        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:   //Webアプリリンク
                url = "https://script.google.com/macros/s/AKfycbx_ALLHlr3csroTShZPEk8Q7t_98pBVs1qNyj0izxc7SDf2Qg/exec";
                appget();
                break;
            case R.id.button2:  //スプレッドシートリンク
                //url = "https://docs.google.com/spreadsheets/d/1o6oPQ3wCB2MCc9zc8U3eHKKSfNc5HDdqGji_YFqf2XY/edit?usp=sharing";
                url = "https://docs.google.com/spreadsheets/d/e/2PACX-1vR_pGJF1jEepDsMbsR-TsCUoPSmT5dDZSTXTTT6qxqdNsqRvtsXcbzJL8LV8safG8JCt_BG9inuJ3ct/pubhtml?gid=454139356&single=true";
                appget();
                break;
            case R.id.button3:  //フォームリンク
                url = "https://goo.gl/forms/dMlQS0Snpc1mT3hf2";
                appget();
                break;
            case R.id.button4:  //ロール実行リンク
                url = "https://script.google.com/macros/s/AKfycbx_ALLHlr3csroTShZPEk8Q7t_98pBVs1qNyj0izxc7SDf2Qg/dev?roll=apprandom";
                appget();
                break;
            case R.id.button5:  //指定ロール実行リンク
                EditText editText = findViewById(R.id.editText3);
                url = "https://script.google.com/macros/s/AKfycbx_ALLHlr3csroTShZPEk8Q7t_98pBVs1qNyj0izxc7SDf2Qg/dev?roll=app" + editText.getText().toString();
                appget();
                break;
            case R.id.button6:  //リスト取得activity
                intent = new Intent(this, ListActivity.class);
                startActivity(intent);
                break;
            default:
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void appget() {
        intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

}
