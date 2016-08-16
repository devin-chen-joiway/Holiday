package com.jw.devin.module.tools;

import android.content.Context;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by devin on 16/6/7.
 */
public class FileHelper {

    public  static boolean createFile(Context ctx,String name){
        File file = new File(Environment.getDownloadCacheDirectory(),"holiday");
        if (!file.exists()){
            return file.mkdirs();
        }
        return false;
    }


    public static void read(Context ctx,String fileName){
        FileInputStream fileInputStream =null;
        BufferedReader bufferedReader =null;
        StringBuffer sb = new StringBuffer();
        try {
            fileInputStream = ctx.openFileInput(fileName);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String content = "";
            try {
                if ((content=bufferedReader.readLine())!=null){
                    sb.append(content);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Log.d("devin",sb.toString());
    }

    public static void save(Context ctx,String content){
        FileOutputStream fileOutputStream;
        BufferedWriter bufferedWriter = null;
        try {
             fileOutputStream = ctx.openFileOutput("holiday.txt",Context.MODE_PRIVATE);
            bufferedWriter  = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            try {
                bufferedWriter.write(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {

                try {
                    if (bufferedWriter!=null) {
                        bufferedWriter.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
    }
}
