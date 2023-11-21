package hotel.dao;


import hotel.model.Pets;


public class HotelImpl implements Hotel {
    private Pets[] pets;
    private int capacity;
    private int count;

    public HotelImpl(int capacity) {
        this.capacity = capacity;
        this.pets = new Pets[capacity];
        this.count = 0;
    }


    @Override
    public boolean addPet(Pets pet) {
        if (count < capacity) {
            pets[count++] = pet;
            return true;
        }
        return false;
    }

    @Override
    public int qty() {
        return count;
    }

    @Override
    public Pets findPetById(int id) {
        for (Pets pet : pets) {
            if (pet != null && pet.getId() == id) {
                return pet;
            }
        }
        return null;
    }


    @Override
    public Pets removePet(int id) {
        for (int i = 0; i < count; i++) {
            if (pets[i] != null && pets[i].getId() == id) {
                Pets removedPet = pets[i];
                pets[i] = pets[count - 1];
                pets[count - 1] = null;
                count--;
                return removedPet;
            }
        }
        return null;
    }

    @Override
    public Pets[] findPetsByType(String type) {
        int typeCount = 0;
        for (Pets pet : pets) {
            if (pet != null && pet.getType().equalsIgnoreCase(type)) {
                typeCount++;
            }
        }
        if (typeCount == 0) {
            return null;
        }

        Pets[] result = new Pets[typeCount];
        int index = 0;
        for (Pets pet : pets) {
            if (pet != null && pet.getType().equalsIgnoreCase(type)) {
                result[index++] = pet;
            }
        }
        return result;
    }

    @Override
    public void printPets() {
        for (int i = 0; i < pets.length; i++) {
            if (pets[i] != null) {
                System.out.println(pets[i]);
            }
        }
    }

    @Override
    public double calcStayCost(int id, int days) {
        Pets pet = findPetById(id);
        if (pet != null) {
            double dailyRate = pet.getDailyRate();
            return dailyRate * days;
        }
        return 0;
    }

    @Override
    public double calcTotalRevenue() {
        double revenue = 0;
        for (Pets pet : pets) {
            if (pet != null) {
                revenue += pet.getDailyRate();
            }
        }
        return revenue;
    }


}
