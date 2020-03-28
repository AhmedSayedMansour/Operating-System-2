package project;

import java.util.ArrayList;

public class Block {
    boolean allocated;
    private ArrayList<Block> subBlocks;

    public Block(boolean allocated, ArrayList<Block> subBlocks) {
        this.allocated = allocated;
        this.subBlocks = subBlocks;
    }
}
