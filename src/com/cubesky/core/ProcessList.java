package com.cubesky.core;

import com.cubesky.i.Module;
import com.cubesky.modules.*;

import java.util.HashMap;

/**
 * Created by max_3 on 2017/1/1.
 */
public class ProcessList {
    public static HashMap<String,Module> processlist=new HashMap<>();

    public static void initprocess(){
        processlist.put("exit",new Exit());
        processlist.put("load",new Load());
        processlist.put("show",new Show());
        processlist.put("add",new Add());
        processlist.put("remove",new Remove());
        processlist.put("save",new Save());
        processlist.put("help",new Help());
    }
}
