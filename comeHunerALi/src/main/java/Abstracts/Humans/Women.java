package Abstracts.Humans;

import Abstracts.Enums.DayOfWeeks;
import Abstracts.Family;
import Abstracts.Human;

import java.util.Map;


public final class Women extends Human {
    public void makeup() {

    }
    public Women(String name, String surname, long year ,int iq) {
        super(name, surname, year, iq);
    }
    public Women(String name, String surname, Long year, int iq, Map<DayOfWeeks, String> schedule, Family family) {
        super(name, surname, year, iq, schedule, family);
    }

    public Women() {
    }

    public Women(String name, String surname, Long year) {
        super(name, surname, year);
    }

    @Override
    public void greetPet() {
        System.out.println("Women greeting pet");
    }
}

