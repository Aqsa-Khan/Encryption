
/**
 * This class sets up the methods that the LFSR will use later. It contains a xor method and a method to turn binary into base 10 integers
 * 
 * @Aqsa Khan 
 * @4/21/2017
 */
public class Helper
{
    public static char xor(char a, char b){
        //implements exclusive or 
        //if input is not either '1' or '0', prints an error message
        
        if((a == '1' || a == '0') && (b == '1' || b == '0')){
            if(a == '0' && b == '0'){
                return '0';
            }
            if(a == '1' && b == '0'){
                return '1';
            }
            if(a == '0' && b == '1'){
              return '1';  
            }
            if(a == '1' && b == '1'){
                return '0';
            }
        }
        else{
            return '*';
        }
        return '2';
    }
    
    public static int binaryToDec(String s){
        //takes a string representing a number in binary and ouputs the corresponding base 10 integer
        double result = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0' || s.charAt(i) == '1'){
                result = (result + (s.charAt(i)-'0' )* Math.pow(2, s.length()-i-1));
            }
        }
        return (int) result;
    }
   
    public static void main(String[] args){
        //tests the xor method
        char x = xor('1','0');
        System.out.println("XOR of 1 and 0. Expected output 1. Actual output " + x);
        char y = xor('3','6');
        System.out.println("XOR of 3 and 6. Expected output *. Actual output " + y);
        
        //tests the binaryToDec method
        int a = binaryToDec("11101"); //should be 29
        System.out.println(a);
        int b = binaryToDec("10010"); //should be 18
        System.out.println(b);
        int c = binaryToDec("10110"); //should be 22
        System.out.println(c);
    }
}
