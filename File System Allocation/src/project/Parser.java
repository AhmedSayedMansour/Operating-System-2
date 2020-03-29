package project;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    String cmd;
    String path, fileName, folderName;
    int size;
    boolean checkCreate = false;
    ArrayList<String> commands = new ArrayList<String>(List.of("CreateFile", "CreateFolder", "DeleteFile",
            "DeleteFolder", "DisplayDiskStatus", "DisplayDiskStructure"));

    public boolean parse(String command) {
        String [] spaces = command.split(" ");
        if(commands.contains(spaces[0]))
        {
            // Global for all
            cmd = spaces[0];
            if (spaces[0].matches("CreateFile") && spaces.length == 3){
                String [] paths= spaces[1].split("/");
                if(paths[paths.length-1].contains("."))
                {
                    fileName = paths[paths.length-1];
                    folderName = paths[paths.length-2];
                }
                else {
                    System.out.println("wrong extinction");
                    return false;
                }
                // To check if the index is a valid integer
                try {
                    size = Integer.parseInt(spaces[2]);
                }
                catch (Exception e)
                {
                    return false;
                }
                // Check cmd to take the path if it not exist to create it
                checkCreate = true;
                // take the path to check it , and if it not exist create it
                for(int i=0 ; i<paths.length-1 ; i++) path = paths[i] + " ";
                return true;
            }
            else if(spaces[0].equals("DeleteFile") && spaces.length == 2)
            {
                String [] paths= spaces[1].split("/");
                if(paths[paths.length-1].contains("."))
                {
                    fileName = paths[paths.length-1];
                    folderName = paths[paths.length-2];
                }
                else {
                    System.out.println("wrong extinction");
                    return false;
                }
                for(int i=0 ; i<paths.length-1 ; i++) path = paths[i] + " ";
                return  true;
            }
            else if((spaces[0].matches("DisplayDiskStatus")||spaces[0].matches("DisplayDiskStructure") && spaces.length == 1)
                    && spaces.length == 1){
                return true;
            }
            else if((spaces[0].matches("CreateFolder")||spaces[0].matches("DeleteFolder") && spaces.length == 2))
            {
                String [] paths= spaces[1].split("/");
                if(spaces.length == 2)
                {
                    for(int i=0 ; i<paths.length-1 ; i++) path = paths[i] + " ";
                    folderName = paths[path.length()-1];
                    return true;
                }
                else
                    return false;
            }
        }
        return false;
    }
}
