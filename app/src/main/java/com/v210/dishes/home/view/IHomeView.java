package com.v210.dishes.home.view;

import android.view.View;

/**
 * Created by Jack on 16/2/18.
 */
public interface IHomeView
{
    public void onItem1Click(View view);
    public void onItem2Click(View view);
    public void loadDataFinished();
    public String getSearchText();
    public void searchFinish();
}
