package com.cubesky.core;

import com.cubesky.i.Module;
import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.Scanner;

/**
 * Created by max_3 on 2017/1/1.
 */
public class Inputer {
    private static Thread inputer;
    public static void startInputer(){
        if(inputer==null){
            inputer = new Thread(() -> {
                Scanner scanner=new Scanner(System.in);
                while(!inputer.isInterrupted()){
                    System.out.print("AutoProxy> ");
                    String input=scanner.nextLine().trim();
                    String[] operator=input.split(" ",2);
                    String[] args=null;
                    if(operator.length>1) args=operator[1].split(" ");
                    Module module=ProcessList.processlist.get(operator[0].toLowerCase());
                    if(module==null){
                        System.err.println("Command not found.");
                    }else{
                        try{
                            module.run(args);
                        }catch (Exception e){
                            e.printStackTrace();
                            System.err.println("Module Report a Exception.");
                        }
                    }
                }
            });
            inputer.start();
        }
    }

    public static void stop(){
        inputer.interrupt();
    }
}
