package com.v210.dishes.list.presenter;

import com.v210.dishes.home.model.DishBean;
import com.v210.dishes.list.model.DishesListAdapter;
import com.v210.dishes.list.view.DishesListActivity;
import com.v210.dishes.list.view.IDishesListView;

import java.util.ArrayList;

/**
 * Created by Jack on 16/4/1.
 */
public class DishesListPresenter implements IDishesListPresenter
{
    private IDishesListView dishesListView;
    private DishesListAdapter adapter ;
    public DishesListPresenter(IDishesListView dishesListView)
    {
        this.dishesListView =dishesListView;
    }

    public DishesListAdapter createDishesAdapter(final ArrayList<DishBean> data)
    {
        adapter = new DishesListAdapter((DishesListActivity)dishesListView, data);
        return adapter;
    }

    @Override
    public DishesListAdapter getDishesAdapter()
    {
        return adapter;
    }
}
