import java.util.*;

public class predictiveSearch {
    //static variables
    private static Array array;

    //constants
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        startTest();
    }

    private static void startTest() {
        takeInputAndInitialize();


        System.out.println("Enter values");
        for (int itr=0;itr<array.length();itr++) {
            array.baseArray[itr] = input("Enter a value, "+(array.length()-itr)+" elements are left\n> ");
        }

        array.sort();
        System.out.println("The array is "+array);
        
        int value = input("Enter the value you want to Search\n> ");

        int index = array.search(value);
        System.out.println(index +" is the index of "+value);
    }

    private static void takeInputAndInitialize() {
        int arrayLength = input("Enter the number of elements you want to test\n> ");
        int[] temp = new int[arrayLength];
        array = new Array(temp);
    }

    private static int input(String toBePrinted) {
        System.out.print(toBePrinted);
        return sc.nextInt();
    }
}


class Array {
    private static final float MARGIN = 0.5f;
    int[] baseArray;

    Array(int... args) {
        baseArray = args;
    }

    public void sort() {
        Arrays.parallelSort(baseArray);
    }

    public int search(int value) {
        int   length = baseArray.length;
        int   max=baseArray[length-1];
        int   min=baseArray[0];
        int   loc;

        
        boolean safe = doSafetyCheck();

        if (safe) {
           return applyPredictiveSearch(value);
        } else {
            return applyBinarySearch(value);
        }
    }

    public boolean doSafetyCheck () {
        //checking if predictive search is safe or not
        //In other words checking if the array is geometrically or linearly progressing

        int firstElem = baseArray[0];
        int secondElem = baseArray[1];

        int lastElem = baseArray[baseArray.length-1];
        int secondLastElem = baseArray[baseArray.length -2];

        int firstSlope = secondElem - firstElem;
        int secondSlope = lastElem - secondLastElem;
        int totalSlope = (lastElem - firstElem)/(baseArray.length-1);

        return (2*MARGIN >(Math.abs(firstSlope - secondSlope) + Math.abs(firstSlope - totalSlope))); 

    }

    protected int applyPredictiveSearch (int value) {
        System.out.println("using predictive search");

        int   length   = baseArray.length;
        int   max      = baseArray[length-1];
        int   min      = baseArray[0];
        int location;

        //boolean b=false; why ?
        //loc=(Integer)(((value-min)*length)/(max-min)); redundant
        
        boolean found = (max<min); //for the sake of verbosity
            
        while (!found) {
            location = (Integer)(((value-min)*length)/(max-min));
            
            if(baseArray[location]<value){
                min=baseArray[location+1];
                continue;
            } else if(baseArray[location]>value){
                max=baseArray[location-1];
                continue;
            } else {
                return location;
            }
        }

        return -1;
    }

    private int applyBinarySearch (int value) {
        System.out.println("Defaulting to binary search");
        return Arrays.binarySearch(baseArray,value);
    }

    public int length() {
        return baseArray.length;
    }

    public String toString() {
        String str = "[ "+baseArray[0];
        for(int i=1;i<baseArray.length;i++) {
            str += ","+baseArray[i];
        }
        str += " ]";

        return str;
    }
}