package com.sense.rollaccess;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class ListActivity extends AppCompatActivity {
    private Context context;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar2);
        toolbar.setTitle("行動一覧取得");
        toolbar.setNavigationIcon(R.mipmap.android_icon);
        setSupportActionBar(toolbar);


        context = this;
        ListView listView = (ListView) findViewById(R.id.list_View);
        AsyncHTTP asyncHTTP = new AsyncHTTP(this, this);
        asyncHTTP.execute();


        listView.setOnItemLongClickListener((new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> adapterView, View view, final int i, long l) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                // AlertDialogのタイトル設定します

                alertDialogBuilder.setTitle("ロール確認");

                // AlertDialogのメッセージ設定
                alertDialogBuilder.setMessage("選択した項目をロールしますか？");

                // AlertDialogのYesボタンのコールバックリスナーを登録
                alertDialogBuilder.setPositiveButton("ロールする",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                String url = "https://script.google.com/macros/s/AKfycbx_ALLHlr3csroTShZPEk8Q7t_98pBVs1qNyj0izxc7SDf2Qg/dev?roll=app" + (i + 1);
                                listdone(url);
                            }
                        });
                // AlertDialogのNoボタンのコールバックリスナーを登録
                alertDialogBuilder.setNeutralButton("やめておく",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                // AlertDialogのキャンセルができるように設定
                alertDialogBuilder.setCancelable(true);

                AlertDialog alertDialog = alertDialogBuilder.create();
                // AlertDialogの表示
                alertDialog.show();
                return true;
            }
        }));

    }

    public void listdone(String url) {
        Intent intent = new Intent(this, Web_view.class);
        intent.putExtra("URL", url);
        startActivity(intent);
    }

}
