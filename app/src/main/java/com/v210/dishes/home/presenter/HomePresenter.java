package com.v210.dishes.home.presenter;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import com.v210.db.DBHelper;
import com.v210.dishes.home.model.DishBean;
import com.v210.dishes.home.model.DishListAdapter;
import com.v210.dishes.home.view.IHomeView;
import java.util.ArrayList;

/**
 * Created by Jack on 16/2/18.
 */
public class HomePresenter implements  IHomePresenter
{
    private IHomeView homeView;
    private View.OnClickListener item1Click;
    private View.OnClickListener item2Click;
    private final Handler handler =new Handler(Looper.getMainLooper());
    private ArrayList<DishBean> dishList;
    private DishListAdapter adapter;
    public HomePresenter(IHomeView homeView)
    {
        this.homeView=homeView;
        dishList = new ArrayList<DishBean>();
        adapter = new DishListAdapter((Activity) homeView, getAdapterDataList());
    }

    /**
     * 向Adapter加载数据
     *
     * @param helper
     */
    public void loadData(final DBHelper helper)
    {
        if (adapter!=null)
        {
            new Thread(new Runnable()
            {
                public void run()
                {
                    ArrayList<DishBean> dishList =   helper.getFromDatabase();
                    if (dishList!=null&&dishList.size()>0)
                    {
                        adapter.addToList(dishList,true);
                        //刷新UI数据
                        handler.post(new Runnable()
                        {
                            public void run()
                            {
                                adapter.notifyDataSetChanged();
                                //使用异步回调方式加载数据
                                homeView.loadDataFinished();
                            }
                        });
                    }
                }
            }).start();
        }
    }
    public void setItem1ClickListener(View v)
    {
        item1Click=new View.OnClickListener()
        {
            public void onClick(View v)
            {
                homeView.onItem1Click(v);
            }
        };
        v.setOnClickListener(item1Click);
    }

    public void setItem2ClickListener(View v)
    {
        item2Click=new View.OnClickListener()
        {
            public void onClick(View v)
            {
                homeView.onItem2Click(v);
            }
        };

        v.setOnClickListener(item2Click);
    }


    public void startSearch(String searchText)
    {
        dishList.clear();
        for (DishBean bean :adapter.getBackupList())
        {
            if (bean.getName().contains(searchText)||
                bean.getPinyin().toLowerCase().contains(searchText)||
                bean.getPinyinHead().toLowerCase().contains(searchText))
            {
                dishList.add(bean);
            }
        }
        adapter.notifyDataSetChanged();
    }


    public ArrayList<DishBean> getAdapterDataList()
    {
        return dishList;
    }

    public DishListAdapter getDishListAdapter()
    {
        return adapter;
    }

    public void resetDishList()
    {
        adapter.getData().clear();
        adapter.getData().addAll(adapter.getBackupList());
        adapter.notifyDataSetChanged();
    }
}
