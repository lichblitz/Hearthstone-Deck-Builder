package com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.hsdeckbuilder.lichblitz.hsdeckbuilder.R;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain.DrawerItem;

import java.util.List;

/**
 * Created by ${user} on 7/09/15.
 */
public class DrawerAdapter extends ArrayAdapter<DrawerItem> {


    public DrawerAdapter(Context context, List<DrawerItem> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.item_drawer, null);
        }

        TextView itemTitle = (TextView) convertView.findViewById(R.id.text_drawer_item);
        ImageView itemImage = (ImageView) convertView.findViewById(R.id.icon_drawer_item);

        DrawerItem item = getItem(position);
        itemImage.setImageResource(R.drawable.icon_weapon_attack);
        itemImage.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        itemTitle.setText(item.getItemText());

        return convertView;
    }
}
