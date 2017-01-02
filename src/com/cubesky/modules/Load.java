package com.cubesky.modules;

import com.cubesky.core.Stor;
import com.cubesky.i.Module;

import java.io.*;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by max_3 on 2017/1/2.
 */
public class Load implements Module {
    @Override
    public void run(String[] args) throws IOException {
        if(args==null){
            args=new String[]{"gfw_whitelist.txt"};
        }
        BufferedReader reader=new BufferedReader(new FileReader(new File(String.join(" ",args).replace("\"",""))));
        reader.lines()
                .filter(s -> !s.equals(""))
                .filter(s -> (!s.startsWith("!")))
                .forEach(Stor.gfw::add);
        reader.close();
        System.out.println("Load Finished.");
    }
}
