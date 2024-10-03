import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
      
        ContaCorrente contaCorrente = new ContaCorrente(1000, 18);
        contaCorrente.deposita(220);
        contaCorrente.enviaPix(250, "513597-2300");
        contaCorrente.saca(100);
        
        
        try{
            contaCorrente.deposita(-50);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        char opcao;
        do {
            System.out.println("Menu:");
            System.out.println("P. Adicionar chave Pix");
            System.out.println("R. Remover chave Pix");
            System.out.println("E. Exibir chaves Pix");
            System.out.println("S. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.next().charAt(0);;
            scanner.nextLine(); 

            switch (opcao) {
                case 'P':
                    System.out.print("Digite a chave Pix para adicionar: ");
                    String novaChave = scanner.nextLine();
                    System.out.print("Digite o tipo da chave (CPF, e-mail,Telefone): ");
                    String tipoChave = scanner.nextLine();
                    contaCorrente.adicionarChavePix(novaChave, tipoChave);
                    System.out.println("Chave Pix adicionada!");
                    break;

                case 'R':
                    System.out.print("Digite a chave Pix para remover: ");
                    String chaveRemover = scanner.nextLine();
                    contaCorrente.removerChavePix(chaveRemover);
                    System.out.println("Chave Pix removida!");
                    break;

                case 'E':
                    contaCorrente.exibirChavesPix();
                    break;

                case 'S':
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
            System.out.println();
        } while (opcao != 'S');

        scanner.close();
    

        contaCorrente.adicionarChavePix("03444348002", "CPF");
        contaCorrente.adicionarChavePix("gustavomaciel.p@ienh.com.br", "e-mail");

        contaCorrente.exibirChavesPix();
        contaCorrente.removerChavePix("03444348002");
        
        contaCorrente.exibirChavesPix();

        if(contaCorrente.getSaldo() > 0){
            System.out.println("Seu saldo é R$: \u001B[42m" + contaCorrente.getSaldo() + "\u001B[0m");
        } else { if(contaCorrente.getSaldo() < 0){
            System.out.println("Seu saldo é R$:\u001B[41m" + contaCorrente.getSaldo() + "\u001B[0m");
        }
    }
    }

        /* vermelho: \u001B[41m*/
        /* verde: \u001B[42m */

    public static void printSaldo(ContaCorrente contaCorrente) {
        String cor = contaCorrente.getCor();
        String vermelho = "";
        String verde = "";


        if (cor.equals("vermelho")) {
            // Código ANSI para adicionar a cor vermelha ao semáforo Semaforo.java
            vermelho = "\u001B[41m \u001B[0m";
        } else {
            vermelho = " ";
        }
        if (cor.equals("verde")) {
            // Código ANSI para adicionar a cor verde ao semáforo
            verde = "\u001B[42m \u001B[0m";
        } else {
            verde = " ";
        }
        System.out.println(" " + vermelho);
        System.out.println(" " + verde);
    }
}
