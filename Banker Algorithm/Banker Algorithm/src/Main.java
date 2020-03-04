public class Main { 
    public static void main(String[] args) {
        
         int n, m; 
    n = 5; // Number of processes 
    m = 3; // Number of resources 
    int alloc[][] = { { 0, 1, 0 }, // P0 // Allocation Matrix 
                        { 2, 0, 0 }, // P1 
                        { 3, 0, 2 }, // P2 
                        { 2, 1, 1 }, // P3 
                        { 0, 0, 2 } }; // P4 
  
    int max[][] = { { 7, 5, 3 }, // P0 // MAX Matrix 
                    { 3, 2, 2 }, // P1 
                    { 9, 0, 2 }, // P2 
                    { 2, 2, 2 }, // P3 
                    { 4, 3, 3 } }; // P4 
  
    int avail[] = { 3, 3, 2 }; // Available Resources 
        bankerAlgorithm a= new bankerAlgorithm(5, 3,avail,alloc,max);
        a.isSave();
        int newAlloc[]={1,1,1};
        a.RQ(0, newAlloc);
        
    }
    
}
