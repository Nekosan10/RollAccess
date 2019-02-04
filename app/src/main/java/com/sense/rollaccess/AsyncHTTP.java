package com.sense.rollaccess;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by m2270073 on 2019/01/31.
 */

public class AsyncHTTP extends AsyncTask {
    private Activity activity;
    private Context context;
    private ArrayList<Act> listData;

    public AsyncHTTP(Activity activity, Context context) {
        this.activity = activity;
        this.context = context;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        try {
            URL url = new URL("https://script.google.com/macros/s/AKfycbx_ALLHlr3csroTShZPEk8Q7t_98pBVs1qNyj0izxc7SDf2Qg/dev?roll=getlist");
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.connect();

            InputStream in = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));

            String jstr = "";
            String str = reader.readLine();
            while (str != null) {
                jstr = jstr + str;
                str = reader.readLine();
            }
            System.out.println(jstr);

            listData = new ArrayList<>();
            JSONArray json = new JSONArray(jstr);
            JSONObject job;
            Act act_title = new Act(1, "行動者名", "行動名", "判定値", "ダイスの数", "ダイスの種類", "補正値", "成功判定");
            listData.add(act_title);
            for (int i = 0; i < json.length(); i++) {
                job = json.getJSONObject(i);
                Act act = new Act(i + 2, job.get("行動者名").toString(), job.get("行動名").toString(), job.get("判定値").toString(), job.get("ダイスの数").toString(), job.get("ダイスの種類").toString(), job.get("補正値").toString(), job.get("成功判定").toString());
                listData.add(act);
            }

            reader.close();
            in.close();
            http.disconnect();
            return null;

        } catch (IOException e) {
            System.out.println(e);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object object) {
        ActAdapter actAdapter = new ActAdapter(context, listData, R.layout.act_layout);
        ListView listView = (ListView) activity.findViewById(R.id.list_View);
        listView.setAdapter(actAdapter);
    }
}
