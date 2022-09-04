package Abstracts.Humans;


import Abstracts.Enums.DayOfWeeks;
import Abstracts.Family;
import Abstracts.Human;

import java.util.Map;

public final class Man extends Human {
    public Man(String name, String surname, long year ,int iq) {
        super(name, surname, year, iq);
    }

    public void smoking() {

    }

    public Man(String name, String surname, Long year, int iq, Map<DayOfWeeks, String> schedule, Family family) {
        super(name, surname, year, iq, schedule, family);
    }

    public Man() {
    }

    public Man(String name, String surname, Long year) {
        super(name, surname, year);
    }

    @Override
    public void greetPet() {
        System.out.println("Man greeting pet");
    }
}
