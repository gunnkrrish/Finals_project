package Java_Projects;
import java.util.*;
class Student_grade_tracker{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int[] grades = new int[100];
        System.out.println("Enter grades(Use -1 to stop) : ");

        int i=0;
        while(true){
            int grade = sc.nextInt();
            if(grade == -1) break;
            grades[i++] = grade;
        }
        if(i == 0) {
            System.out.println("No grades entered.");
        } else {
            displayresult(grades, i);
        }
        sc.close();

    }
    public static void displayresult(int[] arr,int size){
        int highest = gethighest(arr,size);
        int lowest = getlowest(arr,size);
        double average = getaverage(arr,size);

        System.out.println("Highest is : "+highest);
        System.out.println("Lowest is : "+lowest);
        System.out.println("Average is : "+average);
    }

    public static int gethighest(int[] arr,int size){
        int high = arr[0];
        for(int i=1;i<size;i++){
            if(arr[i] > high){
                high = arr[i];
            }
        }
        return high;
    }
    public static int getlowest(int[] arr,int size){
        int low = arr[0];
        for(int i=1;i<size;i++){
            if(arr[i] < low){
                low = arr[i];
            }
        }
        return low;
    }
    public static double getaverage(int[] arr,int size){
        int sum =0;
        for(int i=0;i<size;i++){
            sum = sum+arr[i];
        }
        return sum / size;
    }
}