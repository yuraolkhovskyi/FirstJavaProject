package core;

import car.Audi;
import car.Bmw;
import car.Car;

import java.io.*;
import java.util.*;

public class TaxoPark {

    private Scanner scanner = new Scanner(System.in);
    private List<Car> cars = new ArrayList<>();
    private double total;

    public void fileCommands() {
        System.out.println("show_info\n" +
                "add_car \n" +
                "cost_taxopark\n" +
                "find_by_speed\n" +
                "sorted_cars\n" +
                "read_from_file\n" +
                "delete_all\n" +
                "delete_car\n" +
                "exit");
    }

    public void readInfo() {
        System.out.println("Please, enter your data in this sequence: type(Audi or Bmw), model, car index, price, fuel consumption,max speed");
        try {
            String[] info = scanner.nextLine().split(" ");
            addCar(info[0], info[1], info[2], Double.parseDouble(info[3]), Double.parseDouble(info[4]), Double.parseDouble(info[5]));
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("You've entered incorrect data");
        }
    }

    public void addCar(String type, String model, String carIndex, double price, double fuelConsumption, double maxSpeed) {
        Car car;
        if (type.toLowerCase().equals("audi")) {
            car = new Audi(model, carIndex, maxSpeed, price, fuelConsumption);
        } else if ((type.toLowerCase().equals("bmw"))) {
            car = new Bmw(model, carIndex, maxSpeed, price, fuelConsumption);
        } else {
            System.out.println("Please, enter audi or bwm");
            return;
        }
        total += price;
        cars.add(car);
        System.out.println("successfully added");
    }

    public void showInfo() {
        if (cars.isEmpty()) {
            System.out.println("You haven't added any cars yet");
            return;
        }
        System.out.println("Type\t\t\tModel\t\t\tCarIndex\t\t\tprice\t\t\tfuelConsumption\t\t\tmaxSpeed");
        for (Car car : cars) {
            System.out.printf("%-16s",car.toString());
            System.out.printf("%-16s", car.getModel());
            System.out.printf("%-20s", car.getCarIndex());
            System.out.printf("%-16.2f", car.getPrice());
            System.out.printf("%-24.2f", car.getFuelConsumption());
            System.out.printf("%-10.2f\n", car.getMaxSpeed());
        }
        System.out.println();
    }

    public void costTaxopark() {
        if (total == 0)
            System.out.println("Your taxopark is empty");
        else
            System.out.println("The cost of your cars is " + total);
    }

    public void findBySpeed() {
        double first, last;
        int  counter=0;
        System.out.println("Enter speed:");
        first = scanner.nextDouble();
        last = scanner.nextDouble();
        scanner.nextLine();
        for (Car car : cars) {
            if (car.getMaxSpeed() >= first && car.getMaxSpeed() <= last)
                counter++;
                forFindBySpeed(car,counter);
        }
        if(counter==0){
            System.out.println("There is no such car");
        }

    }


    public void forFindBySpeed(Car theCar,int counter) {
        if(counter==1)
            System.out.println("Type\t\t\tModel\t\t\tCarIndex\t\t\tprice\t\t\tfuelConsumption\t\t\tmaxSpeed");
        for (Car car : cars) {
            if (car.equals(theCar)) {
                System.out.printf("%-16s", car.toString());
                System.out.printf("%-16s", car.getModel());
                System.out.printf("%-20s", car.getCarIndex());
                System.out.printf("%-16.2f", car.getPrice());
                System.out.printf("%-24.2f", car.getFuelConsumption());
                System.out.printf("%-10.2f\n", car.getMaxSpeed());
            }
        }
    }

    public void sortedCars() {
        if (cars.isEmpty()){
            System.out.println("Your list is empty, please add some cars");return;
    }
        else
            Collections.sort(cars);
            System.out.println("successfully sorted");
    }

    public void readFromFile() {
        System.out.println("Enter the path or name of your file:");
        String filename = scanner.nextLine();
        List<Car> old = cars;
        try (BufferedReader br = new BufferedReader(new FileReader(new File(filename)))) {
            String line;
            cars = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                addCar(parts[0], parts[1], parts[2],
                        Double.parseDouble(parts[3]),
                        Double.parseDouble(parts[4]),
                        Double.parseDouble(parts[5]));
            }
        } catch (IOException e) {
            cars = old;
            System.out.println("Could not parse the file");
        }
    }

    public void deleteAll() {
        if (cars.isEmpty()) {
            System.out.println("Your list is empty, please add some cars");
            return;
        }
        else
            cars.clear();
            System.out.println("All the objects successfully deleted");
    }

    public void deleteOneCar() {
        if(cars.isEmpty()) {
            System.out.println("You haven't added any cars yet");
        }
        else {
            System.out.println("Enter the index of car you want to delete");
            String line = scanner.nextLine();
            int counter = 0;
                for (Car car : cars) {
                    if (car.getCarIndex().equals(line)) {
                        cars.remove(car);
                        counter++;
                        System.out.println("Successfully deleted");
                        return;
                    }
                }
                if(counter==0) System.out.println("There is no such car in the taxopark");
        }
    }
}
