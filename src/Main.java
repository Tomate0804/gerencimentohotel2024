import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        // Exemplo de cadastro de quartos
        hotel.cadastrarQuarto(new Quartos(101, "solteiro", 100.0, true));
        hotel.cadastrarQuarto(new Quartos(102, "casal", 150.0, true));
        hotel.cadastrarQuarto(new Quartos(103, "suite", 250.0, true));

        // Exemplo de cadastro de reservas
        hotel.cadastrarReserva(new Reserva("João Silva", LocalDate.now(), LocalDate.now().plusDays(3), 1, "casal"));

        // Menu de operações
        while (true) {
            System.out.println("1. Check-in\n2. Check-out\n3. Relatório de Ocupação\n4. Histórico de Reservas\n5. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.println("Nome do hóspede para check-in:");
                    String hospedeCheckIn = scanner.nextLine();
                    hotel.registrarCheckIn(hospedeCheckIn);
                    break;
                case 2:
                    System.out.println("Nome do hóspede para check-out:");
                    String hospedeCheckOut = scanner.nextLine();
                    hotel.registrarCheckOut(hospedeCheckOut);
                    break;
                case 3:
                    hotel.gerarRelatorioOcupacao();
                    break;
                case 4:
                    System.out.println("Nome do hóspede:");
                    String nomeHospede = scanner.nextLine();
                    hotel.gerarHistoricoReservas(nomeHospede);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}