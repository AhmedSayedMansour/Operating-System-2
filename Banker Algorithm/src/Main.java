public class Main { 
    public static void main(String[] args) {
        
    int n, m; 
    n = 5; 
    m = 3; 
    int alloc[][] = { { 0, 1, 0 }, 
                        { 2, 0, 0 }, 
                        { 3, 0, 2 },  
                        { 2, 1, 1 },  
                        { 0, 0, 2 } }; 
  
    int max[][] = { { 7, 5, 3 }, 
                    { 3, 2, 2 }, 
                    { 9, 0, 2 }, 
                    { 2, 2, 2 }, 
                    { 4, 3, 3 } }; 
  
    int avail[] = { 3, 3, 2 }; 
        bankerAlgorithm a= new bankerAlgorithm(5, 3,avail,alloc,max);
        a.isSave();
        int newAlloc[]={1,1,1};
        a.RQ(0, newAlloc);
        
    }
    
}
