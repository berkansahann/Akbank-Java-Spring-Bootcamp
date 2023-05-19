package entity;

import static entity.RealEstateType.HOUSE;

public class House extends RealEstate {
    public House(int area, int price, int room, int livingRoom) {
        super(area, price, room, livingRoom);
        setRealEstateType(HOUSE);

    }
}
