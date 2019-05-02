package com.salesforce.tests.fs.commands;

public final class MkdirCommand implements Command {
    public static final String CMD = "mkdir";
    private final String dirName;

    public MkdirCommand(String dirName) {
        this.dirName = dirName;
    }

    public String getDirName() {
        return dirName;
    }

    @Override
    public void run() {
        // System.out.println("mkdir executed");
    }
}
