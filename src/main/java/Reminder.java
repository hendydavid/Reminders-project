import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Reminder implements Comparable<Reminder> {

private Calendar expiration = Calendar.getInstance();
private String text;
private boolean isShowed;
private boolean isImportant;

    public Reminder(String text, boolean isShowed, boolean isImportant,int time) {
        this.text = text;
        this.isShowed = isShowed;
        this.isImportant = isImportant;
        setTimeReminder(time);

    }

    public Calendar getExpiration() {
        return expiration;
    }

    public void setExpiration(Calendar expiration) {
        this.expiration = expiration;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isShowed() {
        return isShowed;
    }

    public void setShowed(boolean showed) {
        isShowed = showed;
    }

    public boolean isImportant() {
        return isImportant;
    }

    public void setImportant(boolean important) {
        isImportant = important;
    }


   private void setTimeReminder(int minute) {

    this.expiration.set(Calendar.MINUTE,minute);

    }

    public boolean getTime (){
        Date d = new Date();
    return d.getTime()>=this.expiration.getTimeInMillis();
    }

    public boolean getImportantTime (){
        Date d = new Date();
        if (this.isImportant){
            return d.getTime()-this.expiration.getTimeInMillis()==-60000 ||
                    d.getTime()-this.expiration.getTimeInMillis()==-120000;
        }
    return false;
    }



    @Override
    public String toString() {
        return "Reminder{" +
                "time is: at hour = " + expiration.get(Calendar.HOUR) +
                " and minute= " + expiration.get(Calendar.MINUTE) +
                " and second= " + expiration.get(Calendar.SECOND) +
                ", text='" + text + '\'' +
                ", isShowed=" + isShowed +
                ", isImportant=" + isImportant +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reminder reminder = (Reminder) o;
        return isShowed == reminder.isShowed && isImportant == reminder.isImportant && Objects.equals(expiration, reminder.expiration) && Objects.equals(text, reminder.text);
    }

    @Override
    public int compareTo(Reminder o) {
        if (this.expiration.getTimeInMillis()-o.expiration.getTimeInMillis()>0) return 1;
        if (this.expiration.getTimeInMillis()-o.expiration.getTimeInMillis()<0) return -1;
      return 0;
    }
}
