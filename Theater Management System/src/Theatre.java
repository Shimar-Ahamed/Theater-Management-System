import java.io.*;
import java.util.*;

public class Theatre {
    static Scanner input = new Scanner(System.in);
    private static ArrayList<Ticket> ticket_List=new ArrayList<>();//creating an arraylist to store the ticket objects for each ticket

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the New Theatre");

        int[] row1 = new int[12];
        int[] row2 = new int[16];
        int[] row3 = new int[20];

        while (true) {

            System.out.println("-------------------------------------------------");
            System.out.println("please select an option");
            System.out.println("1) Buy a Ticket");
            System.out.println("2) Print seating area");
            System.out.println("3) Cancel ticket");
            System.out.println("4) List available seats");
            System.out.println("5) Save to file");
            System.out.println("6) Load from File");
            System.out.println("7) Print ticket information and total price");
            System.out.println("8) Sort tickets by price");
            System.out.println("0) Quit ");
            System.out.println("-------------------------------------------------");

            int option=-1;
            try {
                System.out.print("Enter option: ");
                option = Integer.parseInt(input.nextLine());
            }catch (NumberFormatException e){
                System.out.println("This not a option! please try again.");
                //System.out.print("Enter option: ");
            }

            switch (option) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    buy_ticket(row1, row2, row3);
                    break;
                case 2:
                    print_seating_area(row1, row2, row3);
                    break;
                case 3:
                    cancel_ticket(row1, row2, row3);
                    break;
                case 4:
                    show_available(row1, row2, row3);
                    break;
                case 5:
                    save(row1,row2,row3);
                    break;
                case 6:
                    load_file(row1,row2,row3);
                    break;
                case 7:
                    show_ticket_details();
                    break;
                case 8:
                    sort_tickets();
                    break;
                default:
                    System.out.println("Incorrect option");
            }
        }

    }

    public static void buy_ticket(int[] row1, int[] row2, int[] row3) {
        Person person=new Person();
        Ticket ticket=new Ticket();
        //getting person's details
        System.out.print("Enter Name : ");
        String name=input.next();
        System.out.println();
        System.out.print("Enter surname : ");
        String surname=input.next();
        System.out.println();
        System.out.print("Enter email : ");
        String email=input.next();
        System.out.println();

        //setting the person details through the setters of Person class
        person.setNames(name);
        person.setSurNames(surname);
        person.seteMails(email);

        ticket.setPerson(person);

        int row;//creating the row
        int seat;//creating the seat
        while (true) {

            try {

                System.out.print("input row number - 1/2/3 : ");
                row = Integer.parseInt(input.next());//getting the row

                if (row < 1 || row > 3) {
                    //checking the rows valid range
                    System.out.println("invalid row number");
                    continue;
                } else {
                    while (true) {
                        try{
                            System.out.print("input seat number : ");//getting the seat
                            seat = Integer.parseInt(input.next());


                            //checking the row range and seat range
                            if (row == 1) {
                                ticket.setPrices(500);//setting the price
                                if (seat < 0 || seat > 12) {
                                    System.out.println("incorrect seat number");
                                    continue;
                                } else if (row1[seat - 1] == 0) {
                                    row1[seat - 1] = 1;
                                    System.out.println("seat booked");
                                    break;
                                } else if (row1[seat - 1] == 1) {
                                    System.out.println("Seat already booked");
                                }
                            } else if (row == 2) {
                                ticket.setPrices(1000);
                                if (seat < 0 || seat > 16) {
                                    System.out.println("incorrect seat number");
                                } else if (row2[seat - 1] == 0) {
                                    row2[seat - 1] = 1;
                                    System.out.println("seat booked");
                                    break;
                                } else if (row2[seat - 1] == 1) {
                                    System.out.println("seat already booked");
                                }
                            } else if (row == 3) {
                                ticket.setPrices(1500);
                                if (seat < 0 || seat > 20) {
                                    System.out.println("incorrect seat number");
                                } else if (row3[seat - 1] == 0) {
                                    row3[seat - 1] = 1;
                                    System.out.println("seat booked");
                                    break;
                                } else if (row3[seat - 1] == 1) {
                                    System.out.println("Seat already booked");
                                }
                            }

                            }catch (NumberFormatException e){
                            System.out.println("Enter valid seat number");
                        }

                    }
                }
                //adding the ticket object to the Ticket type array list
                ticket_List.add(ticket);
                ticket.setRow_num(row);//setting the row to the Ticket class
                ticket.setSeat_num(seat);//setting the seat to the Ticket class
                break;

            }catch (NumberFormatException e){
                System.out.println("Enter 1 / 2 / 3 ");

            }
        }
    }
    //method to print the seating area
    public static void print_seating_area(int[] row1, int[] row2, int[] row3) {
        System.out.println("    ***********    ");
        System.out.println("    *  STAGE  *");
        System.out.println("    ***********    ");
        System.out.print("    ");
        for (int i = 0; i < row1.length; i++) {
            if (i == 6)
                System.out.print(" ");
            if (row1[i] == 1) {
                System.out.print("X");//prints "X" when it's booked
            } else {
                System.out.print("O");//prints "O" when it's booked
            }
        }
        System.out.println("");
        System.out.print("  ");


        for (int i = 0; i < row2.length; i++) {
            if (i == 8)
                System.out.print(" ");
            if (row2[i] == 1) {
                System.out.print("X");
            } else {
                System.out.print("O");
            }

        }
        System.out.print("\n");
        for (int i = 0; i < row3.length; i++) {
            if (i == 10)
                System.out.print(" ");
            if (row3[i] == 1) {
                System.out.print("X");
            } else {
                System.out.print("O");
            }

        }
        System.out.println("");
    }

    //method to cancel the ticket
    public static void cancel_ticket(int[] row1, int[] row2, int[] row3) {

        int row;//creating the row
        int seat;//creating the seat
        while (true) {
            try {
                System.out.print("input row number : ");
                row =Integer.parseInt(input.next());

                if (row < 1 || row > 3) {
                    System.out.println("invalid row number");
                    continue;
                } else {
                    while (true) {
                        try {
                            System.out.print("input seat number : ");
                            seat = Integer.parseInt(input.next());

                            //checking the row numbers
                            if (row == 1) {
                                //checking the valid seat range for row 1
                                if (seat < 0 || seat > 12) {
                                    System.out.println("incorrect seat number");
                                } else if (row1[seat - 1] == 1) {
                                    row1[seat - 1] = 0;
                                    System.out.println("booking cancelled");
                                    break;
                                } else if (row1[seat - 1] == 0) {
                                    System.out.println("Seat is already not booked");
                                    break;
                                }
                            } else if (row == 2) {
                                //checking the valid seat range for row 2
                                if (seat < 0 || seat > 16) {
                                    System.out.println("incorrect seat number");
                                } else if (row2[seat - 1] == 1) {
                                    row2[seat - 1] = 0;
                                    System.out.println("booking cancelled");
                                    break;
                                } else if (row2[seat - 1] == 0) {
                                    System.out.println("seat is already not booked");
                                    break;
                                }


                            } else if (row == 3) {
                                if (seat < 0 || seat > 20) {
                                    //checking the valid seat range for row 3
                                    System.out.println("incorrect seat number");
                                } else if (row3[seat - 1] == 1) {
                                    row3[seat - 1] = 0;
                                    System.out.println("booking cancelled");
                                    break;
                                } else if (row3[seat - 1] == 0) {
                                    System.out.println("Seat is already not booked");
                                    break;
                                }
                            }
                        }catch (NumberFormatException e){
                            System.out.println("Enter valid seat number");
                        }

                    }
                }
                break;
            }catch (NumberFormatException e){
                System.out.println("Enter valid row number");
            }
        }
        //------removing the ticket object from the system--------//
        int finalRow = row;//creating a new variable and assigning the rows value
        int finalSeat = seat;//creating a new variable and assigning the seat value
        ticket_List.removeIf(element -> element.getRow_num() == finalRow && element.getSeat_num() == finalSeat);
    }
    //method to print the available seats
    public static void show_available(int[] row1, int[] row2, int[] row3) {
        //print the available seats in the 1st row
        System.out.println("seats available in row 1 : ");
        for (int i = 0; i < row1.length; i++) {
            if (row1[i] == 0) {
                System.out.print(i + 1);
                if (i == 11) {
                    System.out.println(".\n");

                } else {
                    System.out.print(",");
                }
            }
        }
        //print the available seats in the 2nd row
        System.out.println("seats available in row 2 : ");
        for (int i = 0; i < row2.length; i++) {
            if (row2[i] == 0) {
                System.out.print(i + 1);
                if (i == 15) {
                    System.out.println(".\n");
                } else {
                    System.out.print(",");
                }

            }
        }
        //print the available seats in the 3rd row
        System.out.println("seats available in row 3 : ");
        for (int i = 0; i < row3.length; i++) {
            if (row3[i] == 0) {
                System.out.print(i + 1);
                if (i == 19) {
                    System.out.println(".\n");
                } else {
                    System.out.print(",");
                }
            }


        }

    }

    //method to read the file and write the data in the console
    public static void load_file(int[] row1,int[] row2, int[] row3) {
        try {
            FileReader readFile = new FileReader("fileDetails.txt");//getting the file to read
            int line = readFile.read();//assigning the first character to an int type variable
            while(line!=-1){
                //reading the file until the last character
                System.out.print((char)line);
                line=readFile.read();
            }
        } catch (IOException e) {
            System.out.println("The file not found !");
            //if there's an error the error will display through the "sout" statement.
        }

    }
    //method to write the data in the text file
    public static void save(int[] row1,int[] row2, int[] row3) {
        try {
            FileWriter writer = new FileWriter("fileDetails.txt");
            // creat a FileWriter object for the file
            writer.write("seats available in row 1 : ");//writing the 1st row's details
            for (int i=0;i<row1.length;i++){
                writer.write(row1[i]+" ");
            }
            writer.write("\n");
            writer.write("seats available in row 2 : ");//writing the 2nd row's details
            for (int i=0;i<row2.length;i++){
                writer.write(row2[i]+" ");
            }
            writer.write("\n");
            writer.write("seats available in row 3 : ");//writing the 3rd row's details
            for (int i=0;i<row3.length;i++){
                writer.write(row3[i]+" ");
            }
            writer.write("\n");
            writer.close();//closes the opened file
            System.out.println("Successfully wrote to the file");//message to show after writing the data successfully.
        }
        catch (IOException e){
            System.out.println("An error occurred.");
        }
    }
    //the method to print the ticket details
    public static void show_ticket_details(){
        double total=0;
        for (Ticket element:ticket_List){
            element.print();//calling the print method through the Ticket type element variable
            total+= element.getPrices();
            System.out.println();
        }
        System.out.println("Total value of Tickets : Rs."+ total);

    }
    //method to sort the tickets according to the price
    static void sort_tickets(){             // referenced from SD2 week8 sort search pdf,section - selection sort

        int minIndex;//creating a variable to assign the minimum value
        Ticket temp;//creating a Ticket typed variable to store the ticket object
        for(int start = 0; start < ticket_List.size()-1; start++) {
            minIndex = start;
            for(int i = start+1; i <= ticket_List.size()-1; i++) {
                if(ticket_List.get(i).getPrices() < ticket_List.get(minIndex).getPrices()) minIndex = i;
            }
            temp = ticket_List.get(start);
            ticket_List.set(start,ticket_List.get(minIndex));
            ticket_List.set(minIndex,temp);

        }
        for(Ticket t:ticket_List){
            t.print();
            System.out.println("\n");
        }

    }

}

