package _00.models;

public class ExportProducts extends Products {
    private String priceExport;
    private String placeOfExport;

    public ExportProducts(int id, String idProduct, String productName, String productPrice, String productAmount, String producer, String priceExport, String placeOfExport) {
        super(id, idProduct, productName, productPrice, productAmount, producer);
        this.priceExport = priceExport;
        this.placeOfExport = placeOfExport;
    }

    public String getPriceExport() {
        return priceExport;
    }

    public void setPriceExport(String priceExport) {
        this.priceExport = priceExport;
    }

    public String getPlaceOfExport() {
        return placeOfExport;
    }

    public void setPlaceOfExport(String placeOfExport) {
        this.placeOfExport = placeOfExport;
    }
    public String showInfor(){
        System.out.println(toString());
        return this.toString();
    }

    @Override
    public String toString() {
        return  super.toString() +
                "ExportProducts{" +
                "priceExport='" + priceExport + '\'' +
                ", placeOfExport='" + placeOfExport + '\'' +
                '}';
    }
}
