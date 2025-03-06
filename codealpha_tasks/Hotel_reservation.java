package codealpha_tasks;
import java.util.Scanner;


public class Hotel_reservation{
    static boolean[] rooms = new boolean[5];
    static String[] bookings = new String[5];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\n Hotel Reservation System");
            System.out.println("1. Search available rooms");
            System.out.println("2. Make booking");
            System.out.println("3. View Booking");
            System.out.println("4. Exit");
            System.out.println("Choose an opion: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    search_rooms();
                    break;
                case 2:
                    bookings();
                    break;
                case 3:
                    viewBooking();
                    break;
                case 4:
                    System.out.println("Thankyou for using the system");
                    return;
                default:
                System.out.println("Invalid choice ! Please try again..");
                    break;
            }
        }    
    }
            static void search_rooms(){
                System.out.println("Available rooms: ");
                for(int i=0;i<rooms.length;i++){
                if(!rooms[i]){
                    System.out.println("Rooms "+ (i+1)+" is available.");
                }
            }
        }
            static void bookings() {
                Scanner sc=new Scanner(System.in);
                System.out.print("\nEnter your name: ");
                String name = sc.nextLine();
                System.out.print("Enter room number (1-5): ");
                int roomNumber = sc.nextInt();
                if (roomNumber < 1 || roomNumber > 5 || rooms[roomNumber - 1]) {
                    System.out.println("Room not available or invalid choice.");
                } else {
                        rooms[roomNumber-1]= true;
                        bookings[roomNumber-1]= name;
                         System.out.println("Reservation successful!");
                        }
                    }
                
                    static void viewBooking() {
                        System.out.println("\nBooking Details:");
                        for (int i=0; i<bookings.length; i++) {
                            if (rooms[i]) {
                                System.out.println("Room "+(i + 1)+" - "+bookings[i]);
                            }
                        }
                    }
            }
