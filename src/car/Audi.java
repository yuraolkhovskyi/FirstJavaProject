package car;

public class Audi extends Car{
    public Audi(String model,String carIndex, double maxSpeed, double price, double fuelConsumption) {
        super(model,carIndex, maxSpeed, price, fuelConsumption);
    }

    @Override
    public String toString() {
        return "Audi";
    }
}
