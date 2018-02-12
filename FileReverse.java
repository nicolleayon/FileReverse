//-----------------------------------------------------------------------------
// Nicolle Ayon
// nayoncam
// Takes in file, & outputs tokens backwards in output file (on line by itself)
// FileReverse.java
// * Most code from FileTokens, except for section labeled "MY CODE" 
//   and stringReverse method
//-----------------------------------------------------------------------------
import java.io.*;
import java.util.Scanner;

class FileReverse{
   public static void main(String[] args) throws IOException{

      int lineNumber = 0;

      // check number of command line arguments is at least 2
      if(args.length < 2){
         System.out.println("Usage: java –jar FileReverse.jar <input file> <output file>");
         System.exit(1);
      }

      // open files
      Scanner in = new Scanner(new File(args[0]));
      PrintWriter out = new PrintWriter(new FileWriter(args[1]));

      // read lines from in, extract and print tokens from each line
      while( in.hasNextLine() ){
         lineNumber++;

         // trim leading and trailing spaces, then add one trailing space so 
         // split works on blank lines
         String line = in.nextLine().trim() + " "; 

         // split line around white space 
         String[] token = line.split("\\s+");  

         int n = token.length;

         //=====================================
         //************* MY CODE ***************

         for (int i = 0; i<n; i++){ //go through each token in token array
            String reversedToken = stringReverse(token[i]);
            token[i] = reversedToken;
         }
         //=====================================

         for(int i=0; i<n; i++){
            if (i == n-1 && !in.hasNextLine()) //if last token and there is no next line
                out.print(""+token[i]);  //IFF the last token, DON'T print new line (use print instead of println)
            else 
               out.println(""+token[i]); 
         }
        
      }

      // close files
      in.close();
      out.close();
   }

   public static String stringReverse (String s){
      String reverse = ""; 
      for (int j = s.length()-1; j >= 0; j--){ //go through each char in token
         reverse = reverse + s.charAt(j);
      }
      return reverse;
   }
}
