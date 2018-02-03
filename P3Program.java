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
    String fileName; 
    String outputString; 
    public static final int COLLECTION_SIZE = 100000; 
    public static final int RANDOM_MAX = 10000000; 
    int trials; 
    
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
        double intArrayCPUTime = startCPUTime - stopCPUTime; 
        System.out.println("int Array WallClock time: " + (stopWallClockTime - startWallClockTime)/1000); 
        System.out.println("CPU Time: " + (stopCPUTime - startCPUTime)/1000000000); 
        
        startWallClockTime = System.currentTimeMillis(); 
        startCPUTime = System.nanoTime(); 
        for(int i = 0; i < floatArray.length; i++){
            floatArray[i] = randomGenerator.nextFloat(); 
        }
        stopWallClockTime = System.currentTimeMillis();  
        stopCPUTime = System.nanoTime(); 
        double floatArrayWallTime = stopWallClockTime - startWallClockTime;
        double floatArrayCPUTime = startCPUTime - stopCPUTime; 
        System.out.println("float Array WallClock time: " + (stopWallClockTime - startWallClockTime)/1000);  
        System.out.println("CPU Time: " + (stopCPUTime - startCPUTime)/1000000000);
        
        startWallClockTime = System.currentTimeMillis(); 
        startCPUTime = System.nanoTime(); 
                for(int i = 0; i < intList.size(); i++){
            intList.add(randomGenerator.nextInt(RANDOM_MAX));
        }
        stopWallClockTime = System.currentTimeMillis();  
        stopCPUTime = System.nanoTime(); 
        double intListWallTime = stopWallClockTime - startWallClockTime;
        double intListCPUTime = startCPUTime - stopCPUTime; 
        System.out.println(" int ArraylistWallClock time: " + (stopWallClockTime - startWallClockTime)/1000); 
        System.out.println("CPU Time: " + (stopCPUTime - startCPUTime)/1000000000);
        
        startWallClockTime = System.currentTimeMillis(); 
        startCPUTime = System.nanoTime(); 
        for(int i = 0; i < floatList.size(); i++){
            floatList.add(randomGenerator.nextFloat()); 
        }
        stopWallClockTime = System.currentTimeMillis(); 
        stopCPUTime = System.nanoTime();    
        double floatListWallTime = stopWallClockTime - startWallClockTime;
        double floatListCPUTime = startCPUTime - stopCPUTime; 
        System.out.println("float Arraylist WallClock time: " + (stopWallClockTime - startWallClockTime)/1000);  
        System.out.println("CPU Time: " + (stopCPUTime - startCPUTime)/1000000000);
        /* let's make the stupid ass string
        outputString = "Run # - " + trials + "\n Fill the list: Number of elements: " + COLLECTION_SIZE; 
        outputString = outputString + "int array - wall clock: " + intArrayWallTime + "\n int ArrayList - wall clock : " + intListWallTime + 
                        "\n int array - CPU time" + intArrayCPUTime + 
                        "\n int ArrayList - CPU time" + intlistCPUTime + 
                        "\n \n float array - wall clock" + floatArrayWallTime + 
                        "\n float ArrayList - wall clock" + 
                        "\n \n " + 
                        */
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
        System.out.println("int Array WallClock time: " + (stopWallClockTime - startWallClockTime)/1000); 
        System.out.println("CPU Time: " + (stopCPUTime - startCPUTime)/1000000000); 
        
        startWallClockTime = System.currentTimeMillis(); 
        startCPUTime = System.nanoTime(); 
        for(int i = 0; i < floatArray.length; i++){
            floatArray[i]++; 
        }
        stopWallClockTime =  System.currentTimeMillis(); 
        stopCPUTime = System.nanoTime();
        System.out.println("float Array WallClock time: " + (stopWallClockTime - startWallClockTime)/1000); 
        System.out.println("CPU Time: " + (stopCPUTime - startCPUTime)/1000000000);
        
        startWallClockTime = System.currentTimeMillis(); 
        startCPUTime = System.nanoTime(); 
        for(int i = 0; i < intList.size(); i++){
            int incremented = intList.get(i) + 1; 
            intList.set(i, incremented); 
        }
        stopWallClockTime = System.currentTimeMillis();
        stopCPUTime = System.nanoTime(); 
        System.out.println(" int ArraylistWallClock time: " + (stopWallClockTime - startWallClockTime)/1000); 
        System.out.println("CPU Time: " + (stopCPUTime - startCPUTime)/1000000000);
        
        startWallClockTime = System.currentTimeMillis(); 
        startCPUTime = System.nanoTime(); 
        for(int i = 0; i < floatList.size(); i++){
            float incremented = floatList.get(i) + 1; 
            floatList.set(i, incremented); 
        }
        stopWallClockTime = System.currentTimeMillis(); 
        stopCPUTime = System.nanoTime();   
        System.out.println("float Arraylist WallClock time: " + (stopWallClockTime - startWallClockTime)/1000); 
        System.out.println("CPU Time: " + (stopCPUTime - startCPUTime)/1000000000);
    }
    
   
    /**
     * Writes the report with the data from the trial 
     */
    private void writeReport(String reportString){
        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName),StandardOpenOption.APPEND)){
            writer.write(reportString); 
        }catch(Exception ex){
            System.out.println("try a different file name"); 
        }
    }
    
    
    /**
     * The main method that calls all the methods from the class. 
     */
    public static void main(String args[]){
        P3Program arrayTest = new P3Program(); 
        arrayTest.fill(); 
        arrayTest.increment(); 
    }
    
}
