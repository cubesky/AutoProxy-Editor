package com.cubesky;

import com.cubesky.core.Inputer;
import com.cubesky.core.ProcessList;
import com.cubesky.i.Module;

public class Main {

    public static void main(String[] args) {
        System.out.println("AutoProxy Editor Cli Startup.");
        ProcessList.initprocess();
        if(args.length>0){
            Module module=ProcessList.processlist.get("load");
            try {
                module.run(args);
            } catch (Exception e) {
                System.err.println("Can not load.");
            }
        }
        Inputer.startInputer();
    }
}
