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
        if(args[0].equalsIgnoreCase("domain") || args[0].equalsIgnoreCase("d")){
            ((TreeSet<String>) Stor.stor.get("gfw")).add("||"+args[1]);
        }else if(args[0].equalsIgnoreCase("subdomain") || args[0].equalsIgnoreCase("s")){
            ((TreeSet<String>) Stor.stor.get("gfw")).add("|"+args[1]);
        }else if(args[0].equalsIgnoreCase("regex") || args[0].equalsIgnoreCase("r")){
            ((TreeSet<String>) Stor.stor.get("gfw")).add(args[1]);
        }else if(args[0].equalsIgnoreCase("not") || args[0].equalsIgnoreCase("n")){
            ((TreeSet<String>) Stor.stor.get("gfw")).add("@@"+args[1]);
        }else if(args[0].equalsIgnoreCase("notdomain") || args[0].equalsIgnoreCase("nd")){
            ((TreeSet<String>) Stor.stor.get("gfw")).add("@@||"+args[1]);
        }else if(args[0].equalsIgnoreCase("notsubdomain") || args[0].equalsIgnoreCase("nsd")){
            ((TreeSet<String>) Stor.stor.get("gfw")).add("@@|"+args[1]);
        }else{
            System.err.println("Not support.");
        }
    }
}
