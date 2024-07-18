package com.example.lixiaomai.backend.tools;

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
}
