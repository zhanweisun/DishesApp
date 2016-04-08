package com.v210.dishes.home.presenter;

import android.view.View;
import com.v210.db.DBHelper;
import com.v210.dishes.home.model.DishBean;
import com.v210.dishes.home.model.DishListAdapter;

import java.util.ArrayList;

/**
 * Created by Jack on 16/2/18.
 */
public interface IHomePresenter
{
    public void loadData(DBHelper helper);
    public void setItem1ClickListener(View v);
    public void setItem2ClickListener(View v);
    public void startSearch(String searchText);
    public ArrayList<DishBean> getAdapterDataList();
    public DishListAdapter getDishListAdapter();
    public void resetDishList();

}
