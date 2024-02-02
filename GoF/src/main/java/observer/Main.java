package observer;

public class Main {
    public static void main(String[] args) {
        RabotaBy rabotaBy = new RabotaBy();
        rabotaBy.addVacancy("Java Junior in Yandex");
        rabotaBy.addVacancy("C++ developer");
        rabotaBy.addVacancy("PHP developer");

        Observer javaJunior = new Juniors("Vasiya");
        Observer javaScriptJunior = new Juniors("Lena");

        rabotaBy.addObserver(javaJunior);
        rabotaBy.addObserver(javaScriptJunior);

        rabotaBy.removeVacancy("PHP developer");
        rabotaBy.addVacancy("Junior Developer");
        rabotaBy.removeObserver(javaScriptJunior);
        rabotaBy.addVacancy("Driver");

    }
}
