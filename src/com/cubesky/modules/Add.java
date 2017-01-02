package com.cubesky.modules;

import com.cubesky.core.Stor;
import com.cubesky.i.Module;

import java.util.TreeSet;

/**
 * Created by max_3 on 2017/1/2.
 */
public class Add implements Module {
    @Override
    public void run(String[] args) throws Exception {
        if(args==null){
            System.out.println();
            return;
        }
        if(args.length!=2){
            System.err.println("Error Args");
            return;
        }
        if(args[0].equalsIgnoreCase("domain") || args[0].equalsIgnoreCase("d") || args[0].equalsIgnoreCase("-d")){
            Stor.gfw.add("||"+args[1]);
        }else if(args[0].equalsIgnoreCase("subdomain") || args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("-s")){
            Stor.gfw.add("|"+args[1]);
        }else if(args[0].equalsIgnoreCase("regex") || args[0].equalsIgnoreCase("r") || args[0].equalsIgnoreCase("-r")){
            Stor.gfw.add(args[1]);
        }else if(args[0].equalsIgnoreCase("not") || args[0].equalsIgnoreCase("n") || args[0].equalsIgnoreCase("-n")){
            Stor.gfw.add("@@"+args[1]);
        }else if(args[0].equalsIgnoreCase("notdomain") || args[0].equalsIgnoreCase("nd") || args[0].equalsIgnoreCase("-nd")){
            Stor.gfw.add("@@||"+args[1]);
        }else if(args[0].equalsIgnoreCase("notsubdomain") || args[0].equalsIgnoreCase("nsd") || args[0].equalsIgnoreCase("-nsd")){
            Stor.gfw.add("@@|"+args[1]);
        }else{
            System.err.println("Not support.");
        }
    }
}
