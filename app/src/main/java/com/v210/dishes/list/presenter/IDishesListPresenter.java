package com.v210.dishes.list.presenter;

import com.v210.dishes.home.model.DishBean;
import com.v210.dishes.list.model.DishesListAdapter;

import java.util.ArrayList;

/**
 * Created by Jack on 16/4/1.
 */
public interface IDishesListPresenter
{
    public DishesListAdapter createDishesAdapter(ArrayList<DishBean> data );
    public DishesListAdapter getDishesAdapter();

}
