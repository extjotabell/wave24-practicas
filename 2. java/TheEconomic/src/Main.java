import bill.Bill;
import customer.Customer;
import item.Item;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Customer customer = new Customer("John", "Doe");
        Item item1 = new Item("Item 1", 10.0, 1);
        Bill bill1 = new Bill(customer, List.of(item1));
        bill1.addItem(new Item("Item 2", 20.0, 2));

        //bill1.updateItemByCode(2, new Item("Item 2", 20.0, 2));
        bill1.removeItemByCode(2);

        System.out.println(bill1.toString());
    }
}