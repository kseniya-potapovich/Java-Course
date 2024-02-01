package proxy.lesson;

public class RepositoryImpl implements Repository {

    @Override
    public void insertDataToDatabase(String data) {
        System.out.println("connect database");
        System.out.println("save data " + data);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e){
            System.out.println(e);
        }
    }
}
