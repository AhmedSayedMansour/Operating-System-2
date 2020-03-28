package project;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    String cmd;
    String path, fileName, folderName;
    int size;
    java.io.File virtualFile = new File("F:\\FCAI\\OS2\\Assignments\\File System Allocation\\src\\Virtual file system.txt");
    ArrayList<String> commands = new ArrayList<String>(List.of("CreateFile", "CreateFolder", "DeleteFile", "DeleteFolder", "DisplayDiskStatus",
            "DisplayDiskStructure"));

    boolean Parser(String command) {
        String [] spaces = command.split(" ");
        if (spaces[0].matches("CreateFile") && spaces.length == 3){
            String [] paths= spaces[1].split("/");
            size = Integer.parseInt(spaces[2]);

        }
        else if(spaces[0].matches("DisplayDiskStatus") && spaces.length == 1){
            return true;
        }
        else if(spaces[0].matches("DisplayDiskStructure") && spaces.length == 1){
            return true;
        }

        return false;
    }
}
