package CaseStudy.models;

public abstract class Services {

    private String nameService ;
    private String Area ;
    private String rentCost ;
    private String maxAmount ;
    private String rentType ;

    public Services( String nameService, String area, String rentCost, String maxAmount, String rentType) {
        this.nameService = nameService;
        this.Area = area;
        this.rentCost = rentCost;
        this.maxAmount = maxAmount;
        this.rentType = rentType;
    }

    public Services() {

    }


    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public String getRentCost() {
        return rentCost;
    }

    public void setRentCost(String rentCost) {
        this.rentCost = rentCost;
    }

    public String getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(String maxAmount) {
        this.maxAmount = maxAmount;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public abstract String ShowInfor();


    @Override
    public String toString() {
        return  "Name Services : " + nameService + '\n' +
                "Area Services : " + Area + '\n' +
                "Cost Services : " + rentCost + '\n' +
                "Quantity Included : " + maxAmount + '\n' +
                "Rental Type : " + rentType + '\n'

                ;
    }
}
