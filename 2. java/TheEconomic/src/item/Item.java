package item;

public class Item {
    private static Integer code = 0;
    private String name;
    private Integer unitsBought;
    private Double unitPrice;

    public Item(String name, Double unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.unitsBought = 0;
        code += 1;
    }
    public Item(String name, Double unitPrice, Integer unitsBought) {
        this.name = name;
        this.unitsBought = unitsBought;
        this.unitPrice = unitPrice;
        code += 1;
    }

    public Item getItem() {
        return this;
    }
    public Item updateName(String name) {
        this.name = name;
        return this;
    }
    public Item updateUnitsBought(Integer unitsBought) {
        this.unitsBought = unitsBought;
        return this;
    }
    public Item updateUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    public Integer getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public Integer getUnitsBought() {
        return unitsBought;
    }
    public Double getUnitPrice() {
        return unitPrice;
    }

    public String toString() {
        return "Item: " + name
            + "\nUnits Bought: " + unitsBought
            + " units.\nPrice for Unit: $ " + unitPrice
            + ".\nCode: " + code;
    }
}
