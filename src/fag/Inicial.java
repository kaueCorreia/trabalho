package fag;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fag.objetos.Quartos;
import fag.objetos.Reserva;

public class Inicial {
    
    static Scanner scanner = new Scanner(System.in);
    static List<Quartos> listaQuartos = new ArrayList<Quartos>();
    static List<Reserva> listaReserva = new ArrayList<Reserva>();
    
    public static void main(String[] args) {
        menu();
    }
    
    public static void menu() {
        boolean menu = true;
        
        while (menu) {
            System.out.println("digite o número da opção que você deseja selecionar: \n");
            System.out.println("1 - Cadastrar os quartos \n"
                    + "2 - reservas\n"
                    + "3 - check-in \n"
                    + "4 - check-out\n"
                    + "5 - histórico de hóspedes\n"
                    + "6 - sair\n");
            
            int escolha = scanner.nextInt();
            
            switch (escolha) {
                case 1:
                    cadastroQuartos();
                    break;
                case 2:
                    cadastroReservas();
                    break;
                case 3:
                    fazerCheckin();
                    break;
                case 4:
                    fazerCheckout();
                    break;
                case 5:
                    RelatorioOcupacao();
                    break;
                case 6:
                    menu = false;
                    break;
                default:
                    System.out.println("opção inválida");
                    break;
            }
        }
    }
    
    public static void cadastroQuartos() {
        System.out.println("digite quantos quartos serão adicionados: \n");
        int quantidade = scanner.nextInt();
        
        for (int i = 0; i < quantidade; i++) {
            System.out.println("digite o número do quarto: \n");
            Integer numeroQuarto = scanner.nextInt();
        
            System.out.println("digite o tipo do quarto: (solteiro, suíte, casal)");
            String tipoQuarto = scanner.next();
            
            System.out.println("digite o preço da reserva do quarto:");
            Double preco = scanner.nextDouble();
            
            Boolean disponibilidade = true; 
            
            listaQuartos.add(new Quartos(numeroQuarto, tipoQuarto, preco, disponibilidade));
        }
    }
    
    public static void cadastroReservas() {
        System.out.println("cadastro de reserva: \n \n");
        
        System.out.println("come do hóspede:");
        String nomeHospede = scanner.next();
        System.out.println("tipo de quarto (Solteiro, Casal, Suíte):");
        String tipoQuarto = scanner.next();
        System.out.println("data de check-in (dia/mes/ano):");
        String checkIn = scanner.next();
        System.out.println("data de check-out (dia/mes/ano):");
        String checkOut = scanner.next();
        
        boolean quartoDisponivel = false; 
        
        for (Quartos quartos : listaQuartos) {
            if (quartos.tipoQuarto.equalsIgnoreCase(tipoQuarto) && quartos.Disponibilidade) {
                listaReserva.add(new Reserva(nomeHospede, tipoQuarto, checkIn, checkOut, quartos.numeroQuarto));
                quartos.Disponibilidade = false; 
                quartoDisponivel = true; 
                System.out.println("reserva realizada com sucesso!");
                break; 
            }
        }
        
        if (!quartoDisponivel) {
            System.out.println("desculpe, não há quartos disponíveis desse tipo.");
        }
    }
    
    //checkin e checkout não estava rodando, usei chatgpt pra arrumar
    //variavel boolean foi criado por ele "found"  
    public static void fazerCheckin() {
        System.out.println("digite o nome do hóspede: \n");
        String nome = scanner.next();
        
        boolean found = false;
        
        for (Reserva reserva : listaReserva) {
            if (reserva.nomeHospede.equalsIgnoreCase(nome)) {
                System.out.println("check-in realizado para " + nome + " no quarto " + reserva.numeroQuarto);
                found = true; 
                break; 
            }
        }
        
        if (!found) {
            System.out.println("reserva não encontrada para o hóspede: " + nome);
        }
    }

    public static void fazerCheckout() {
        System.out.println("Digite o nome do hóspede: \n");
        String nome2 = scanner.next();
        
        boolean found = false; 
        

        List<Reserva> reservasRemover = new ArrayList<>();
        
        for (Reserva reserva : listaReserva) {
            if (reserva.nomeHospede.equalsIgnoreCase(nome2)) {
                System.out.println("Checkout feito com sucesso para " + nome2);
                found = true; 
                

                for (Quartos quarto : listaQuartos) {
                    if (quarto.numeroQuarto.equals(reserva.numeroQuarto)) {
                        quarto.Disponibilidade = true;  
                        break;  
                    }
                }
                reservasRemover.add(reserva); 
            }
        }
        

        listaReserva.removeAll(reservasRemover);
        
        if (!found) {
            System.out.println("reserva não encontrada para o hóspede: " + nome2);
        }
    }

    public static void RelatorioOcupacao() {
        System.out.println("relatório de Ocupação de Quartos:");
        if (listaReserva.isEmpty()) {
            System.out.println("nenhuma reserva encontrada.");
            return;
        }
        
        for (Reserva reserva : listaReserva) {
            System.out.println("quarto " + reserva.numeroQuarto + " (" + reserva.tipoQuarto + ") ocupado por " + reserva.nomeHospede 
                               + " de " + reserva.checkin + " até " + reserva.checkout);
        }
    }
}
