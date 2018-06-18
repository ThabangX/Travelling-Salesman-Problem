/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class NaiveSolution   {
    	//try
        { 	
            
        FileReader in =null;
        
        try {
         in = new FileReader("test.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NaiveSolution.class.getName()).log(Level.SEVERE, null, ex);
        }
            Scanner input = new Scanner( in );
            int Map[] = null;
            int nodes=0;
            int trip[];
            int tripcost;
            List<String> nodeArray= new ArrayList<>();
            List<Integer> costArray = new ArrayList<>();
            final int infinity = 1000;
            int numbernodes=0;

            // Read the edges and insert
            String fileline;
            while( input.hasNextLine( ) )
            {
                fileline = input.nextLine( );
                StringTokenizer token = new StringTokenizer( fileline );

                try
                {
                   if( token.countTokens( ) != 3 )
                   {
                        System.err.println( "Skipping ill-formatted line " + fileline );
                        continue;
                   }
                    String source  = token.nextToken( );
                    String dest    = token.nextToken( );
                    int    cost    = Integer.parseInt( token.nextToken( ) );
                    numbernodes=numbernodes+1;
                    nodeArray.add(source);
                    costArray.add(cost);
                }
                catch( NumberFormatException e )
                  { System.err.println( "Skipping ill-formatted line " + fileline ); }
             }
             nodes = (numbernodes)/3;
            for (int i=0; i<nodes;i++ )
            {
                
                for(int j=0;j<nodes;j++){
                    if (i!=j){
                        //Map[i][j]=costArray.get(i);
                    }
                }
            }
        
            
}


}
