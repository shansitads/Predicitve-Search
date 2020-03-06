import java.util.*;


interface TestFunction {
    public int applyFunction(int args);
}

class main {
    //static variables
    private static InertArray array;

    //constants
    private static final TestFunction test = args -> (int)Math.pow(args+1,2);
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        startTest();
    }

    private static void startTest() {
        takeInputAndInitialize();
        array.sort();
        System.out.print(""+array+"\nEnter number to search :-  ");
        int value  = sc.nextInt();
        int index = array.search(value);
        System.out.println(index +"is the index of "+value);
    }

    private static void takeInputAndInitialize() {
        System.out.println("Entering 10 numbers as per function \n");
        int[] temp = new int[100];//############################################# CHANGE THE LENGTH HERE
        for(int i=0;i<temp.length;i++){
            temp[i] = test.applyFunction(i);
        }
        array = new InertArray(temp);
    }
}


class InertArray {
    int[] baseArray;

    InertArray(int... args) {
        baseArray = args;
    }

    public void sort() {
        Arrays.parallelSort(baseArray);
    }

    public int search(int value) {
        int length = baseArray.length;

        int highIndex = length-1,lowIndex = 0;
        int max=baseArray[highIndex],min=baseArray[0];
        int loc,iteration = 1,slope,y_intercept;

        boolean done=false;
        loc=(Integer)(((value-min)*length)/(max-min));
        
        while(!done){
            max=baseArray[highIndex];
            min=baseArray[0];
            if(highIndex-lowIndex == 0) { 
                return loc;
            }
            slope = (max - min)/(highIndex- lowIndex);
            y_intercept = min - slope*lowIndex;

            loc = (value - y_intercept)/slope;
            
            System.out.println("I am at index :- "+loc+" and iteration :- "+iteration);
            ++iteration;

            try{
                Thread.sleep(500);
            } catch(Exception e) {}
            
            if(baseArray[loc]==value)
                return loc;
            else if(baseArray[loc]<value){
                lowIndex = loc+1;
                continue;
            }
            else
                highIndex = loc-1;
        }
        return 0;
    }

    public String toString() {
        String str = "";

        for(int elem:baseArray) {
            System.out.print(","+elem);;
        }

        return str.substring(0);
    }
}
