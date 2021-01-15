package _00.models;

public abstract class Products {
    private int id ;
    private String idProduct;
    private String productName;
    private String productPrice;
    private String productAmount;
    private String producer;

    public Products(int id, String idProduct, String productName, String productPrice, String productAmount, String producer) {
        this.id = id;
        this.idProduct = idProduct;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productAmount = productAmount;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(String productAmount) {
        this.productAmount = productAmount;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
    public String showInfor(){
        System.out.println(this.toString());
        return this.toString();
    }

    @Override
    public String toString() {
        return  "Products{" +
                "id=" + id +
                ", idProduct='" + idProduct + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", productAmount='" + productAmount + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }
}
