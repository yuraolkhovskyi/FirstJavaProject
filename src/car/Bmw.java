package car;

public class Bmw extends Car{

    public Bmw(String model,String carIndex, double maxSpeed, double price, double fuelConsumption) {
        super(model,carIndex, maxSpeed, price, fuelConsumption);
    }


    @Override
    public String toString() {
        return "BMW";
    }
}
