import java.util.Scanner;

public class MainReminderSystem {

    public static void main(String[] args) throws InterruptedException {

    boolean isQuite=true;
    Scanner scanner = new Scanner(System.in);

    ImportantReminderManager importantManager = new ImportantReminderManager();
    ReminderManager reminderManager = new ReminderManager();

    reminderManager.start();
    importantManager.start();



    while (true){

        System.out.println
                ("Please enter your choice ):\n"
                +"\n to add reminder press one"
                +"\n to add important reminder please press two"
                +"\n to view your reminder press three"
                +"\n to exit from the system press four");

        int choice = scanner.nextInt();

        switch (choice) {

            case 1:

                System.out.println("please write your reminder");
                String text1 = scanner.nextLine();
                String text = scanner.nextLine();


                System.out.println("please enter what minute do you want to reminder (enter numbers  between 1-59)");
                int minuteChoice = scanner.nextInt();

                reminderManager.addReminder(new Reminder(text,false,false,minuteChoice));

                break;

            case 3:
               importantManager.printReminder();
               reminderManager.printReminder();
               break;

            case 2:

                System.out.println("please write your reminder)");
                String importantText1 = scanner.nextLine();
                String importantText = scanner.nextLine();


                System.out.println("please enter what minute do you want to reminder (enter numbers  between 1-59)");
                int importantMinuteChoice = scanner.nextInt();

               importantManager.addReminder(new Reminder(importantText,false,true,importantMinuteChoice));


               break;

            case 4:
             stopThread(isQuite);
             break;





        }









    }




    }



    public static void stopThread(boolean quite){
       quite=false;
    }

}




