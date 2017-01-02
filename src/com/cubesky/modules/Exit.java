package com.cubesky.modules;

import com.cubesky.core.Inputer;
import com.cubesky.i.Module;

/**
 * Created by max_3 on 2017/1/1.
 */
public class Exit implements Module {
    @Override
    public void run(String[] args) {
        System.out.println("Exit...");
        Inputer.stop();
        System.exit(0);
    }
}
