import Abstracts.Family;
import Abstracts.Human;
import Abstracts.Humans.*;

import Abstracts.Pet;
import Abstracts.Pets.Dog;
import Dao.FamilyDao;
import Dao.FamilyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FamilyServiceTest {
    private FamilyService service;
    private Man father;
    private Women mother;
    private Family family;

    @BeforeEach
    void setUp() {
        service = new FamilyService();
        father = new Man("Nadir", "Father", 1970, 100);
        mother = new Women("Gullu", "Mother", 1980, 98);
    }

    @Test
    void creatingNewFamily() {
        family = service.createNewFamily(mother, father);
        assertEquals(1, service.count());
    }
 @Test
    void deletingFamily() {
        family = service.createNewFamily(mother, father);
        service.deleteFamilyByIndex(0);
        assertEquals(0, service.count());
    }

    @Test
    void bornChild() {
        family = service.createNewFamily(mother, father);
        service.bornChild(family, "Masculine");
        assertEquals(1, service.getFamilyById(0).getChildren().size());
    }

    @Test
    void adoptingChild() {
        Human child = new Man("Child", "Adopt", 2010, 99);
        family = service.createNewFamily(mother, father);
        service.bornChild(family, "Masculine");
        service.adoptChild(family, child);
        assertEquals(2, service.getFamilyById(0).getChildren().size());
    }

    @Test
    void countFamiliesWithMemberNumber() {
        Human child = new Man("Eli", "Eliyev", 2010, 99);
        family = service.createNewFamily(mother, father);
        service.bornChild(family, "Masculine");
        service.adoptChild(family, child);
        assertEquals(1, service.countFamiliesWithMemberNumber(4).size());
    }

    @Test
    void deleteChildOlderThan() {
        Human child = new Man("Eli", "Eliyev", 2010, 99);
        family = service.createNewFamily(mother, father);
        service.adoptChild(family, child);
        service.deleteAllChildrenOlderThan(10);
        assertEquals(0, service.getFamilyById(0).getChildren().size());
    }

    @Test
    void getFamiliesLessThanFour() {
        family = service.createNewFamily(mother, father);
        service.bornChild(family, "Masculine");
        assertEquals(1, service.getFamiliesLessThan(4).size());
    }

    @Test
    void getFamiliesBiggerThanTwo() {
        family = service.createNewFamily(mother, father);
        service.bornChild(family, "Masculine");
        assertEquals(1, service.getFamiliesBiggerThan(2).size());
    }



    @Test
    void countingFamilies() {
        family = service.createNewFamily(mother, father);
        assertEquals(1, service.count());
    }

    @Test
    void countingFamiliesWithSameMembers() {
        Family family1 = service.createNewFamily(mother, father);
        family = service.createNewFamily(mother, father);
        assertEquals(1, service.count());
    }

}
