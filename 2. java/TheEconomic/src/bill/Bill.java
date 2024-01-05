package bill;

import customer.Customer;
import item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bill {
    private static Integer id = 0;
    private Customer customer;
    private List<Item> items;
    private Double total;

    public Bill(Customer customer) {
        this.customer = customer;
        this.items = null;
        this.total = 0.0;
        id += 1;
    }
    public Bill(Customer customer, List<Item> items) {
        this.customer = customer;
        this.items = items;
        this.total = items.stream().mapToDouble(Item::getUnitPrice).sum();
        id += 1;
    }

    public Bill getBill() {
        return this;
    }
    public List<Item> addItem(Item item) {
        if (items == null)
            items = new ArrayList<>();

        items.add(item);

        total += item.getUnitPrice();

        return items;
    }
    public Bill updateCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }
    public Bill updateItems(List<Item> items) {
        this.items = items;
        this.total = items.stream().mapToDouble(Item::getUnitPrice).sum();

        return this;
    }
    public List<Item> updateItemByCode(Integer code, Item item) {
        var itemToUpdate = items
                .stream()
                .filter(i -> Objects.equals(i.getCode(), code))
                .findFirst()
                .orElse(null);
        
        if (itemToUpdate != null) {
            itemToUpdate.updateName(item.getName());
            itemToUpdate.updateUnitsBought(item.getUnitsBought());
            itemToUpdate.updateUnitPrice(item.getUnitPrice());
        }

        var newItems = items.stream().map(i -> {
            if (Objects.equals(i.getCode(), code))
                return itemToUpdate;

            return i;
        }).toList();

        this.total = newItems.stream().mapToDouble(Item::getUnitPrice).sum();

        return newItems;
    }
    public List<Item> removeItemByCode(Integer code) {
        var itemsFiltered = items
                .stream()
                .filter(i -> !i.getCode().equals(code)).toList();

        this.total = itemsFiltered.stream().mapToDouble(Item::getUnitPrice).sum();

        return itemsFiltered;
    }

    public Integer getId() {
        return id;
    }
    public Customer getCustomer() {
        return customer;
    }
    public List<Item> getItems() {
        return items;
    }
    public Double getTotal() {
        return total;
    }

    public String toString() {
        return "Bill: " + customer
            + "\nItems: " + items
            + "\nTotal: $" + total
            + ".\nID: " + id;
    }
}
