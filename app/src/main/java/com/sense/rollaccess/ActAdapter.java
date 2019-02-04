package com.sense.rollaccess;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by m2270073 on 2019/01/31.
 */

public class ActAdapter extends BaseAdapter {
    private Context context = null;
    private ArrayList<Act> act = null;
    private int resource = 0;

    public ActAdapter(Context context, ArrayList<Act> act, int resource) {
        this.context = context;
        this.act = act;
        this.resource = resource;
    }

    @Override
    public int getCount() {
        return act.size();
    }

    @Override
    public Object getItem(int i) {
        return act.get(i);
    }

    @Override
    public long getItemId(int i) {
        return act.get(i).getId();
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Activity activity = (Activity) context;
        Act act = ((Act) getItem(i));

        if (view == null) {
            view = activity.getLayoutInflater().inflate(resource, null);
        }
        if (act.getId() == 1) {
            ((TextView) view.findViewById(R.id.Id)).setText("番号");
        } else {
            ((TextView) view.findViewById(R.id.Id)).setText(String.valueOf(act.getId()));
        }
        ((TextView) view.findViewById(R.id.Actor)).setText(act.getActor());
        ((TextView) view.findViewById(R.id.Act)).setText(act.getAct());
        ((TextView) view.findViewById(R.id.Val)).setText(act.getVal());
        ((TextView) view.findViewById(R.id.Dice_num)).setText(act.getDice_num());
        ((TextView) view.findViewById(R.id.Dice_type)).setText(act.getDice_type());
        ((TextView) view.findViewById(R.id.Collect)).setText(act.getCollect());
        ((TextView) view.findViewById(R.id.Success)).setText(act.getSuccess());

        return view;
    }
}
