package shop.dao;

import shop.model.Computer;

public interface Shop {
    boolean addComputer(Computer computer);
    Computer removeComputer(String barcode);
    Computer findComputer(String barcode);
    int quantity();
    double totalHdd();

    void printComputers();

    Computer[] findComputersWithDiscount();
}
