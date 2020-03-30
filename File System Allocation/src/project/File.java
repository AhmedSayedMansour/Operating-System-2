package project;

import java.io.Serializable;

public class File implements Serializable {
    public String name;
    public String filePath;
    public Block[] allocatedBlocks;

    public File() {
    }

    public File(String name, String filePath, Block[] allocatedBlocks) {
        this.name = name;
        this.filePath = filePath;
        this.allocatedBlocks = allocatedBlocks;
    }

    public Block[] getAllocatedBlocks() {
        return allocatedBlocks;
    }
}
