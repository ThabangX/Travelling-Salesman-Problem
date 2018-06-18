/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Billsteud
 */
 import java.util.*;
//import java.text.*;
public class TravellingSalesMan {
   
//class TSP
//{
//int distanceMap[][],n,tour[],finalCost;
public final int infinity=1000;    //infinity bound 
int Map[][];     //matrix of distances
int nodes;          //number of nodes
int trip[];      //salesman tour
int tripcost;     //tour cost

//public final int INF=1000;


public TravellingSalesMan()
{     
      Scanner input=new Scanner(System.in);
      System.out.println("Enter the number of nodes: ");
      nodes=input.nextInt();
      Map=new int[nodes][nodes];  //inintialise matrix
      trip=new int[nodes-1];
      //define list of characters
      
      char[] alphabets = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
      
      //iterate through the matrix using a fixed char to all the nodes and collect the distances thereof
      
      for(int i=0;i<nodes;i++){
            for(int j=0;j<nodes;j++)
                   {
                      if(i!=j)
                            {
                            System.out.print("Enter the distance between "+ alphabets[i]+" to "+alphabets[j]+" :");
                            Map[i][j]=input.nextInt();
                            }
                   }
                            }
             System.out.println();
             //always take the initial node to be A
             System.out.println("The initial node is A==1,B==2,ETC"); compute();
             
                             }
//calculate the cost of the trip
public int costCalculator(int node,int input[],int size)
{
    if(size==0)
    return Map[node][0]; //node itself else: move on 
    // int min=INF,minindex=0;
     int minimum= infinity;
     int minimumIndex=0;
     int next[]=new int[nodes-1];  //next is passed on the next call of cost 
        for(int iterator=0;iterator<size;iterator++)
            {
                int k=0;//initialise new set
                      for(int j=0;j<size;j++)
                   {
                  if(input[iterator]!=input[j])
                next[k++]=input[j];
                   }
int temporary=costCalculator(input[iterator],next,size-1);
if((Map[node][input[iterator]]+temporary) < minimum)
{
minimum=Map[node][input[iterator]]+temporary;
minimumIndex=input[iterator];
}
}
return minimum;
}


//find the minimum index that yieds the shortest path

public int Minimum(int currentNode,int input[],int setSize)
{
if(setSize==0)
return Map[currentNode][0];
int minimum=infinity, minimumIndex=0;
int setToBePassedOnToNextCallOfCOST[]=new int[nodes-1];
for(int i=0;i<setSize;i++)//considers each node of inputSet
{
int k=0;
for(int j=0;j<setSize;j++)
{
if(input[i]!=input[j])
setToBePassedOnToNextCallOfCOST[k++]=input[j];
}
int temp=costCalculator(input[i],setToBePassedOnToNextCallOfCOST,setSize-1);
if((Map[currentNode][input[i]]+temp) < minimum)
{
minimum=Map[currentNode][input[i]]+temp; minimumIndex=input[i];

}
}
return minimumIndex;
}

//call the methods that are needed to build the path and and calculate cost
public void compute()
{
      int def[]=new int[nodes-1];
      for(int i=1;i<nodes;i++)
          def[i-1]=i; tripcost=costCalculator(0,def,nodes-1);
          buildTrip();
}




public void buildTrip()
{
         int before[]=new int[nodes-1];int next[]=new int[nodes-2]; 
          
          for(int i=1;i<nodes;i++)
              
            before[i-1]=i;
          
           int setSize = nodes-1;
           trip[0]=Minimum(0,before,setSize);
           
           for(int i=1;i<nodes-1;i++)
           {      int k=0;
                  for(int j=0;j<setSize;j++)
                       {
                         if(trip[i-1]!=before[j])
                         next[k++]=before[j];
                        }
                        --setSize;
                  trip[i]=Minimum(trip[i-1],next,setSize);
                for(int j=0;j<setSize;j++)
                      before[j]=next[j];
           }
           printPath();
}



//ouput the shortet path
public void printPath()
{//char[] alphabets = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
       System.out.println();
       System.out.print("The path is 1->");
       for(int i=0;i<nodes-1;i++)
       {System.out.print((trip[i]+1)+"->");}
       
       System.out.print("1");System.out.println();
       System.out.println("The optimum cost is "+tripcost);
}
}
//}


    
//}



    class TravellingSalesManRunner
{
        //driver class
public static void main(String args[])
{  long startTime = System.currentTimeMillis();
TravellingSalesMan salesman =new TravellingSalesMan();
long endTime = System.currentTimeMillis();
System.out.println( (endTime)-(startTime)); // find the ruuning time including the time it tkes for taking in input
}
}
