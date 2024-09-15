package main;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Product {
    public String name;
    public int amount;
    public double price;

    public double getTotalPrice() {
        return amount * price;
    }

    @Override
    public String toString() {
        return name + " (" + amount + " x " + price + ")";
    }
}