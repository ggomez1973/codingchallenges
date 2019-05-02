package com.salesforce.tests.fs.commands;

import com.salesforce.tests.fs.contents.Directory;
import com.salesforce.tests.fs.contents.File;

import java.util.List;
import java.util.Set;

public class CdCommand implements Command{
    public static final String CMD = "cd";
    private String toDirectory;
    private Directory from;
    public CdCommand(Directory from, String toDirectory) {
        this.from = from;
        this.toDirectory = toDirectory;
    }

    @Override
    public void run() {
        if(!toDirectory.equals("...")) {
            boolean found = false;
            Set<File> contents = from.getFiles();
//            for (File content : contents) {
//                if (content instanceof Directory) {
//                    Directory dir = (Directory) content;
//                    if (dir.getName().equals(toDirectory)) {
//                        found = true;
//                    }
//                }
//            }
//            if (!found) {
//                throw new FsException("No such directory");
//            }
        }
    }
}
