package entity;

import static entity.RealEstateType.SUMMERHOUSE;

public class SummerHouse extends RealEstate {
    public SummerHouse(int area, int price, int room, int livingRoom) {
        super(area, price, room, livingRoom);
        setRealEstateType(SUMMERHOUSE);
    }
}
