package car;

public abstract class Car implements Comparable<Car> {
    private String carIndex;
    private String model;
    private double maxSpeed;
    private double price;
    private double fuelConsumption;


    public Car(String model,String carIndex, double maxSpeed, double price, double fuelConsumption) {
        this.model=model;
        this.carIndex = carIndex;
        this.maxSpeed = maxSpeed;
        this.price = price;
        this.fuelConsumption = fuelConsumption;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public String getCarIndex() {
        return carIndex;
    }

    public void setCarIndex(String carIndex) {
        this.carIndex = carIndex;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }
    @Override
    public int compareTo(Car o) {
        if (this.fuelConsumption > o.fuelConsumption)
            return 1;
        else if (this.fuelConsumption < o.fuelConsumption)
            return -1;
        else
            return 0;
    }
    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }


}

