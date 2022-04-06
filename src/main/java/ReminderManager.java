import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReminderManager extends Thread {
    private Object lock = "lock";
    private List<Reminder> reminderList = new ArrayList<>();
    private boolean isQuite=true;

    @Override
   public void run() {

        while (isQuite){

            try {

                Thread.sleep(1000);
                synchronized(lock){
                    for (Reminder reminder : reminderList ){

                        if (reminder.getTime()){
                            System.out.println(reminder.toString());
                        }

                    }
                }



            }





            catch (InterruptedException e) {
                System.out.println("check why is not work");
            }


        }

    }



    public void addReminder(Reminder r) {
        synchronized(lock) {
            reminderList.add(r);
        }
        }

    public void stopThread(){
        this.isQuite=false;
    }

    public void printReminder(){
        Collections.sort(this.reminderList);
        for (Reminder r : reminderList){
            System.out.println(r.toString() +"\n");
        }
    }


}
