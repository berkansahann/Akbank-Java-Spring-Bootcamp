package service;

import entity.*;

import java.util.ArrayList;
import java.util.List;

import static service.RealEstateGenerator.realEstateCreate;

public class RealEstateService {
    private final List<RealEstate> realEstateList = realEstateCreate();
    private final List<House> houseList = new ArrayList<>();
    private final List<SummerHouse> summerHouseList = new ArrayList<>();
    private final List<Villa> villaList = new ArrayList<>();
    int totalPrice;
    double totalArea;

    // Construct of Real Estate Service
    public RealEstateService() {
        fillListsByRealEstateType(realEstateList);
    }

    // Take all real estates and separates this list by types
    private <T extends RealEstate> void fillListsByRealEstateType(List<T> realEstateList) {
        for (T realEstate : realEstateList) {
            RealEstateType realEstateType = realEstate.getRealEstateType();
            if (realEstateType == RealEstateType.HOUSE) {
                houseList.add((House) realEstate);
            } else if (realEstateType == RealEstateType.SUMMERHOUSE) {
                summerHouseList.add((SummerHouse) realEstate);
            } else if (realEstateType == RealEstateType.VILLA) {
                villaList.add((Villa) realEstate);
            } else {
                System.out.println("Invalid Real Estate Type");
            }
        }
    }

    public void getRealEstateList() {
        for (RealEstate realEstate : realEstateList) {
            System.out.println(realEstate.toString());
        }
    }

    public void getHouseList() {
        for (House house : houseList) {
            System.out.println(house.toString());
        }
    }

    public void getSummerHouseList() {
        for (SummerHouse summerHouse : summerHouseList) {
            System.out.println(summerHouse.toString());
        }
    }

    public void getVillaList() {
        for (Villa villa : villaList) {
            System.out.println(villa.toString());
        }
    }

    public int getTotalRealEstatePrice() {
        totalPrice = 0;
        for (RealEstate realEstate : realEstateList) {
            totalPrice += realEstate.getPrice();
        }
        return totalPrice;
    }

    public int getTotalHousePrice() {
        totalPrice = 0;
        for (House house : houseList) {
            totalPrice += house.getPrice();
        }
        return totalPrice;
    }

    public int getTotalSummerHousePrice() {
        totalPrice = 0;
        for (SummerHouse summerHouse : summerHouseList) {
            totalPrice += summerHouse.getPrice();
        }
        return totalPrice;
    }

    public int getTotalVillaPrice() {
        totalPrice = 0;
        for (Villa villa : villaList) {
            totalPrice += villa.getPrice();
        }
        return totalPrice;
    }

    public double getAverageRealEstateArea() {
        totalArea = 0;
        for (RealEstate realEstate : realEstateList) {
            totalArea += realEstate.getArea();
        }
        return totalArea / realEstateList.size();
    }

    public double getAverageHouseArea() {
        totalArea = 0;
        for (House house : houseList) {
            totalArea += house.getArea();
        }
        return totalArea / houseList.size();
    }

    public double getAverageSummerHouseArea() {
        totalArea = 0;
        for (SummerHouse summerHouse : summerHouseList) {
            totalArea += summerHouse.getArea();
        }
        return totalArea / summerHouseList.size();
    }

    public double getAverageVillaArea() {
        totalArea = 0;
        for (Villa villa : villaList) {
            totalArea += villa.getArea();
        }
        return totalArea / villaList.size();
    }

    // Takes parameters and filter real estates by requested room and living room count
    public void filterRealEstateByRoomAndLivingRoom(int roomCount, int livingRoomCount) {
        for (RealEstate realEstate : realEstateList) {
            if (realEstate.getRoom() == roomCount && realEstate.getLivingRoom() == livingRoomCount) {
                System.out.println(realEstate);
            }
        }
    }
}
