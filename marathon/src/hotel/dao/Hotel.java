package hotel.dao;

import hotel.model.Pets;

public interface Hotel {
    boolean addPet(Pets pet);

    Pets findPetById(int id);

    int qty();

    Pets removePet(int id);

    Pets[] findPetsByType(String type);

    void printPets();

    double calcStayCost(int id, int days);

    double calcTotalRevenue();
}
