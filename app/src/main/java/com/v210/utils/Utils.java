package com.v210.utils;

import android.content.Context;
import android.os.Build;
import android.widget.Toast;

import java.text.DecimalFormat;

/**
 * Created by Jack on 16/2/18.
 */
public class Utils
{

	public static void makeToast(Context context,String text)
	{
		Toast.makeText(context,text,Toast.LENGTH_LONG).show();
	}


  public  static int dpToPx(Context context, float dp)
    {
        final float scale = context.getResources().getDisplayMetrics().density;
        return Math.round(dp * scale);
    }

   public static boolean hasJellyBean()
    {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
    }

    public static boolean hasLollipop()
    {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }


    public static final String getFormatVal(int val)
    {
        if (val ==0)
        {
            return  "0";
        }
        else
        {
            double result = val / 100;
            return getFormatVal(result, "#.00");
        }
    }

    public static final String getFormatVal(double  val ,String format)
    {
        DecimalFormat df  =new DecimalFormat(format);
        return df.format(val);
    }
}
