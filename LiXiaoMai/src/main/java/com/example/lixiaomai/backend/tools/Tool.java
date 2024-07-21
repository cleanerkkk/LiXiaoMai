package com.example.lixiaomai.backend.tools;

import java.util.ArrayList;
import java.util.List;
//123
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

    public static <T extends Number> List<T> stringToMixedList(String str, Class<T> type) {
        String[] strings = str.split(",");
        List<T> list = new ArrayList<>();
        for (String string : strings) {
            try {
                if (type.equals(Integer.class)) {
                    list.add((T) Integer.valueOf(Integer.parseInt(string)));
                } else if (type.equals(Double.class)) {
                    list.add((T) Double.valueOf(Double.parseDouble(string)));
                }
            } catch (NumberFormatException e) {
                // 忽略无法转换的元素
            }
        }
        return list;
    }
    public static  <T> List<T> StringToList(String str, Class<T> type){
        if (str == null)
            return null;
        String[] strings = str.split(",");
        List<T> list = new ArrayList<>();
        for (String string : strings) {
            try{
                list.add((T) Integer.valueOf(Integer.parseInt(string)));
            }
            catch (NumberFormatException e){
                try{
                    list.add((T) Double.valueOf(Double.parseDouble(string)));
                }
                catch (NumberFormatException e1){
                    e1.printStackTrace();
                }
            }
        }
        return list;

    }
}
