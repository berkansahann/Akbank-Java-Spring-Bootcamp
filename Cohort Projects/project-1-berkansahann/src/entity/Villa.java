package entity;

import static entity.RealEstateType.VILLA;

public class Villa extends RealEstate {
    public Villa(int area, int price, int room, int livingRoom) {
        super(area, price, room, livingRoom);
        setRealEstateType(VILLA);
    }
}
