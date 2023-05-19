package entity;

public abstract class RealEstate {
    private final int area;
    private final int price;
    private final int room;
    private final int livingRoom;
    private RealEstateType realEstateType;

    // Main real estate constructor
    public RealEstate(int area, int price, int room, int livingRoom) {
        this.area = area;
        this.price = price;
        this.room = room;
        this.livingRoom = livingRoom;
    }

    @Override
    public String toString() {
        return realEstateType +
                ", Area:" + area +
                ", Price:" + price +
                ", Room:" + room +
                ", LivingRoom:" + livingRoom;
    }

    public RealEstateType getRealEstateType() {
        return realEstateType;
    }

    public void setRealEstateType(RealEstateType realEstateType) {
        this.realEstateType = realEstateType;
    }

    public int getPrice(){
        return price;
    }

    public double getArea(){
        return area;
    }

    public int getRoom(){
        return room;
    }

    public int getLivingRoom(){
        return livingRoom;
    }

}
