import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Diary {
    private ArrayList<String> timesOfWritings = new ArrayList<>();
    private ArrayList<String> datesOfWritings = new ArrayList<>();
    private ArrayList<String> titles = new ArrayList<>();
    private ArrayList<String> contents = new ArrayList<>();
    //private static ArrayList<String> paswords = new ArrayList<>();
    private ArrayList<String> userNames = new ArrayList<>();
    private ArrayList<String> passwords = new ArrayList<>();
    private Scanner input = new Scanner(System.in);
//    public static void main(String[] args){
//        welcomePage();
//    }
    public void welcomePage(){
        System.out.println("================WELCOME PAGE====================");
        System.out.print("Welcome to Penzu online diary. Are you a registered user? Y/N? ");
        String reply = input.next();
        if (Objects.equals(reply, "Y") || Objects.equals(reply, "y"))
            login();
        else if (Objects.equals(reply, "N") || Objects.equals(reply, "n"))
            registrationPage();
        else
            throw new IllegalArgumentException("Reply can only be Y or N");
    }
    public void registrationPage(){
        System.out.println("================REGISTRATION PAGE================");
        registerUserName();
        registerPassword();
        login();
    }
    public void registerUserName(){
        System.out.print("Enter your userName: ");
        String userName = input.next();
        if (!(Objects.equals(userName, ""))){
            userNames.add(userName);
        }
    }
    private void registerPassword(){
        System.out.print("Enter your password: ");
        String password = input.next();
        System.out.print("Confirm your password: ");
        String confirmPassWord = input.next();

        if (Objects.equals(password, confirmPassWord) && (!Objects.equals(password, ""))) {
            passwords.add(password);
            System.out.println("Password saved and user name saved!");
        }
        else {
            System.out.println("Passwords do not match!!");
            registerPassword();
        }
    }
    public void login(){
        System.out.println("=====================LOGIN PAGE===========================");
        System.out.print("Enter your userName: ");
        String userName = input.next();
        System.out.print("Enter your password: ");
        String userPassword = input.next();
        if (passwords.size() >= 1) {
            for (int item = 0; item < passwords.size(); item++) {
                if ((Objects.equals(passwords.get(item), userPassword)) &&(Objects.equals(userNames.get(item), userName))) {
                    userPage();
                } else {
                    System.out.println("Name or password does not exist. Register and then login? Y/N");
                    String reply = input.next();
                    if (Objects.equals(reply, "Y") || Objects.equals(reply, "y"))
                        registrationPage();
                    else if (Objects.equals(reply, "N") || Objects.equals(reply, "n"))
                        login();
                    else
                        throw new IllegalArgumentException("Reply can only be Y, y, N or n");
                }
            }
        }else{
            System.out.println("Name or password does not exist. Register and then login? Y/N");
            String reply = input.next();
            if (Objects.equals(reply, "Y") || Objects.equals(reply, "y")) {
                registrationPage();
            } else if (Objects.equals(reply, "N") || Objects.equals(reply, "n")){
                login();
            }else {
                throw new IllegalArgumentException("Reply can only be Y or N");
            }
        }
    }
    public void queryUser(){
        System.out.println("What would like to do? ");
        System.out.printf("1. Write %n2. View diary%n3. Delete content%n4. Exit diary%n");
        int choice = input.nextInt();
        input.nextLine();
        switch (choice) {
            case 1 -> writeInDiary();
            case 2 -> viewDiary();
            case 3 -> deleteContent();
            case 4 -> System.out.println("Have a nice day");
            default -> {
                System.out.println("Wrong choice");
                userPage();
            }
        }
    }
    public void userPage(){
        System.out.println("===============================YOUR DIARY============================");
        queryUser();
        System.out.println("Would you like to do anything else? Y/N");
        String choice = input.next();
        if (Objects.equals(choice, "Y") || Objects.equals(choice, "y"))
            queryUser();
        else if (Objects.equals(choice, "N") || Objects.equals(choice, "n"))
            System.out.println("See you next time!");
        else
            throw new IllegalArgumentException("Reply can only be Y or N");

    }
    public void writeInDiary(){
        getTitle();
        getContent();
        getDateAndTime();
        queryUser();
    }
    public void viewDiary() {
        if (titles.size() > 0){
            for (int item = 0; item < titles.size(); item++) {
                System.out.println("----------------------------------------------------------------");
                System.out.printf("Item number: %d%n", item + 1);
                System.out.printf("Date created:  %s%n", datesOfWritings.get(item));
                System.out.printf("Time created:  %s%n", timesOfWritings.get(item));
                System.out.printf("Title:  %s%n", titles.get(item));
                System.out.printf("Content:%n%s%n", contents.get(item));
                System.out.println("-----------------------------------------------------------------");
            }
            System.out.println();
        }else{
            System.out.println("Nothing to see here");
        }
        queryUser();
    }
    public void deleteContent() {
        System.out.println("Enter the item number of the content to be deleted");
        int item = input.nextInt();
        if (titles.size() != 0) {
            if (!(item > titles.size())) {
                titles.remove(item - 1);
                contents.remove(item - 1);
                datesOfWritings.remove(item - 1);
                timesOfWritings.remove(item - 1);
                System.out.println("Item removed successfully!");
            }else{
                System.out.println("Item does not exist");
            }
            queryUser();
        }else{
            System.out.println("Sorry. No item item to delete");
            queryUser();
        }
    }
    public void getDateAndTime(){
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("E, MMM dd yyyy");
        String formattedDate = currentDate.format(datePattern);
        datesOfWritings.add(formattedDate);
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter timePattern = DateTimeFormatter.ofPattern("hh:mm a");
        String formattedTime = currentTime.format(timePattern);
        timesOfWritings.add(formattedTime);
    }
    public void getTitle(){
        System.out.print("Title: ");
        String title = input.nextLine();
        if (!Objects.equals(title, ""))
            titles.add(title);
    }
    public void getContent(){
        System.out.print("Content: ");
        String memorableEvent = input.nextLine();
        if (!(Objects.equals(memorableEvent, "")))
            contents.add(memorableEvent);
    }
}
