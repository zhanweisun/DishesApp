package com.v210.dishes.home.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jack on 16/2/17.
 */
public class DishBean implements Parcelable
{
    public DishBean()
    {

    }

    public DishBean(String name, int price, int priceVip, int value, String pinyin, String pinyinHead, String imgPath)
    {
        this.name = name;
        this.price = price;
        this.vipprice = priceVip;
        this.value = value;
        this.pinyin = pinyin;
        this.pinyinHead = pinyinHead;
        this.imgPath = imgPath;
    }

    private String name;
    private int price;

    public int getCount()
    {
        return count;
    }

    public void setCount(final int count)
    {
        this.count = count;
    }

    private int count=0;
    public int getVipprice()
    {
        return vipprice;
    }

    public void setVipprice(final int vipprice)
    {
        this.vipprice = vipprice;
    }

    private int vipprice;
    private int value;
    private int id;
    private boolean selected;
    private String imgPath;
    private String pinyin;
    private String pinyinHead;

    public boolean isSelected()
    {
        return selected;
    }

    public void setSelected(boolean pSelected)
    {
        selected = pSelected;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int pId)
    {
        id = pId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String pName)
    {
        name = pName;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int pPrice)
    {
        price = pPrice;
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int pValue)
    {
        value = pValue;
    }

    public String getImgPath()
    {
        return imgPath;
    }

    public void setImgPath(String pImgPath)
    {
        imgPath = pImgPath;
    }

    public String getPinyin()
    {
        return pinyin;
    }

    public void setPinyin(String pPinyin)
    {
        pinyin = pPinyin;
    }

    public String getPinyinHead()
    {
        return pinyinHead;
    }

    public void setPinyinHead(String pPinyinHead)
    {
        pinyinHead = pPinyinHead;
    }


    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(this.name);
        dest.writeInt(this.price);
        dest.writeInt(this.count);
        dest.writeInt(this.vipprice);
        dest.writeInt(this.value);
        dest.writeInt(this.id);
        dest.writeByte(selected ? (byte) 1 : (byte) 0);
        dest.writeString(this.imgPath);
        dest.writeString(this.pinyin);
        dest.writeString(this.pinyinHead);
    }

    protected DishBean(Parcel in)
    {
        this.name = in.readString();
        this.price = in.readInt();
        this.count = in.readInt();
        this.vipprice = in.readInt();
        this.value = in.readInt();
        this.id = in.readInt();
        this.selected = in.readByte() != 0;
        this.imgPath = in.readString();
        this.pinyin = in.readString();
        this.pinyinHead = in.readString();
    }

    public static final Creator<DishBean> CREATOR = new Creator<DishBean>()
    {
        @Override
        public DishBean createFromParcel(Parcel source) {return new DishBean(source);}

        @Override
        public DishBean[] newArray(int size) {return new DishBean[size];}
    };
}
