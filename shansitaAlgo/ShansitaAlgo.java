import java.util.*;


interface TestFunction {
    public int applyFunction(int args);
}

class main {
    //static variables
    private static ShansitaArray array;

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
        int[] temp = new int[10];
        for(int i=0;i<10;i++){
            temp[i] = test.applyFunction(i);
        }
        array = new ShansitaArray(temp);
    }
}


class ShansitaArray {
    int[] baseArray;

    ShansitaArray(int... args) {
        baseArray = args;
    }

    public void sort() {
        Arrays.parallelSort(baseArray);
    }

    public int search(int value) {
        int length = baseArray.length;

        int max=baseArray[length-1],min=baseArray[0];
        int loc,iteration = 1;
        boolean b=false;
        loc=(Integer)(((value-min)*length)/(max-min));
        
        while(max>min){

            loc=(int)(((value-min)*length)/(max-min));
            
            System.out.println("I am at index :- "+loc+" and iteration :- "+iteration);
            ++iteration;

            try{
                Thread.sleep(500);
            } catch(Exception e) {}
            
            if(baseArray[loc]==value)
                return loc;
            else if(baseArray[loc]<value){
                min=loc+1;
                continue;
            }
            else
                max=loc-1;
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
