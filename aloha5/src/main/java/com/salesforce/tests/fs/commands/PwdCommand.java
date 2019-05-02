package com.salesforce.tests.fs.commands;

import com.salesforce.tests.fs.contents.Directory;

public final class PwdCommand implements Command {
    public static final String CMD = "pwd";
    private final Directory current;

    public PwdCommand(Directory current) {
        this.current = current;
    }

    @Override
    public void run() {
        StringBuilder path = new StringBuilder();
        Directory dir = current;
        while(dir!=null){
            path.insert(0, dir.getName());
            path.insert(0,"/");
            dir = dir.getParent();
        }
        System.out.println(path.toString());
    }
}
