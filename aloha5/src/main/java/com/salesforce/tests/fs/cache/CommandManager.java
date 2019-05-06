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
import com.salesforce.tests.fs.contents.Directory.DirectoryBuilder;

public class CommandManager {
    private Directory current;

    public Directory getCurrentDirectory(){
        return current;
    }

    public CommandManager() {
        current = new DirectoryBuilder("home", current).withParent(null).build();
    }

    public void execute(String input) {
        String[] parsed = input.split(" ");
        String command = parsed[0];
        Command cmd;
        switch (command){
            case ListCommand.CMD:
                cmd = new ListCommand(current,false);
                cmd.run(this);
                break;
            case PwdCommand.CMD:
                cmd = new PwdCommand(current);
                cmd.run(this);
                break;
            case TouchCommand.CMD:
                cmd = new TouchCommand(parsed[1], current);
                cmd.run(this);
                break;
            case MkdirCommand.CMD:
                cmd = new MkdirCommand(parsed[1], current);
                cmd.run(this);
                break;
            case CdCommand.CMD:
                cmd = new CdCommand(parsed[1], current);
                cmd.run(this);
                break;
            case QuitCommand.CMD:
                cmd = new QuitCommand();
                cmd.run(this);
            default:
                System.out.println("Unrecognized command");
        }
    }

	public void setCurrentDirectory(Directory dir) {
        this.current = dir;
	}
}
