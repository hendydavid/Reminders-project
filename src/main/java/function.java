public class DataBaseManager {


    private int id = (new Random().nextInt(10000));

    public DataBaseManager() {
        System.out.println("i am lazy");
    }

    public int getId() {
        return id;
    }

    public void save(Person p) {

    }

    @Override
    public String toString() {
        return "DataBaseManager{" +
                "id=" + id +
                '}';
    }
}
