package Dao;

import Abstracts.Family;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {
    private final List<Family> families = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies() {
        return families;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        if (families.get(index) != null) return families.get(index);
        else return null;
    }

    @Override
    public boolean deleteFamily(int index) {
        if (index < families.size() && index >= 0) {
            families.remove(families.get(index));
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteFamily(Family family) {
        this.families.remove(family);
        return true;
    }

    @Override
    public void saveFamily(Family family) {
        if (families.contains(family)) families.set(families.indexOf(family), family);
        else families.add(family);
    }
}
