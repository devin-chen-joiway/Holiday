package com.jw.devin.module.tools;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 过滤字符串的工具类
 */
public class FilterHelper {

    public static boolean isNum(String content){
        if (content==null||content==""){
            return false;
        }
        String regex = "^[0-9]*$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(content);

        return m.replaceAll("").length()==0;
    }
}
