package CaseStudy.models;

public class Room extends Services{
    String accompaniedService ;
    public Room( String nameService, String area, String rentCost, String maxAmount, String rentType, String accompaniedService) {
        super(nameService, area, rentCost, maxAmount, rentType);
        this.accompaniedService = accompaniedService;
    }

    @Override
    public String ShowInfor() {
        return this.toString();
    }

    public String getAccompaniedService() {
        return accompaniedService;
    }

    public void setAccompaniedService(String accompaniedService) {
        this.accompaniedService = accompaniedService;
    }


}
