package com.salesforce.tests.fs.commands;

import com.salesforce.tests.fs.contents.Directory;

import java.util.concurrent.atomic.AtomicBoolean;

public final class ListCommand implements Command {
    public static final String CMD = "ls";
    private Directory currentDir;
    private final AtomicBoolean recursive = new AtomicBoolean(false); // Default

    public ListCommand(Directory currentDir, boolean recursive) {
        this.currentDir = currentDir;
        this.recursive.set(recursive);
    }

    @Override
    public void run() {
        if(!recursive.get()){
            System.out.println("...");
            if(currentDir.getFiles()!=null) {
                currentDir.getFiles().forEach(System.out::println);
            }
        }
    }
}
