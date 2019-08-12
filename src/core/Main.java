package core;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static TaxoPark park = new TaxoPark();

    public static void main(String[] args) {
        String command;
        System.out.println("Write 'help' for getting information");
        while(true){
            System.out.println("Enter your command:");
            command=scanner.nextLine();
            switch (command.toLowerCase()){
                case "help": park.fileCommands(); break;
                case "show_info": park.showInfo(); break;
                case "add_car": park.readInfo(); break;
                case "cost_taxopark": park.costTaxopark(); break;
                case "find_by_speed": park.findBySpeed(); break;
                case "sorted_cars": park.sortedCars(); break;
                case "read_from_file": park.readFromFile(); break;
                case "delete_all": park.deleteAll(); break;
                case "delete_car": park.deleteOneCar(); break;
                case "exit": return;
                default:
                    System.out.println("Your command is incorrect, please try again");
            }
        }
    }
}
