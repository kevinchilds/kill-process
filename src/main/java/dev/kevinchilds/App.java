package dev.kevinchilds;

import dev.kevinchilds.util.CommandLine;

public class App {
    public static void main( String[] args ) {

        //make sure port given
        if(args.length != 1) {
            System.out.println("no port provided");
            return;
        }

        //lsof -i :9000 | awk '{print $2}' | tail -n 1
        String port = args[0];
        StringBuilder command = new StringBuilder("lsof -i :");
        command.append(port);
        command.append(" | awk '{print $2}' | tail -n 1");

        String output = CommandLine.executeCommandPrompt(command.toString());
        System.out.println("all process killed on port " + port);

        //just return if process is running on port
        if(output.length() == 0) return;

        command = new StringBuilder("kill -9 ");
        command.append(output);

        output = CommandLine.executeCommandPrompt(command.toString());

        

    }
}
