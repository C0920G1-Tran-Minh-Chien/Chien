package _00.models;

public class ImportProducts extends Products {
    private String importPrice;
    private String placeOfImport;
    private String importTax;

    public ImportProducts(int id, String idProduct, String productName, String productPrice, String productAmount,
                          String producer, String importPrice, String placeOfImport, String importTax) {
        super(id, idProduct, productName, productPrice, productAmount, producer);
        this.importPrice = importPrice;
        this.placeOfImport = placeOfImport;
        this.importTax = importTax;
    }

    public String getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(String importPrice) {
        this.importPrice = importPrice;
    }

    public String getPlaceOfImport() {
        return placeOfImport;
    }

    public void setPlaceOfImport(String placeOfImport) {
        this.placeOfImport = placeOfImport;
    }

    public String getImportTax() {
        return importTax;
    }

    public void setImportTax(String importTax) {
        this.importTax = importTax;
    }

    public String showInfor(){
        System.out.println(this.toString());
        return null;
    }


    @Override
    public String toString() {
        return  super.toString() +
                "ImportProducts{" +
                "importPrice='" + importPrice + '\'' +
                ", placeOfImport='" + placeOfImport + '\'' +
                ", importTax='" + importTax + '\'' +
                '}';
    }
}
