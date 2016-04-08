package com.v210.dishes.add.presenter;

import android.text.TextUtils;
import android.widget.EditText;
import com.v210.db.DBHelper;
import com.v210.dishes.add.view.IAddView;
import com.v210.dishes.home.model.DishBean;
import com.v210.utils.ChineseToEnglish;

/**
 * Created by Jack on 16/2/19.
 */
public class AddPresenter implements IAddPresenter
{
    private IAddView iAddView;
    public AddPresenter(IAddView iAddView)
    {
        this.iAddView = iAddView;
    }

    public void writeToDatabase(final DBHelper dbHelper, final String dishName, final int price, final int vipPrice, final String pinyinFullStr, final String pinyinHeadStr)
    {
        DishBean dishBean = new DishBean(dishName, price, vipPrice, 0, pinyinFullStr, pinyinHeadStr, "");
        dbHelper.writeToDatabase(dishBean);
    }


    public void createPinYin(final EditText name, final EditText pinyin, final EditText pinyinHead,boolean focus)
    {
        String nameText = name.getText().toString();
       String  pinyinStr = "";
       String pinyinHeadStr = "";
        if (!focus)
        {
            if (!TextUtils.isEmpty(nameText))
            {
                pinyinStr = ChineseToEnglish.getPingYin(nameText);
                pinyinHeadStr = ChineseToEnglish.getPinYinHeadChar(nameText);
                pinyin.setText(pinyinStr);
                pinyinHead.setText(pinyinHeadStr);
            }
            else
            {
                pinyin.getText().clear();
                pinyinHead.getText().clear();
            }
        }
    }
}
