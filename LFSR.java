
/**
 * This takes a seed and generates a new number that is stored in the LFSR by shifting all the bites by 1 to the left.
 * 
 * @Aqsa 
 * @4/21/2017
 */
public class LFSR
{
    // instance variables - replace the example below with your own
    private String lfsr;
    private int tapBit;
    
    /**
     * Constructor for objects of class LFSR
     */
    public LFSR(String seed, int tap)
    {
        // initialise instance variables
      lfsr = seed;
      tapBit = tap;
    }
    
    public static void main(String[] args){
        // tests that the constructor and toString method work
        LFSR lfsr_1 = new LFSR("01101000010",2);
        System.out.println(lfsr_1);
        
        //tests the step method
        for(int i = 0; i<10; i++){
            int bit = lfsr_1.step();
            System.out.println(lfsr_1+" "+bit);
        }
        
        System.out.println("_____________");
        
        //tests the generate method
        for(int i = 0; i < 10; i++){
            int r = lfsr_1.generate(5);
            System.out.println(lfsr_1+ " " + r);
        }
    }
    
    public String toString(){
        return lfsr;
    }
    
   public int step(){
       //the new bit that will be shifted in
       char a = Helper.xor(lfsr.charAt(0), lfsr.charAt(tapBit));
       //simulates one shift of the LFSR
       String s = lfsr.substring(1,lfsr.length()) + a;
       lfsr = s;
       return Character.getNumericValue(a);
    }
    
   public int generate(int k){
       //initializing variable t 
       int t = 0;
       //makes the seed get shifted as many times as indicated by k
       for(int i = 0; i<k; i++){
          step(); 
          //sets t to the base 10 integer that represents the last k bits
          t = Helper.binaryToDec(lfsr.substring(lfsr.length()-k,lfsr.length() - 1));
       }
       return t;
   }
}
