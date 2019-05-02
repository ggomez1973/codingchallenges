package com.salesforce.tests.fs.cache;

import com.salesforce.tests.fs.commands.CdCommand;
import com.salesforce.tests.fs.commands.Command;
import com.salesforce.tests.fs.commands.ListCommand;
import com.salesforce.tests.fs.commands.MkdirCommand;
import com.salesforce.tests.fs.commands.PwdCommand;
import com.salesforce.tests.fs.commands.QuitCommand;
import com.salesforce.tests.fs.commands.TouchCommand;
import com.salesforce.tests.fs.contents.Directory;
import com.salesforce.tests.fs.contents.File;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommandManager {
    private Directory current;

    public CommandManager() {
        current = new Directory("home", null, null,null);
    }

    public void execute(String input) {
        String[] parsed = input.split(" ");
        String command = parsed[0];
        Command cmd;
        switch (command){
            case ListCommand.CMD:
                cmd = new ListCommand(current,false);
                cmd.run();
                break;
            case PwdCommand.CMD:
                cmd = new PwdCommand(current);
                cmd.run();
                break;
            case TouchCommand.CMD:
                cmd = new TouchCommand(parsed[1], current);
                cmd.run();
                current.getFiles().add(new File(parsed[1]));
                break;
            case MkdirCommand.CMD:
                cmd = new MkdirCommand(parsed[1]);
                cmd.run();
                //current.getFiles().add(Directory.createDirectory(parsed[1], current, new ArrayList<>()));
                System.out.println(current);
                break;
            case CdCommand.CMD:
                cmd = new CdCommand(current, parsed[1]);
                if (parsed[1].equals("..")) {
                    current = (current.getParent() == null) ? current : current.getParent();
                } else {
                    cmd.run();
                    Set<File> contents = current.getFiles();
                    for (File content : contents) {
//                            if (content instanceof Directory) {
//                                Directory dir = (Directory) content;
//                                if (dir.getName().equals(parsed[1])) {
//                                    current = dir;
//                                }
//                            }
                    }

                }
                break;
            case QuitCommand.CMD:
                cmd = new QuitCommand();
                cmd.run();
            default:
                System.out.println("Unrecognized command");
        }
    }
}
