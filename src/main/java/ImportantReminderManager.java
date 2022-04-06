import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.util.*;

public class ImportantReminderManager extends Thread  {

    private Object lock = "lock";
    private List<Reminder> importantReminderList = new ArrayList<>();
    private boolean isQuite=true;

    @Override
    public void run() {

    while (isQuite){
      try {

          Thread.sleep(1000);
           synchronized(lock) {
          for (Reminder reminder : importantReminderList) {

              if (reminder.getTime() && !reminder.isShowed()) {
                  System.out.println(reminder.toString());
                  reminder.setShowed(true);
              } else if (reminder.getImportantTime()) {
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
         synchronized (lock) {
             importantReminderList.add(r);
         }

}

 public void stopThread(){

      this.isQuite=false;

    }

 public void printReminder(){
     Collections.sort(this.importantReminderList);

        for (Reminder r : importantReminderList){
       System.out.println(r.toString() +"\n");
   }
 }



}