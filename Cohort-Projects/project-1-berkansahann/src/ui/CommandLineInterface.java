package ui;

import service.RealEstateService;

import java.util.Scanner;

public class CommandLineInterface {
    static RealEstateService realEstateService = new RealEstateService();

    static Scanner scanner = new Scanner(System.in);

    // First method called by main
    public static void callMainInterface() {
        mainInterface();
    }

    // Main menu method
    private static void mainInterface() {
        System.out.println("Please select an option from this list:\n -1 Real Estates List Interface\n -2 Real Estates Price Interface\n -3 Real Estates Area Interface\n -4 Find Real Estates By Room and Living Room");
        switch (scanner.nextInt()) {
            case 1 -> listInterface();
            case 2 -> priceInterface();
            case 3 -> areaInterface();
            case 4 -> roomFilterInterface();
        }
    }

    // Real estates lists
    private static void listInterface() {
        System.out.println("Please select an option from this list:\n -1 All Real Estates\n -2 All Houses\n -3 All Summer Houses\n -4 All Villas");
        switch (scanner.nextInt()) {
            case 1 -> realEstateService.getRealEstateList();
            case 2 -> realEstateService.getHouseList();
            case 3 -> realEstateService.getSummerHouseList();
            case 4 -> realEstateService.getVillaList();
            default -> System.out.println("Invalid Value");
        }
    }

    // Total price lists
    private static void priceInterface() {
        System.out.println("Please select an option from this list:\n -1 All Real Estates Total Price\n -2 All Houses Total Price\n -3 All Summer Houses Total Price\n -4 All Villas Total Price");
        switch (scanner.nextInt()) {
            case 1 -> System.out.println(realEstateService.getTotalRealEstatePrice());
            case 2 -> System.out.println(realEstateService.getTotalHousePrice());
            case 3 -> System.out.println(realEstateService.getTotalSummerHousePrice());
            case 4 -> System.out.println(realEstateService.getTotalVillaPrice());
            default -> System.out.println("Invalid Value");
        }
    }

    // Average areas lists
    private static void areaInterface() {
        System.out.println("Please select an option from this list:\n -1 All Real Estates Average Area\n -2 All Houses Average Area\n -3 All Summer Houses Average Area\n -4 All Villas Average Area");
        switch (scanner.nextInt()) {
            case 1 -> System.out.println(realEstateService.getAverageRealEstateArea());
            case 2 -> System.out.println(realEstateService.getAverageHouseArea());
            case 3 -> System.out.println(realEstateService.getAverageSummerHouseArea());
            case 4 -> System.out.println(realEstateService.getAverageVillaArea());
            default -> System.out.println("Invalid Value");
        }
    }

    // Real estates lists filtered by room and living room count
    private static void roomFilterInterface() {
        System.out.println("Enter a room number: ");
        int roomCount = scanner.nextInt();
        System.out.println("Enter a living room number: ");
        int livingRoomCount = scanner.nextInt();
        realEstateService.filterRealEstateByRoomAndLivingRoom(roomCount, livingRoomCount);
    }
}