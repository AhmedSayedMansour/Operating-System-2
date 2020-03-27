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
        for (int i = 0; i < command.length(); i++) {
            // Take the cmd
            while (true) {
                cmd += command.charAt(i);
                i += 1;
                if (command.charAt(i) == ' ') break;
            }
            // Check if the cmd is valid
            if (!commands.contains(cmd)) {
                System.out.println(cmd + " is not recognized as an internal or external command");
                return false;
            }
        }
        return true;
    }
}
