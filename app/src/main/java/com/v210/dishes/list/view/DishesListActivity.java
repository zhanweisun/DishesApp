package com.v210.dishes.list.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.v210.dishes.R;
import com.v210.dishes.home.model.DishBean;
import com.v210.dishes.list.presenter.DishesListPresenter;
import com.v210.utils.HorizontalDividerItemDecoration;

import java.util.ArrayList;

/**
 * Created by Jack on 16/4/1.
 */
public class DishesListActivity extends Activity implements  IDishesListView
{
    RecyclerView listView;
    private DishesListPresenter presenter;
    public void onCreate(Bundle savedInstanceState)
    {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        presenter =new DishesListPresenter(this);
        setContentView(R.layout.act_dishes_list);
        listView = (RecyclerView) findViewById(R.id.recycler_view);
        ArrayList<DishBean> data =getIntent().getParcelableArrayListExtra("data");
        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.setAdapter(presenter.createDishesAdapter(data));
        listView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this).color(R.color.divider).build());
        View view =findViewById(R.id.close);
        view.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(final View v)
            {
                DishesListActivity.this.finish();
            }
        });
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }


}
