package CaseStudy.models;

public class House  extends Services {
    private String typeRoom;
    private String otherService;
    private String floors;

    public House(String nameService, String area, String rentCost, String maxAmount, String rentType, String typeRoom, String otherService, String floors) {
        super( nameService, area, rentCost, maxAmount, rentType);
        this.typeRoom = typeRoom;
        this.otherService = otherService;
        this.floors = floors;
    }


    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    public String getOtherService() {
        return otherService;
    }

    public void setOtherService(String otherService) {
        this.otherService = otherService;
    }

    public String getFloors() {
        return floors;
    }

    public void setFloors(String floors) {
        this.floors = floors;
    }

    @Override
    public String ShowInfor() {
        return this.toString();
    }
}
