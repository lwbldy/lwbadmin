package com.pearadmin.common.tools;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {
    /**
     * id 数组列表转换成List
     * @param ids
     * @return
     */
    public static List<Integer> StringToIntArr(String[] ids){
        if(ids == null || ids.length == 0){
            return new ArrayList<>();
        }

        List<Integer> idsArr = new ArrayList<>();
        for(String s : ids){
            try {
                idsArr.add(Integer.parseInt(s));
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return idsArr;
    }

}
