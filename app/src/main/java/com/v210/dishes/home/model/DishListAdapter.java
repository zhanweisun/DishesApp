package com.v210.dishes.home.model;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.v210.dishes.R;
import com.v210.utils.Utils;

import java.util.ArrayList;


/**
 * Created by Jack on 16/2/18.
 */
public class DishListAdapter extends RecyclerView.Adapter<DishListAdapter.DishViewHolder>
{
    public void setNotifyAdapterChanged(final NotifyAdapterChanged notifyAdapterChanged)
    {
        this.notifyAdapterChanged = notifyAdapterChanged;
    }

    private NotifyAdapterChanged notifyAdapterChanged;
    private ArrayList<DishBean> dishList = null;

    public ArrayList<DishBean> getBackupList()
    {
        return backupList;
    }

    public void setBackupList(final ArrayList<DishBean> backupList)
    {
        this.backupList = backupList;
    }

    private ArrayList<DishBean> backupList =null;
    public ArrayList<DishBean> getData()
    {
        return dishList;
    }
    ArrayList<DishBean> result  =new ArrayList<DishBean>();
    public ArrayList<DishBean> getSelectedDishes()
    {
        result.clear();
        for (DishBean bean :backupList)
        {
            if (bean.isSelected())
            {
                result.add(bean);
            }
        }
        return result;
    }

    public void addToList(ArrayList<DishBean> data, boolean cleanOldData)
    {
        if (cleanOldData)
        {
            dishList.clear();
            backupList.clear();
        }
        dishList.addAll(data);
        backupList.addAll(data);
    }

    public DishViewHolder onCreateViewHolder(ViewGroup pViewGroup, int pI)
    {
        DishViewHolder holder = new DishViewHolder(LayoutInflater.from(context).inflate(R.layout.item_desh_view, pViewGroup, false));
        return holder;
    }

    private final Activity context;

    public DishListAdapter(Activity context, ArrayList<DishBean> data)
    {
        this.context = context;
        dishList = data;
        backupList = new ArrayList<DishBean>();
        backupList.addAll(data);
    }

    public void notifyDataChanged()
    {
        if (notifyAdapterChanged != null)
        {
            notifyAdapterChanged.dataChanged(getSelectedDishes());
        }
    }


    public void onBindViewHolder(DishViewHolder pDishViewHolder, int pI)
    {
        final DishBean bean = dishList.get(pI);
        pDishViewHolder.title.setText("名称:" + bean.getName());
        pDishViewHolder.price.setText("价格:" + Utils.getFormatVal(bean.getPrice()));
        pDishViewHolder.suggestVal.setText("Vip价格:" + Utils.getFormatVal(bean.getVipprice()));
        pDishViewHolder.itemView.setOnClickListener(new View.OnClickListener()
        {
             public void onClick(View v)
            {
                if (!bean.isSelected())
                {
                    new  MaterialDialog.Builder(context)
                        .title(R.string.input_content)
                        .positiveColor(context.getResources().getColor(R.color.primary))
                        .widgetColor(context.getResources().getColor(R.color.primary))
                        .contentColor(Color.LTGRAY)
                        .inputType(InputType.TYPE_CLASS_NUMBER )
                        .inputRange(1,3,context.getResources().getColor(R.color.md_red_500))
                        .input(R.string.input_content,R.string.input_prefill,new MaterialDialog.InputCallback(){
                            public void onInput(@NonNull final MaterialDialog dialog, final CharSequence input)
                            {
                                bean.setSelected(!bean.isSelected());
                                bean.setCount(Integer.parseInt(input.toString().trim()));
                                notifyDataSetChanged();
                                notifyDataChanged();
                            }
                        })
                        .show();
                }
                else
                {
                    bean.setSelected(!bean.isSelected());
                    bean.setCount(0);
                    notifyDataSetChanged();
                    notifyDataChanged();
                }

            }
        });
        if (bean.isSelected())
        {
            pDishViewHolder.selectedStatus.setBackgroundColor(context.getResources().getColor(R.color.selected));
        }
        else
        {
            pDishViewHolder.selectedStatus.setBackgroundColor(context.getResources().getColor(android.R.color.transparent));
        }
    }

    public int getItemCount()
    {
        if (dishList != null)
        {
            return dishList.size();
        }
        return 0;
    }

    /**
     * ViewHolder
     */
    public static class DishViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imgView;
        View selectedStatus;
        TextView title;
        TextView price;
        TextView suggestVal;

        public DishViewHolder(View itemView)
        {
            super(itemView);
            imgView = (ImageView) itemView.findViewById(R.id.imageView);
            selectedStatus = itemView.findViewById(R.id.selectedStatus);
            title = (TextView) itemView.findViewById(R.id.titleText);
            price = (TextView) itemView.findViewById(R.id.price);
            suggestVal = (TextView) itemView.findViewById(R.id.suggestVal);
        }
    }
}
