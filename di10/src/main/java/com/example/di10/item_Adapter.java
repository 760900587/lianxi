package com.example.di10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 刘洪良 on 2020/4/14.
 */

public class item_Adapter extends BaseAdapter {
    private Context context;
    private ArrayList<ReanBean.DataBean> list;

    public item_Adapter(Context context, ArrayList<ReanBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_zi, null);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        ReanBean.DataBean bean = list.get(position);
        holder.desc.setText(bean.getDesc());
        holder.title.setText(bean.getTitle());
        String path = bean.getImagePath();
        new ImageLage(holder.image).execute(path);
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView image;
        public TextView title;
        public TextView desc;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.image = (ImageView) rootView.findViewById(R.id.image);
            this.title = (TextView) rootView.findViewById(R.id.title);
            this.desc = (TextView) rootView.findViewById(R.id.desc);
        }

    }
}
