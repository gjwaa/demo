package bean;

public class ProductInfo {
    private String productName;
    private int productTypeID;
    private String productImg;
    private String introduce;
    private int stateID;
    private String startPrice;
    private String strikePrice;
    private String newPrice;

    public ProductInfo() {
    }

    public ProductInfo(String productName, int productTypeID, String productImg, String introduce, int stateID, String startPrice, String strikePrice, String newPrice) {
        this.productName = productName;
        this.productTypeID = productTypeID;
        this.productImg = productImg;
        this.introduce = introduce;
        this.stateID = stateID;
        this.startPrice = startPrice;
        this.strikePrice = strikePrice;
        this.newPrice = newPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductTypeID() {
        return productTypeID;
    }

    public void setProductTypeID(int productTypeID) {
        this.productTypeID = productTypeID;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getStateID() {
        return stateID;
    }

    public void setStateID(int stateID) {
        this.stateID = stateID;
    }

    public String getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(String startPrice) {
        this.startPrice = startPrice;
    }

    public String getStrikePrice() {
        return strikePrice;
    }

    public void setStrikePrice(String strikePrice) {
        this.strikePrice = strikePrice;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "productName='" + productName + '\'' +
                ", productTypeID=" + productTypeID +
                ", productImg='" + productImg + '\'' +
                ", introduce='" + introduce + '\'' +
                ", stateID=" + stateID +
                ", startPrice='" + startPrice + '\'' +
                ", strikePrice='" + strikePrice + '\'' +
                ", newPrice='" + newPrice + '\'' +
                '}';
    }
}
