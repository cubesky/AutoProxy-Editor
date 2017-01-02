package com.cubesky.modules;

import com.cubesky.core.View;
import com.cubesky.i.Module;

import java.io.FileWriter;

/**
 * Created by max_3 on 2017/1/2.
 */
public class Save implements Module {
    @Override
    public void run(String[] args) throws Exception {
        if(args==null){
            args=new String[]{"gfw_whitelist.txt"};
        }
        FileWriter fileWriter=new FileWriter(args[0]);
        fileWriter.write(View.getTagView());
        fileWriter.flush();
        fileWriter.close();
        System.out.println("Saved.");
    }
}
