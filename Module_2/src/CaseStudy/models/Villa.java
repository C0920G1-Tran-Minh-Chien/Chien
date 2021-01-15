package CaseStudy.models;

public class Villa extends Services {
    private String typeVilla;
    private String otherService;
    private String poolArea;
    private String floors;

    public Villa(){}

    public Villa(String nameService, String area, String rentCost, String maxAmount, String rentType, String typeRoom,
                 String otherService, String poolArea, String floors) {
        super(nameService, area, rentCost, maxAmount, rentType);
        this.typeVilla = typeRoom;
        this.otherService = otherService;
        this.poolArea = poolArea;
        this.floors = floors;
    }

    public String getTypeRoom() {
        return typeVilla;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeVilla = typeRoom;
    }

    public String getOtherService() {
        return otherService;
    }

    public void setOtherService(String otherService) {
        this.otherService = otherService;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getFloors() {
        return floors;
    }

    public void setFloors(String floors) {
        this.floors = floors;
    }


    @Override
    public String toString() {
        return super.toString()  +
                "Standard Villa : " + typeVilla + '\n' +
                "Comfortable Description Villa : " + otherService + '\n' +
                "Floor Villa : " + floors + '\n' +
                "Area Pool Villa : " + poolArea
                + "\n --------------------------------\n";
    }

    @Override
    public String ShowInfor() {
        return this.toString();
    }
}
