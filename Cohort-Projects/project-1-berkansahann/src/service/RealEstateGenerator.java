package service;

import entity.House;
import entity.RealEstate;
import entity.SummerHouse;
import entity.Villa;

import java.util.ArrayList;
import java.util.List;

public class RealEstateGenerator {

    // Generates real estates
    public static List<RealEstate> realEstateCreate() {
        List<RealEstate> realEstateList = new ArrayList<>();

        realEstateList.add(new House(11, 1, 1, 1));
        realEstateList.add(new House(21, 2, 2, 1));
        realEstateList.add(new House(31, 3, 1, 1));
        realEstateList.add(new SummerHouse(41, 4, 1, 1));
        realEstateList.add(new SummerHouse(51, 5, 1, 1));
        realEstateList.add(new SummerHouse(61, 6, 1, 1));
        realEstateList.add(new Villa(71, 7, 1, 1));
        realEstateList.add(new Villa(81, 8, 1, 1));
        realEstateList.add(new Villa(91, 9, 1, 1));

        return realEstateList;
    }
}
