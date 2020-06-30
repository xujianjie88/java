package com.xjj.java.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 * unmodifiableMap
 * unmodifiableList
 * unmodifiableSet
 */
public class UnModifyCollection {

    private static Map<Integer, String> map = new HashMap<Integer, String>();
    {
        map.put(1, "jay");
        map.put(2, "tianluo");

    }

    public static void main(String[] args) {
        map = Collections.unmodifiableMap(map);
        map.put(1, "boy");
        System.out.println(map.get(1));
    }

}
