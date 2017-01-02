package com.cubesky.modules;

import com.cubesky.core.Stor;
import com.cubesky.i.Module;

import java.util.TreeSet;

/**
 * Created by max_3 on 2017/1/2.
 */
public class Sort {
    public static void doSort() throws Exception {
        TreeSet<String> gfw=new TreeSet<String>();
        ((TreeSet<String>) Stor.stor.get("gfw")).stream().sorted().forEach(gfw::add);
        Stor.stor.remove("gfw");
        Stor.stor.put("gfw",gfw);
        System.out.println("Sorted.");
    }
}
