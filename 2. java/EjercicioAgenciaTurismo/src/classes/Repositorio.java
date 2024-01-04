package classes;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Repositorio {
    Map<String, List<Localizador>> localizadores;
    double descuentoTotal;
    public Repositorio() {
        this.localizadores = new HashMap<>();
        descuentoTotal = 0D;
    }

    public Boolean addLocalizadorByCliente(Localizador localizador){
        if(this.verificarPaqueteCompleto(localizador.getReservas())){
            this.descuentoTotal = 0.1D;
        }

        if(this.verificarDescuentoBoletoyHotel(localizador)){
            localizador.setTotal(localizador.getTotal() - (localizador.getTotal() * 0.05D));
        }

        if(localizadores.containsKey(localizador.cliente.getDni())){
            List<Localizador> localizadoresByClient = localizadores.get(localizador.cliente.getDni());
            if(localizadoresByClient.size() > 2){
                localizador.setTotal(localizador.getTotal() - (localizador.getTotal() * 0.05D));
            }
            localizadoresByClient.add(localizador);

            return Boolean.TRUE;
        }

        List<Localizador> listaLocalizadores = new ArrayList<>();
        listaLocalizadores.add(localizador);
        localizadores.put(localizador.cliente.getDni(), listaLocalizadores);
        return Boolean.TRUE;
    }

    private Boolean verificarPaqueteCompleto(List<Reserva> reservas){
        Set<Class<?>> instanciasEncontradas = new HashSet<>();
        for (Reserva reserva: reservas){
            instanciasEncontradas.add(reserva.getClass());
        }

        return instanciasEncontradas.size() == 4;
    }

    private Boolean verificarDescuentoBoletoyHotel(Localizador localizador){
        List<Reserva> listaDeBoletos = localizador.getReservas().stream().filter((reserva -> reserva instanceof Boleto)).toList();
        List<Reserva> listaDeHotel = localizador.getReservas().stream().filter(reserva -> reserva instanceof Hotel).toList();

        if(listaDeBoletos.size() >= 2 || listaDeHotel.size() >= 2){
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }


    public Integer getCantidadLocalizadores(){
        AtomicInteger totalLocalizadores = new AtomicInteger();
        localizadores.forEach((key, localizadorList) -> {
            totalLocalizadores.set(localizadorList.size());
        });

        return totalLocalizadores.intValue();
    }
    
    public Integer getTotalReservas(){
        AtomicInteger totalReservas = new AtomicInteger();
        localizadores.forEach((key, value) -> {
            totalReservas.addAndGet(value.stream().mapToInt((localizador -> localizador.getReservas().size())).sum());
        });

        return totalReservas.intValue();
    }

    public Double getTotalDeVentas(){
        AtomicInteger totalVentas = new AtomicInteger();
        localizadores.forEach((key, value) -> {
            totalVentas.addAndGet((int) value.stream().mapToDouble(Localizador::getTotal).sum());
        });

        return totalVentas.doubleValue() - (totalVentas.doubleValue() * descuentoTotal);
    }

    public Double getPromedioTotalDeVentas(){
        AtomicInteger sizeToAvg = new AtomicInteger();

        localizadores.forEach((key, value) -> {
            sizeToAvg.addAndGet(value.size());
        });

        return getTotalDeVentas() / sizeToAvg.doubleValue();
    }
}
