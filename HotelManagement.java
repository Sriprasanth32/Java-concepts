
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;

class HotelManagement {

    public static void main(String[] args) {

        RoomReservation roomreservation = new RoomReservation();
        roomreservation.start();
        roomreservation.menu();

    }
}

class RoomReservation extends HotelManagement {
    static String choice;
    static String customerName = "";
    static int roomNumber = 0;
    static String mobileNumber = "";
    static String[] singleRoom = new String[15];
    static String[] doubleRoom = new String[10];
    static Scanner scanner = new Scanner(System.in);
    static String answer;

    public void insert(int roomNumber, String customerName, String mobileNumber) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlproject", "root",
                    "Number@32");
            Statement statement = connection.createStatement();
            String customerDetails = "insert into sqlproject.room(roomNumber,customerName,mobileNumber) value("
                    + roomNumber + ",'" + customerName
                    + "','" + mobileNumber + "')";
            statement.executeUpdate(customerDetails);
            connection.close();
        } catch (SQLException sqlexception) {
            sqlexception.printStackTrace();
        }
    }

    public void initialize(String singleRoom[], String doubleRoom[]) {

        for (int counter = 0; counter < 15; counter++) {
            singleRoom[counter] = "empty";
        }
        for (int counter = 0; counter < 10; counter++) {
            doubleRoom[counter] = "empty";
        }
    }

    public void start() {
        initialize(singleRoom, doubleRoom);
    }

    public void menu() {
        System.out.println("*            Hotel Management System                 *");
        System.out.println("* V. View all the rooms                              *");
        System.out.println("* A. Add customer to room                            *");
        System.out.println("* D. Delete customer from room                       *");
        System.out.println("* F. Find room from customer name                    *");
        System.out.println("* Q. Quit Program                                    *");

        do {
            System.out.print("Choice : ");
            choice = scanner.next();
            String selection = choice.toLowerCase();

            switch (selection) {

                case "v":
                    viewRooms();
                    break;
                case "a":

                    addCustomer();
                    break;

                case "d":
                    deleteCustomer();
                    break;

                case "f":
                    findRoom();
                    break;

                case "q":
                    System.out.println("Thanks");
                    break;

                default:
                    System.out.println("Invalid input! ");
            }
        } while (!(choice.equalsIgnoreCase("v") || choice.equalsIgnoreCase("a") || choice.equalsIgnoreCase("d")
                || choice.equalsIgnoreCase("f") || choice.equalsIgnoreCase("q")));

    }

    public void viewRooms() {
        System.out.println("1.Single or 2.double");
        int roomType = scanner.nextInt();
        switch (roomType) {
            case 1:
                while (roomNumber < 15) {
                    for (int counter = 0; counter < 15; counter++) {

                        if (!(singleRoom[counter].equals("empty"))) {
                            System.out.println("Room No. " + (counter + 1) + " is occupied by " + singleRoom[counter]);

                        } else {
                            System.out.println("Room No. " + (counter + 1) + " is empty");
                        }
                    }
                    break;
                }
                break;
            case 2:
                while (roomNumber < 10) {
                    for (int counter = 0; counter < 10; counter++) {

                        if (!(doubleRoom[counter].equals("empty"))) {
                            System.out.println("Room No. " + (counter + 16) + " is occupied by " + doubleRoom[counter]);

                        } else {
                            System.out.println("Room No. " + (counter + 16) + " is empty");
                        }
                    }
                    break;
                }
                break;
            default:
                System.out.println("Invalid input!");
        }

        System.out.println("press Y to continue");
        char customerChoice = scanner.next().charAt(0);
        if (Character.toLowerCase(customerChoice) == 'y') {
            menu();
        }
    }

    public void addCustomer() {

        boolean invalidRoomNumber;
        System.out.println("1.Single or 2.double");
        int roomType = scanner.nextInt();
        switch (roomType) {
            case 1:

                do {
                    invalidRoomNumber = false;
                    try {

                        System.out.println("Enter room number (1-15)");
                        roomNumber = scanner.nextInt();
                        if (!(singleRoom[roomNumber - 1].equals("empty"))) {
                            invalidRoomNumber = true;
                            System.out.println("This room is occupied by: " + singleRoom[roomNumber - 1]);
                            System.out.println("");
                        } else if (roomNumber - 1 >= 0 && roomNumber - 1 < 15) {
                            invalidRoomNumber = false;
                        } else {
                            invalidRoomNumber = true;
                            System.out.println("Invalid input! Please Enter a value between 1-15");
                            System.out.println("");
                        }
                    } catch (InputMismatchException inputmismatchexception) {
                        invalidRoomNumber = true;
                        System.out.println("Invalid input! Please Enter a value between 1-15");
                        System.out.println("");
                        scanner.next();
                    } catch (IndexOutOfBoundsException indexoutofboundexception) {
                        invalidRoomNumber = true;
                        System.out.println("Invalid input! Please Enter a value between 1-15");
                        System.out.println("");
                        scanner.next();
                    }
                } while (invalidRoomNumber);
                System.out.println("Enter the name of the customer :");
                customerName = scanner.next();
                singleRoom[roomNumber - 1] = customerName;
                addMobile();
                break;
            case 2:
                do {
                    invalidRoomNumber = false;
                    try {

                        System.out.println("Enter room number (16-25)");
                        roomNumber = scanner.nextInt();
                        if (!(doubleRoom[roomNumber - 16].equals("empty"))) {
                            invalidRoomNumber = true;
                            System.out.println("This room is occupied by: " + doubleRoom[roomNumber - 16]);
                            System.out.println();
                        } else if ((roomNumber - 16) >= 0 && (roomNumber - 16) < 10) {
                            invalidRoomNumber = false;
                        } else {
                            invalidRoomNumber = true;
                            System.out.println("Invalid input! Please Enter a value between 16-25");
                            System.out.println("");
                        }
                    } catch (InputMismatchException inputmismatchexception) {
                        invalidRoomNumber = true;
                        System.out.println("Invalid input! Please Enter a value between 16-25");
                        System.out.println("");
                        scanner.next();
                    } catch (IndexOutOfBoundsException indexoutofboundexception) {
                        invalidRoomNumber = true;
                        System.out.println("Invalid input! Please Enter a value between 16-25");
                        System.out.println("");
                        scanner.next();
                    }
                } while (invalidRoomNumber);
                System.out.println("Enter the name of the customer :");
                customerName = scanner.next();
                doubleRoom[roomNumber - 16] = customerName;
                addMobile();
                break;
            default:
                System.out.println("Invalid input!");

        }
        do {
            System.out.println("Add more?(Y/N)");
            answer = scanner.next();
            String selection = answer.toLowerCase();

            switch (selection) {
                case "y":
                    addCustomer();
                    break;
                case "n":
                    System.out.println();
                    insert(roomNumber, customerName, mobileNumber);
                    menu();
            }

        } while (!(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n")));

    }

    public void addMobile() {
        System.out.println("Enter a valid Mobile no.");
        do {
            mobileNumber = scanner.next();
            if (!isValidNo(mobileNumber)) {
                System.out.println("Error! Enter a valid no.");
            }
        } while (!isValidNo(mobileNumber));
    }

    public boolean isValidNo(String phoneNumber) {
        Pattern pattern = Pattern.compile("(0/91)?[7-9][0-9]{9}");

        Matcher matcher = pattern.matcher(phoneNumber);

        return (matcher.find() && matcher.group().equals(phoneNumber));
    }

    public void deleteCustomer() {
        boolean invalidInput;
        do {
            invalidInput = false;
            try {
                System.out.println("please enter the Room's number which you want to vacate");
                roomNumber = scanner.nextInt();
                if ((roomNumber) <= 15) {
                    if (!(singleRoom[roomNumber - 1].equals("empty"))) {
                        invalidInput = false;
                        singleRoom[roomNumber - 1] = "empty";
                    } else {
                        invalidInput = true;
                        System.out.println("Room " + (roomNumber) + " is already Empty");
                        System.out.println();
                    }
                } else if ((roomNumber) > 15) {
                    if (!(doubleRoom[roomNumber - 16].equals("empty"))) {
                        invalidInput = false;
                        doubleRoom[roomNumber - 16] = "empty";
                    } else {
                        invalidInput = true;
                        System.out.println("Room " + (roomNumber) + " is already Empty");
                        System.out.println();
                    }
                }
            } catch (InputMismatchException inputmismatchexception) {
                invalidInput = true;
                System.out.println("Invalid input! Please Enter a value between 1-25");
                System.out.println("");
                scanner.next();
            } catch (IndexOutOfBoundsException inputoutofboundexception) {
                invalidInput = true;
                System.out.println("Invalid room number. Please enter a value between 1-25");
                scanner.next();
            }
        } while (invalidInput);
        System.out.println("Do you want to checkout?");
        char checkout = scanner.next().charAt(0);
        if (Character.toLowerCase(checkout) == 'y') {
            bill(roomNumber);
        }
        System.out.println("Room " + roomNumber + " has successfully been vacated");

        System.out.println("Press y to continue");
        char userChoice = scanner.next().charAt(0);
        if (Character.toLowerCase(userChoice) == 'y') {
            menu();
        }
    }

    public void bill(int roomNumber) {
        System.out.print(roomNumber);
        int amount = 0;
        System.out.println("Enter the number of days :");
        int days = scanner.nextInt();
        if (roomNumber <= 15) {
            amount = 500 * days;
        } else if (roomNumber > 15) {
            amount = 800 * days;
        }
        System.out.println("**********Bill**********");
        System.out.println("        " + "Rs." + (double) amount);

    }

    public void findRoom() {

        System.out.println("Please enter the name of the customer");
        boolean found = false;
        String find = scanner.next();
        String[] rooms = new String[singleRoom.length + doubleRoom.length];
        System.arraycopy(singleRoom, 0, rooms, 0, singleRoom.length);
        System.arraycopy(doubleRoom, 0, rooms, singleRoom.length, doubleRoom.length);
        for (int counter = 0; counter < rooms.length; counter++) {
            if (rooms[counter].equalsIgnoreCase(find)) {
                found = true;
                System.out.println(find + " is staying in room No. " + (counter + 1));
                System.out.println("Press Y to continue");
                char userChoice = scanner.next().charAt(0);
                if (Character.toLowerCase(userChoice) == 'y') {
                    menu();
                }
            }
        }

        if (found == false) {
            System.out.println(find + " doesn't exist on our database");
            System.out.println("Press Y to continue");
            char userInput = scanner.next().charAt(0);
            if (Character.toLowerCase(userInput) == 'y') {
                menu();
            }
        }

    }
}
