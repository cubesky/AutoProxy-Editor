package com.cubesky.modules;

import com.cubesky.core.Stor;
import com.cubesky.i.Module;

import java.util.TreeSet;

/**
 * Created by max_3 on 2017/1/2.
 */
public class Remove implements Module {
    @Override
    public void run(String[] args) throws Exception {
        if(args==null)return;
        if(args.length==1){
            ((TreeSet<String>) Stor.stor.get("gfw")).remove(args[0]);
        }
    }
}
