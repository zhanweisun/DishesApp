package com.v210.dishes.add.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.v210.db.DBHelper;
import com.v210.dishes.R;
import com.v210.dishes.add.presenter.AddPresenter;
import com.v210.utils.Utils;

/**
 * Created by Jack on 16/2/19.
 */
public class AddActivity extends Activity implements IAddView
{
    private AddPresenter addPresenter;
    private ImageView close;
    private TextView save;
    private EditText name;
    private EditText price;
    private EditText vipPrice;
    private EditText pinyinFull;
    private EditText pinyinHead;
    private String pinyinStr;
    private String pinyinHeadStr;
    public   static final int RESULT_CODE=1000;
    private View.OnClickListener saveClick = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            String dishName = name.getText().toString().trim();
            String priceStr = price.getText().toString().trim();
            String priceVipStr = vipPrice.getText().toString().trim();
            String pinyinFullStr = pinyinFull.getText().toString().trim();
            String pinyinHeadStr = pinyinHead.getText().toString().trim();
            if (TextUtils.isEmpty(dishName))
            {
                Utils.makeToast(AddActivity.this, "请输入菜品名称");
                return;
            }

            if (TextUtils.isEmpty(priceStr))
            {
                Utils.makeToast(AddActivity.this, "请输入价格");
                return;
            }
            int price = 0;
            try
            {
                price = Integer.parseInt(priceStr)*100;
            }
            catch (NumberFormatException e)
            {
                price = 0;
            }
            if (TextUtils.isEmpty(priceVipStr))
            {
                Utils.makeToast(AddActivity.this, "请输入Vip价格");
                return;
            }
            int vipPrice = 0;
            try
            {
                vipPrice = Integer.parseInt(priceVipStr)*100;
            }
            catch (NumberFormatException e)
            {
                vipPrice = 0;
            }

            if (TextUtils.isEmpty(pinyinFullStr))
            {
                Utils.makeToast(AddActivity.this, "请输入拼音全称");
                return;
            }
            if (TextUtils.isEmpty(pinyinHeadStr))
            {
                Utils.makeToast(AddActivity.this, "请输入拼音首字母");
                return;
            }

            DBHelper dbHelper = new DBHelper(AddActivity.this);
            addPresenter.writeToDatabase(dbHelper,dishName,price,vipPrice,pinyinFullStr,pinyinHeadStr);
            Utils.makeToast(AddActivity.this, "添加成功");
            Intent intent =new Intent();
            intent.putExtra("Name",dishName);
            AddActivity.this.setResult(RESULT_CODE,intent);
            AddActivity.this.finish();
        }
    };

    protected void onCreate(Bundle savedInstanceState)
    {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_add);
        addPresenter =new AddPresenter(this);
        close = (ImageView) findViewById(R.id.close);
        save = (TextView) findViewById(R.id.save);
        name = (EditText) findViewById(R.id.editText1);
        price = (EditText) findViewById(R.id.editText2);
        vipPrice = (EditText) findViewById(R.id.editText3);
        pinyinFull = (EditText) findViewById(R.id.editText4);
        pinyinHead = (EditText) findViewById(R.id.editText5);
        save.setOnClickListener(saveClick);
        close.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                AddActivity.this.finish();
            }
        });
        name.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            public void onFocusChange(View v, boolean hasFocus)
            {
                addPresenter.createPinYin(name,pinyinFull,pinyinHead,hasFocus);
            }
        });
    }


}
