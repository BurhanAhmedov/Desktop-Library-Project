package Model;

public class Book extends LibraryModel {

    private String Name;
    private Float PurchasePrice;
    private Float SalePrice;
    private Integer Page;
    private Integer Stock;
    private Float Profit;
    private Integer Discount;

    public Float getProfit() {
        return Profit;
    }

    public Integer getDiscount() {
        return Discount;
    }

    public void setDiscount(Integer Discount) {
        this.Discount = Discount;
    }

    public void setProfit(Float Profit) {
        this.Profit = Profit;
    }

    public Float getPurchasePrice() {
        return PurchasePrice;
    }

    public void setPurchasePrice(Float purchasePrice) {
        PurchasePrice = purchasePrice;
    }

    public Integer getStock() {
        return Stock;
    }

    public void setStock(Integer stock) {
        Stock = stock;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public Float getSalePrice() {
        return SalePrice;
    }

    public void setSalePrice(Float SalePrice) {
        this.SalePrice = SalePrice;
    }

    public Integer getPage() {
        return Page;
    }

    public void setPage(Integer page) {
        this.Page = page;
    }

    @Override
    public String toString() {
        return Name;
    }

}
