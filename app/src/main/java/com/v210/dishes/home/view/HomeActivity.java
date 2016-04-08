package com.v210.dishes.home.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.v210.db.DBHelper;
import com.v210.dishes.R;
import com.v210.dishes.add.view.AddActivity;
import com.v210.dishes.home.model.DishBean;
import com.v210.dishes.home.model.NotifyAdapterChanged;
import com.v210.dishes.home.presenter.HomePresenter;
import com.v210.dishes.list.view.DishesListActivity;
import com.v210.utils.HorizontalDividerItemDecoration;
import com.v210.utils.Utils;
import com.v210.widgets.FloatingActionButton;
import com.v210.widgets.FloatingActionMenu;

import java.util.ArrayList;

public class HomeActivity extends Activity implements IHomeView, NotifyAdapterChanged
{
    private RecyclerView recyclerView;

    private FloatingActionButton item1;
    private FloatingActionButton item2;
    private FloatingActionMenu actionMenu;
    private HomePresenter presenter;

    private DBHelper dbHelper;
    private EditText searchEdit;
    private Button searchBtn;
    private TextView price;
    private TextView dishCount;
    private TextWatcher textWatcher = new TextWatcher()
    {
        public void beforeTextChanged(final CharSequence s, final int start, final int count, final int after)
        {

        }

        public void onTextChanged(final CharSequence s, final int start, final int before, final int count)
        {
            if (s == null || s.length() == 0)
            {
                presenter.resetDishList();
                presenter.getDishListAdapter().notifyDataChanged();
            }
            else
            {
                presenter.startSearch(s.toString());
            }
        }

        public void afterTextChanged(final Editable s)
        {

        }
    };

    protected void onResume()
    {
        super.onResume();
    }

    public void onCreate(Bundle savedInstanceState)
    {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_home);
//        FrameLayout root = (FrameLayout) findViewById(R.id.root);
//        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT)
//        {
//            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
//            Rect frame = new Rect();
//            getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
//            int topMargin= frame.top;
//            params.setMargins(0,-topMargin,0,0);
//            root.setLayoutParams(params);
//        }

        price = (TextView) findViewById(R.id.price);
        dishCount = (TextView) findViewById(R.id.dishesCount);
        searchEdit = (EditText) findViewById(R.id.searchEdit);
        searchEdit.addTextChangedListener(textWatcher);
        searchBtn = (Button) findViewById(R.id.searchBtn);
        searchBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(final View v)
            {
                searchEdit.getText().clear();
            }
        });
        presenter = new HomePresenter(this);
        actionMenu = (FloatingActionMenu) findViewById(R.id.menu_labels_right);
        actionMenu.setClosedOnTouchOutside(true);
        item1 = (FloatingActionButton) findViewById(R.id.menu_Item1);
        item2 = (FloatingActionButton) findViewById(R.id.menu_Item2);
        //设置item的click处理
        presenter.setItem1ClickListener(item1);
        presenter.setItem2ClickListener(item2);
//        presenter.searchBtnClick(searchBtn);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(presenter.getDishListAdapter());
        recyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this).color(R.color.divider).build());
        dbHelper = new DBHelper(this);
        presenter.getDishListAdapter().setNotifyAdapterChanged(this);
        presenter.loadData(dbHelper);
        dataChanged(null);
    }


    public void onItem1Click(View view)
    {
        Intent mIntent = new Intent(this, AddActivity.class);
        startActivity(mIntent);
        actionMenu.close(true);
    }

    public void onItem2Click(View view)
    {
        ArrayList<DishBean> data = presenter.getDishListAdapter().getSelectedDishes();
        Intent intent = new Intent(this, DishesListActivity.class);
        intent.putParcelableArrayListExtra("data", data);
        startActivity(intent);
        actionMenu.close(true);
    }

    public void loadDataFinished()
    {
        //TODO 数据加载完成

    }

    public String getSearchText()
    {
        if (!TextUtils.isEmpty(searchEdit.getText()))
        {
            return searchEdit.getText().toString();
        }
        return "";
    }

    public void searchFinish()
    {

    }

    public void dataChanged(final ArrayList<DishBean> data)
    {
        int coast = 0;
        int vipcoast = 0;
        int dishesCount =0;
        if (data!=null)
        {
            dishesCount= data.size();
            for (DishBean bean : data)
            {
                coast += bean.getPrice() * bean.getCount();
                vipcoast += bean.getVipprice() * bean.getCount();
            }
        }
        price.setText(String.format("总价:%s元 | 会员价:%s 元", Utils.getFormatVal(coast), Utils.getFormatVal(vipcoast)));
        dishCount.setText(String.format("已点%s道菜", dishesCount));
    }


    private long firstTime = 0;

    public boolean onKeyUp(int keyCode, KeyEvent event)
    {
        // TODO Auto-generated method stub
        switch (keyCode)
        {
            case KeyEvent.KEYCODE_BACK:
                long secondTime = System.currentTimeMillis();
                if (secondTime - firstTime > 2000)
                {                                         //如果两次按键时间间隔大于2秒，则不退出
                    Utils.makeToast(this,"再按一次退出程序");
                    firstTime = secondTime;//更新firstTime
                    return true;
                }
                else
                {                                                    //两次按键小于2秒时，退出应用
                    HomeActivity.this.finish();
                    System.exit(0);
                }
                break;
        }
        return super.onKeyUp(keyCode, event);
    }

}
