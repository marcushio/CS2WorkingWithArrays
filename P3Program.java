/**
 * @author Marcus Trujillo
 * Assignment#3
 * Brief Description of class P3Program here.
 * 
 * CS2050-003
 * @version 
 */

import java.util.*; 
import java.nio.file.*; 
import java.io.*; 
import java.text.*; 
import java.util.concurrent.TimeUnit; 

public class P3Program
{
    Random randomGenerator; 
    DecimalFormat formatter = new DecimalFormat("000.000000000"); 
    String fileName; 
    String outputString; 
    public static final int COLLECTION_SIZE = 100000; 
    public static final int RANDOM_MAX = 10000000; 
    public static final String LS = System.lineSeparator(); 
    static int trials; 
    
    ArrayList<Float> floatList; 
    ArrayList<Integer> intList; 
    int intArray[]; 
    float floatArray[]; 
    
    double startCPUTime; 
    double stopCPUTime;
    double startWallClockTime; 
    double stopWallClockTime;
    
    
    /**
     * Instantiate all the data structures we'll be testing.
     */
    public P3Program(){
        intArray = new int[COLLECTION_SIZE]; 
        floatArray = new float[COLLECTION_SIZE]; 
        floatList = new ArrayList(COLLECTION_SIZE); 
        intList = new ArrayList(COLLECTION_SIZE); 
        randomGenerator = new Random(); 
        fileName = "P3Output.txt"; 
        trials = 0; 
    }
    
    
    /**
     * Fills both the ArrayList and the array with values.  
     */
    private void fill(){
        System.out.println("++++++++FILL+++++++"); 
        startWallClockTime = System.currentTimeMillis(); 
        startCPUTime = System.nanoTime(); 
        for(int i = 0; i < intArray.length; i++){
            intArray[i] = randomGenerator.nextInt(RANDOM_MAX); 
        }
        stopWallClockTime = System.currentTimeMillis(); 
        stopCPUTime = System.nanoTime();
        double intArrayWallTime = stopWallClockTime - startWallClockTime; 
        double intArrayCPUTime = stopCPUTime - startCPUTime; 
        
        startWallClockTime = System.currentTimeMillis(); 
        startCPUTime = System.nanoTime(); 
        for(int i = 0; i < floatArray.length; i++){
            floatArray[i] = randomGenerator.nextFloat(); 
        }
        stopWallClockTime = System.currentTimeMillis();  
        stopCPUTime = System.nanoTime(); 
        double floatArrayWallTime = stopWallClockTime - startWallClockTime;
        double floatArrayCPUTime = stopCPUTime - startCPUTime; 
        
        startWallClockTime = System.currentTimeMillis(); 
        startCPUTime = System.nanoTime(); 
        for(int i = 0; i < COLLECTION_SIZE; i++){
            intList.add(i, randomGenerator.nextInt(RANDOM_MAX)); 
        }
        stopWallClockTime = System.currentTimeMillis();  
        stopCPUTime = System.nanoTime(); 
        double intListWallTime = stopWallClockTime - startWallClockTime;
        double intListCPUTime = stopCPUTime - startCPUTime; 
        
        startWallClockTime = System.currentTimeMillis(); 
        startCPUTime = System.nanoTime(); 
        for(int i = 0; i < COLLECTION_SIZE; i++){
            floatList.add(i, randomGenerator.nextFloat()); 
        }
        stopWallClockTime = System.currentTimeMillis(); 
        stopCPUTime = System.nanoTime();    
        double floatListWallTime = stopWallClockTime - startWallClockTime;
        double floatListCPUTime = stopCPUTime - startCPUTime;
        
        outputString =  "Run #  " + trials + LS + "Fill the list: Number of Elements: " + COLLECTION_SIZE + 
                        LS  + "   int array - wall clock          : " + formatter.format(intArrayWallTime/1000) + 
                        LS  + "   int ArrayList - wall clock      : " + formatter.format(intListWallTime/1000) + 
                        LS  + LS +  "   int array - CPU time            : " + formatter.format(intArrayCPUTime/1000000000) + 
                        LS  + "   int ArrayList - CPU time        : " + formatter.format(intListCPUTime/1000000000) + 
                        LS  + LS + "   float array - wall clock        : " + formatter.format(floatArrayWallTime/1000) + 
                        LS  + "   float ArrayList - wall clock    : " + formatter.format(floatListWallTime/1000) + 
                        LS  + LS + "   float array - CPU time          : " + formatter.format(floatArrayCPUTime/1000000000) + 
                        LS  + "   float ArrayList - CPU time      : " + formatter.format(floatListCPUTime/1000000000) + LS  + LS; 
        System.out.println(outputString); 
        writeReport(outputString); 
    }
    
    
    /**
     * Increments every element in each data structure by 1. 
     */
    private void increment(){
        System.out.println("++++++INCREMENT+++++++"); 
        startWallClockTime = System.currentTimeMillis(); 
        startCPUTime = System.nanoTime(); 
        for(int i = 0; i < intArray.length; i++){
            intArray[i]++;  
        }
        stopWallClockTime = System.currentTimeMillis();
        stopCPUTime = System.nanoTime();  
        double intArrayWallTime = stopWallClockTime - startWallClockTime;
        double intArrayCPUTime = stopCPUTime - startCPUTime; 
        
        
        startWallClockTime = System.currentTimeMillis(); 
        startCPUTime = System.nanoTime(); 
        for(int i = 0; i < floatArray.length; i++){
            floatArray[i]++; 
        }
        stopWallClockTime =  System.currentTimeMillis(); 
        stopCPUTime = System.nanoTime();
        double floatArrayWallTime = stopWallClockTime - startWallClockTime;
        double floatArrayCPUTime = stopCPUTime - startCPUTime; 
        
        startWallClockTime = System.currentTimeMillis(); 
        startCPUTime = System.nanoTime(); 
        for(int i = 0; i < COLLECTION_SIZE; i++){
            int incremented = intList.get(i) + 1; 
            intList.set(i, incremented); 
        }
        stopWallClockTime = System.currentTimeMillis();
        stopCPUTime = System.nanoTime(); 
        double intListWallTime = stopWallClockTime - startWallClockTime;
        double intListCPUTime = stopCPUTime - startCPUTime; 
        
        startWallClockTime = System.currentTimeMillis(); 
        startCPUTime = System.nanoTime(); 
        for(int i = 0; i < COLLECTION_SIZE; i++){
            float incremented = floatList.get(i) + 1; 
            floatList.set(i, incremented); 
        }
        stopWallClockTime = System.currentTimeMillis(); 
        stopCPUTime = System.nanoTime();  
        double floatListWallTime = stopWallClockTime - startWallClockTime;
        double floatListCPUTime = stopCPUTime - startCPUTime; 
      
        outputString =  "Increment the elements in the list: " + 
                        LS  + "   int array - wall clock          : " + formatter.format(intArrayWallTime/1000) + 
                        LS  + "   int ArrayList - wall clock      : " + formatter.format(intListWallTime/1000) + 
                        LS  + LS +  "   int array - CPU time            : " + formatter.format(intArrayCPUTime/1000000000) + 
                        LS  + "   int ArrayList - CPU time        : " + formatter.format(intListCPUTime/1000000000) + 
                        LS  + LS + "   float array - wall clock        : " + formatter.format(floatArrayWallTime/1000) + 
                        LS  + "   float ArrayList - wall clock    : " + formatter.format(floatListWallTime/1000) + 
                        LS  + LS + "   float array - CPU time          : " + formatter.format(floatArrayCPUTime/1000000000) + 
                        LS  + "   float ArrayList - CPU time      : " + formatter.format(floatListCPUTime/1000000000) + LS  + LS; 
        System.out.println(outputString); 
        writeReport(outputString); 
        intList.clear(); 
        floatList.clear(); 
    }
    
   
    /**
     * Writes the report with the data from the trial 
     */
    private void writeReport(String reportString){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fileName), true)); 
            writer.write(reportString); 
            writer.close(); 
        }catch(Exception ex){
            System.out.println("try a different file name"); 
        }
    }
    
    
    /**
     * The main method that calls all the methods from the class. 
     */
    public static void main(String args[]){
        P3Program arrayTest = new P3Program(); 
        while(trials <= 3){
            trials++; 
            arrayTest.fill(); 
            arrayTest.increment(); 
        }
    }
    
}
