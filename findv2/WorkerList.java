package com.example.findv2;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class WorkerList extends ArrayAdapter<Worker> {

    private Activity context;
    private List<Worker> workerlist;

    public WorkerList(Activity context,List<Worker> workerlist ){
        super(context,R.layout.list_layout,workerlist);
        this.context = context;
        this.workerlist = workerlist;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView,ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout,null,true);

        TextView listname =listViewItem.findViewById(R.id.listname);
        TextView number =listViewItem.findViewById(R.id.listmobile);
        TextView rating =listViewItem.findViewById(R.id.listrating);

        Worker worker = workerlist.get(position);

        listname.setText(worker.Name);
        number.setText(String.valueOf(worker.Mobile));
        rating.setText(String.valueOf(worker.Rating));

        return listViewItem;
    }
}
