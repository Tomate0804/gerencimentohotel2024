import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Quartos> quartos;
    private List<Reserva> reservas;

    public Hotel() {
        this.quartos = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void cadastrarQuarto(Quartos quarto) {
        quartos.add(quarto);
    }

    public void cadastrarReserva(Reserva reserva) {
        reservas.add(reserva);
        atualizarDisponibilidadeQuartos(reserva.getTipoQuarto(), reserva.getNumeroQuartos(), false);
    }

    public void registrarCheckIn(String nomeHospede) {
        for (Reserva reserva : reservas) {
            if (reserva.getNomeHospede().equals(nomeHospede)) {
                atualizarDisponibilidadeQuartos(reserva.getTipoQuarto(), reserva.getNumeroQuartos(), false);
                System.out.println("Check-in realizado para " + nomeHospede);
                return;
            }
        }
        System.out.println("Reserva não encontrada.");
    }

    public void registrarCheckOut(String nomeHospede) {
        for (Reserva reserva : reservas) {
            if (reserva.getNomeHospede().equals(nomeHospede)) {
                atualizarDisponibilidadeQuartos(reserva.getTipoQuarto(), reserva.getNumeroQuartos(), true);
                System.out.println("Check-out realizado para " + nomeHospede);
                return;
            }
        }
        System.out.println("Reserva não encontrada.");
    }

    private void atualizarDisponibilidadeQuartos(String tipoQuarto, int quantidade, boolean disponivel) {
        int contador = 0;
        for (Quartos quarto : quartos) {
            if (quarto.getTipo().equals(tipoQuarto) && quarto.isDisponivel() != disponivel) {
                quarto.setDisponivel(disponivel);
                contador++;
                if (contador == quantidade) break;
            }
        }
    }

    public void gerarRelatorioOcupacao() {
        for (Quartos quarto : quartos) {
            String status = quarto.isDisponivel() ? "Disponível" : "Ocupado";
            System.out.println("Quarto " + quarto.getNumero() + " (" + quarto.getTipo() + "): " + status);
        }
    }

    public void gerarHistoricoReservas(String nomeHospede) {
        for (Reserva reserva : reservas) {
            if (reserva.getNomeHospede().equals(nomeHospede)) {
                System.out.println("Reserva: Quarto " + reserva.getTipoQuarto() +
                        ", Check-in: " + reserva.getDataCheckIn() +
                        ", Check-out: " + reserva.getDataCheckOut());
            }
        }
    }
}