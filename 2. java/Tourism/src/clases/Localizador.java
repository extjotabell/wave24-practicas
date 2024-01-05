package clases;

import interfaces.Descuentos;

import java.util.ArrayList;
import java.util.List;

public class Locator implements Descuentos {
    String customerName;
    List<ReservaBase> reservations = new ArrayList<>();

    public Locator(String customerName) {
        this.customerName = customerName;
    }
    public void addReservation(ReservaBase reservation) {
        reservations.add(reservation);
    }
    public double calculateTotal() {
        double total = 0;
        for (ReservaBase reservation : reservations) {
            total += reservation.price;
        }
        return total;
    }
    @Override
    public void applyDiscounts() {
        int numberOfLocators = CustomerRepository.getNumberOfLocators(customerName);

        if (numberOfLocators >= 2) {
            double discount = calculateTotal() * 0.05;
            System.out.println("Descuento del 5% aplicado por tener al menos 2 localizadores anteriores: $" + discount);
        }
        if (containsCompletePackage()) {
            double discount = calculateTotal() * 0.10;
            System.out.println("Descuento del 10% aplicado por adquirir un paquete completo");
        }
        if (containsTwoHotelReservations() || containsTwoTravelTickets()) {
            double discount = calculateTotal() * 0.05;
            System.out.println("Descuento del 5% aplicado por adquirir 2 reservas de hotel o 2 boletos de viaje");
        }
    }
    private boolean containsCompletePackage() {
        // Logic to check if it contains a complete package
        // You can customize this logic based on real requirements
        return reservations.size() >= 4;
    }

}
