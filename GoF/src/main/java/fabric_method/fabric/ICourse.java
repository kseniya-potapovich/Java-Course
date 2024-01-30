package fabric_method.fabric;

import fabric_method.developers.IDeveloper;

public interface ICourse {
    default void courseInfo() {
        IDeveloper developer = getDeveloper();
        System.out.println("Добро пожаловать на наш курс!");
        System.out.println("На нем вы изучите" + developer.getLanguage() + "язык!");
        System.out.println("Вы узнаете следующие технологии: " + developer.commonStack());
        System.out.println("Средняя зарплата по рынку: " + developer.getSalary() + "$");
        System.out.println("Ждем вас!!!");
    }

    IDeveloper getDeveloper();
}
