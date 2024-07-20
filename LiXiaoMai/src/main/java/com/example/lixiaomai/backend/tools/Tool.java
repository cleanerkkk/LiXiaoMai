package com.example.lixiaomai.backend.tools;

import java.util.ArrayList;
import java.util.List;

public class Tool {
    public static <T> String ListToString(List<T> list){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static  List<Object> StringToList(String str){
        String[] strings = str.split(",");
        List<Object> list = new ArrayList<>();
        for (String string : strings) {
            try{
                list.add(Integer.parseInt(string));
            }
            catch (NumberFormatException e){
                try{
                    list.add(Double.parseDouble(string));
                }
                catch (NumberFormatException e1){
                    list.add(string);
                }
            }
        }
        return list;

    }
}
