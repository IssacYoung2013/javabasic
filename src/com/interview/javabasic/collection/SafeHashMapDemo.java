package com.interview.javabasic.collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * author:  ywy
 * date:    2019-02-20
 * desc:
 */
public class SafeHashMapDemo {
    public static void main(String[] args) {
        Map hashMap = new HashMap();
        Map safeHashMap = Collections.synchronizedMap(hashMap);
        safeHashMap.put("aa","1");
        safeHashMap.put("bb","2");
        System.out.println(safeHashMap.get("bb"));
    }
}
