package com.v210.dishes.list.model;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.v210.dishes.R;
import com.v210.dishes.home.model.DishBean;

import java.util.ArrayList;

/**
 * Created by Jack on 16/4/1.
 */
public class DishesListAdapter extends RecyclerView.Adapter<DishesListAdapter.DishViewHolder>
{
    private ArrayList<DishBean> list;
    private Activity context;

    public DishesListAdapter(Activity context, ArrayList<DishBean> data)
    {
        this.context=context;
        list =data;
    }

    public DishViewHolder onCreateViewHolder(final ViewGroup viewGroup, final int i)
    {
        DishViewHolder holder = new DishesListAdapter.DishViewHolder(LayoutInflater.from(context).inflate(R.layout.item_dishes_lsit, viewGroup, false));
        return holder;
    }


    public void onBindViewHolder(final DishViewHolder dishViewHolder, final int i)
    {
        final DishBean bean = list.get(i);
        dishViewHolder.title.setText(bean.getName());
        dishViewHolder.count.setText(String.format("数量:%d",bean.getCount()));
    }

    public int getItemCount()
    {
        if (list!=null)
        {
            return list.size();
        }
        return 0;
    }

    public static class DishViewHolder extends RecyclerView.ViewHolder
    {
        TextView title;
        TextView count;
        public DishViewHolder(View itemView)
        {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            count = (TextView) itemView.findViewById(R.id.count);
        }
    }
}
