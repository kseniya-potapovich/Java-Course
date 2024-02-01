package proxy.lesson;

import java.time.LocalTime;

public class ProxyRepository implements Repository{
    private RepositoryImpl repository = new RepositoryImpl();
    @Override
    public void insertDataToDatabase(String data) {
        LocalTime start = LocalTime.now();
        repository.insertDataToDatabase(data);
        LocalTime finish = LocalTime.now();
        System.out.println(finish.toNanoOfDay() - start.toNanoOfDay());
    }
}
