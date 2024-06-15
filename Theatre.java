import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Theatre {
    static int[] row1 = new int[12];
    static int[] row2 = new int[16];
    static int[] row3 = new int[20];

    static int row1TicketPrice=30;
    static int row2TicketPrice=20;
    static int row3TicketPrice=10;

    static ArrayList<Ticket> ticketList=new ArrayList<Ticket>();

    public static void main(String[] args) {
        System.out.println("Welcome to the New Theatre");

        // Initialize seat arrays with all seats free
        int i = 0;
        for (i = 0; i < row1.length; i++) {
            row1[i] = 0;
        }
        int j = 0;
        for (j = 0; j < row2.length; j++) {
            row2[j] = 0;
        }
        int k = 0;
        for (k = 0; k < row3.length; k++) {
            row3[k] = 0;
        }

        // Create scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Main menu loop
        while (true) {
            // Print menu options
            System.out.println("Please select an option:");
            System.out.println("1) Buy a ticket");
            System.out.println("2) Print seating area");
            System.out.println("3) Cancel ticket");
            System.out.println("4) List available seats");
            System.out.println("5) Save to file");
            System.out.println("6) Load from file");
            System.out.println("7) Print ticket information and total price");
            System.out.println("8) Sort tickets by price");
            System.out.println("0) Quit");

            // Get user input for option selection
            System.out.print("Enter option: ");
            int option = scanner.nextInt();

            // Process selected option
            switch (option) {
                case 0:
                    System.out.println("Thank you for visiting New Theatre ");
                    return;
                case 1:
                    buy_ticket();
                    break;
                case 2:
                    print_seating_area();
                    break;
                case 3:
                    cancel_ticket();
                    break;
                case 4:
                    show_available();
                    break;
                case 5:
                    save();
                    break;
                case 6:
                    load();
                    break;
                case 7:
                    show_tickets_info();
                    break;
                case 8:
                    sort_tickets();
                    break;
                default:
                    System.out.println("Invalid option selected. Please try again.");
                    break;
            }
        }


    }

    public static void buy_ticket() {

        Scanner scanner = new Scanner(System.in);
        String name;
        String surname;
        String email;
        Ticket ticket;
        Person person;

        // ask for row number and seat number
        while (true) {
            System.out.print("Enter row number (1-3) : ");
            int row = scanner.nextInt();
            int seat;
            if (row == 1) {
                while (true) {
                    System.out.print("Enter seat number(1-12): ");
                    seat = scanner.nextInt();
                    if (seat >= 1 && seat <= 12 && row1[seat - 1] != 1) {
                        row1[seat - 1] = 1;

                        //create person object
                        System.out.println("Enter personal details...");
                        System.out.print("Name: ");
                        name=scanner.next();
                        System.out.print("Surname: ");
                        surname=scanner.next();
                        System.out.print("Email: ");
                        email=scanner.next();

                        person=new Person(name,surname,email);

                        //create ticket object and add to ticketList
                        ticket=new Ticket(row,seat,row1TicketPrice,person);
                        ticketList.add(ticket);

                        System.out.println("You successfully booked row:" + row + " seat:" + seat + "\n");
                        break;
                    } else if (seat < 1 || seat > 12) {
                        System.out.println("Invalid seat number! Please enter a seat number between 1 - 12.");
                    } else if (row1[seat - 1] == 1) {
                        System.out.println("This seat is occupied! Please enter an available seat number!");
                    }


                }
                break;
            } else if (row == 2) {
                while (true) {
                    System.out.print("Enter seat number(1-16): ");
                    seat = scanner.nextInt();
                    if (seat >= 1 && seat <= 16 && row2[seat - 1] != 1) {
                        row2[seat - 1] = 1;

                        //create person object
                        System.out.println("Enter personal details...");
                        System.out.print("Name: ");
                        name=scanner.next();
                        System.out.print("Surname: ");
                        surname=scanner.next();
                        System.out.print("Email: ");
                        email=scanner.next();

                        person=new Person(name,surname,email);

                        //create ticket object and add to ticketList
                        ticket=new Ticket(row,seat,row2TicketPrice,person);
                        ticketList.add(ticket);

                        System.out.println("You successfully booked row:" + row + " seat:" + seat + "\n");
                        break;
                    } else if (seat < 1 || seat > 16) {
                        System.out.println("Invalid seat number! Please enter a seat number between 1 - 16.");
                    } else if (row2[seat - 1] == 1) {
                        System.out.println("This seat is occupied! Please enter an available seat number!");
                    }

                }
                break;
            } else if (row == 3) {
                while (true) {
                    System.out.print("Enter seat number(1-20): ");
                    seat = scanner.nextInt();
                    if (seat >= 1 && seat <= 20 && row3[seat - 1] != 1) {
                        row3[seat - 1] = 1;

                        //create person object
                        System.out.println("Enter personal details...");
                        System.out.print("Name: ");
                        name=scanner.next();
                        System.out.print("Surname: ");
                        surname=scanner.next();
                        System.out.print("Email: ");
                        email=scanner.next();

                        person=new Person(name,surname,email);

                        //create ticket object and add to ticketList
                        ticket=new Ticket(row,seat,row3TicketPrice,person);
                        ticketList.add(ticket);

                        System.out.println("You successfully booked row:" + row + " seat:" + seat + "\n");
                        break;
                    } else if (seat < 1 || seat > 20) {
                        System.out.println("Invalid seat number! Please enter a seat number between 1 - 20.");
                    } else if (row3[seat - 1] == 1) {
                        System.out.println("This seat is occupied! Please enter an available seat number!");
                    }

                }
                break;
            } else {
                System.out.println("Invalid row number! Please enter valid row number between 1 - 3.");
            }
        }
    }

    public static void print_seating_area() {
        //print stage
        System.out.println("    ***********");
        System.out.println("    *  STAGE  *");
        System.out.println("    ***********");

        // print the seats in row 1
        System.out.print("    ");
        for (int i = 0; i < row1.length; i++) {
            if (i == 6) {
                System.out.print(" ");
            }
            if (row1[i] == 0) {
                System.out.print("O");
            } else {
                System.out.print("X");
            }
        }
        System.out.println();

        // print the seats in row 2
        System.out.print("  ");
        for (int i = 0; i < row2.length; i++) {
            if (i == 8) {
                System.out.print(" ");
            }
            if (row2[i] == 0) {
                System.out.print("O");
            } else {
                System.out.print("X");
            }
        }
        System.out.println();

        // print the seats in row 3
        for (int i = 0; i < row3.length; i++) {
            if (i == 10) {
                System.out.print(" ");
            }
            if (row3[i] == 0) {
                System.out.print("O");
            } else {
                System.out.print("X");
            }
        }
        System.out.println();
        System.out.println();
    }

    public static void cancel_ticket() {
        Scanner scanner = new Scanner(System.in);
        // ask for row number and seat number
        while (true) {
            System.out.print("Enter row number (1-3) : ");
            int row = scanner.nextInt();
            int seat;
            Ticket ticket;
            if (row == 1) {
                while (true) {
                    System.out.print("Enter the seat number you want to cancel booking(1-12): ");
                    seat = scanner.nextInt();
                    if (seat >= 1 && seat <= 12 && row1[seat - 1] == 1) {
                        row1[seat - 1] = 0;

                        for (int i = 0; i < ticketList.size(); i++) {
                            ticket=ticketList.get(i);
                            if (ticket.row==row && ticket.seat==seat){
                                ticketList.remove(ticket);
                            }
                        }

                        System.out.println("You successfully cancelled the booking of row:" + row + " seat:" + seat + "\n");
                        break;
                    } else if (seat < 1 || seat > 12) {
                        System.out.println("Invalid seat number! Please enter a seat number between 1 - 12.");
                    } else if (row1[seat - 1] == 0) {
                        System.out.println("This seat is not occupied! Please enter an occupied seat number to cancel the booking!");
                    }
                }
                break;
            } else if (row == 2) {
                while (true) {
                    System.out.print("Enter the seat number you want to cancel booking(1-16): ");
                    seat = scanner.nextInt();
                    if (seat >= 1 && seat <= 16 && row2[seat - 1] == 1) {
                        row2[seat - 1] = 0;

                        for (int i = 0; i < ticketList.size(); i++) {
                            ticket=ticketList.get(i);
                            if (ticket.row==row && ticket.seat==seat){
                                ticketList.remove(ticket);
                            }
                        }

                        System.out.println("You successfully cancelled the booking of row:" + row + " seat:" + seat + "\n");
                        break;
                    } else if (seat < 1 || seat > 16) {
                        System.out.println("Invalid seat number! Please enter a seat number between 1 - 16.");
                    } else if (row2[seat - 1] == 0) {
                        System.out.println("This seat is not occupied! Please enter an occupied seat number to cancel the booking!");
                    }

                }
                break;
            } else if (row == 3) {
                while (true) {
                    System.out.print("Enter the seat number you want to cancel booking: ");
                    seat = scanner.nextInt();
                    if (seat >= 1 && seat <= 20 && row3[seat - 1] == 1) {
                        row3[seat - 1] = 0;

                        for (int i = 0; i < ticketList.size(); i++) {
                            ticket=ticketList.get(i);
                            if (ticket.row==row && ticket.seat==seat){
                                ticketList.remove(ticket);
                            }
                        }

                        System.out.println("You successfully cancelled the booking of row:" + row + " seat:" + seat + "\n");
                        break;
                    } else if (seat < 1 || seat > 20) {
                        System.out.println("Invalid seat number! Please enter a seat number between 1 - 20.");
                    } else if (row3[seat - 1] == 0) {
                        System.out.println("This seat is not occupied! Please enter an occupied seat number to cancel the booking!");
                    }

                }
                break;
            } else {
                System.out.println("Invalid row number! Please enter valid row number between 1 - 3.");
            }
        }
    }

    public static void show_available() {
        System.out.print("Seats available in row 1: ");
        for (int i = 0; i < row1.length; i++) {
            if (row1[i] == 0) {
                System.out.print((i + 1) + ", ");
            }
        }
        System.out.println("\b\b.");
        System.out.print("Seats available in row 2: ");
        for (int i = 0; i < row2.length; i++) {
            if (row2[i] == 0) {
                System.out.print((i + 1) + ", ");
            }
        }
        System.out.println("\b\b.");
        System.out.print("Seats available in row 3: ");
        for (int i = 0; i < row3.length; i++) {
            if (row3[i] == 0) {
                System.out.print((i + 1) + ", ");
            }
        }
        System.out.println("\b\b.");
        System.out.println();
    }

    public static void save() {
        try {
            File myObj = new File("mydata.txt");

            BufferedWriter outputWriter = null;
            outputWriter = new BufferedWriter(new FileWriter("mydata.txt"));
            for (int i = 0; i < row1.length; i++) {
                outputWriter.write(row1[i] + "");
                outputWriter.newLine();
            }
            for (int i = 0; i < row2.length; i++) {
                outputWriter.write(row2[i] + "");
                outputWriter.newLine();
            }
            for (int i = 0; i < row3.length; i++) {
                outputWriter.write(row3[i] + "");
                outputWriter.newLine();
            }
            outputWriter.flush();
            outputWriter.close();
            System.out.println("Saving to the file...");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void load() {
        List<String> listOfStrings1 = new ArrayList<String>();
        List<String> listOfStrings2 = new ArrayList<String>();
        List<String> listOfStrings3 = new ArrayList<String>();

        // load data from file
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader("mydata.txt"));
            // read entire line as string
            String line = bf.readLine();

            // checking for end of file
            while (line != null) {
                for (int i = 0; i < 12; i++) {
                    listOfStrings1.add(line);
                    line = bf.readLine();
                }
                for (int i = 0; i < 16; i++) {
                    listOfStrings2.add(line);
                    line = bf.readLine();
                }
                for (int i = 0; i < 20; i++) {
                    listOfStrings3.add(line);
                    line = bf.readLine();
                }
                listOfStrings1.add(line);
                line = bf.readLine();
            }

            // closing bufferreader object
            bf.close();

            // storing the data in arraylist to array
            String[] array1 = listOfStrings1.toArray(new String[12]);
            String[] array2 = listOfStrings2.toArray(new String[16]);
            String[] array3 = listOfStrings3.toArray(new String[20]);

            int[] intArr1 = new int[12];
            for (int i = 0; i < 12; i++) {
                intArr1[i] = Integer.parseInt(array1[i]);
            }
            int[] intArr2 = new int[16];
            for (int i = 0; i < 16; i++) {
                intArr2[i] = Integer.parseInt(array2[i]);
            }
            int[] intArr3 = new int[20];
            for (int i = 0; i < 20; i++) {
                intArr3[i] = Integer.parseInt(array3[i]);
            }

            row1 = intArr1;
            row2 = intArr2;
            row3 = intArr3;

            System.out.println("Loading from the file...");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void show_tickets_info(){
        double total=0;
        System.out.println("Listing all tickets...");
        for (Ticket t : ticketList) {
            t.print();
            System.out.println();
            total+=t.price;
        }
        System.out.println("Total price: "+total);
    }

    public static ArrayList<Ticket> sort_tickets(){
        ArrayList<Ticket> sortedTicketList=new ArrayList<Ticket>();
        for (Ticket t : ticketList) {
            if (t.price==row3TicketPrice){
                sortedTicketList.add(t);
            }
        }
        for (Ticket t : ticketList) {
            if (t.price==row2TicketPrice){
                sortedTicketList.add(t);
            }
        }
        for (Ticket t : ticketList) {
            if (t.price==row1TicketPrice){
                sortedTicketList.add(t);
            }
        }
        for (Ticket t : sortedTicketList) {
            t.print();
            System.out.println();
        }
        return sortedTicketList;
    }

}


