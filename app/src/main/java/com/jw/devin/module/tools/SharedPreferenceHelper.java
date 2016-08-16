package com.jw.devin.module.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by devin on 16/6/7.
 */
public class SharedPreferenceHelper {

    private static  SharedPreferences sf=null;
    private static SharedPreferences.Editor editor=null;
    public static SharedPreferences getInstance(Context ctx){
        if (sf==null){
            synchronized (SharedPreferenceHelper.class){
                if (sf==null){
                    return ctx.getSharedPreferences("devin_holiday",Context.MODE_PRIVATE);
                }
            }
        }
        return sf;
    }

    public  void doPut(String context,String object){
        if (editor==null){
            synchronized (SharedPreferenceHelper.class){
                if (editor==null){
                    editor = sf.edit();
                }
            }
        }
        editor.putString(context,object).commit();
    }

    public static void test(){
        Log.d("devin",sf.getBoolean("devin",true)+"");
        sf.edit().putBoolean("devin",true).commit();
    }


}
