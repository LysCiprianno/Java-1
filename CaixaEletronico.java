import java.util.Scanner;

public class CaixaEletronico {

    static final int SENHA_CORRETA = 3589;
    static String nomeUsuario;
    static double saldo = 0.0;
    static String extrato = "";
    static String numeroConta = "";
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicita o nome do usuário ao acessar o sistema
        System.out.print("Digite seu nome: ");
        nomeUsuario = scanner.nextLine();
        System.out.println("Olá " + nomeUsuario + ", é um prazer ter você por aqui!");
        
        // Loop do menu principal
        int opcao;
        do {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a quebra de linha
            
            switch(opcao) {
                case 1:
                    criarConta(scanner);
                    break;
                case 2:
                    acessarSaldo(scanner);
                    break;
                case 3:
                    verExtrato(scanner);
                    break;
                case 4:
                    saque(scanner);
                    break;
                case 5:
                    deposito(scanner);
                    break;
                case 6:
                    transferencia(scanner);
                    break;
                case 7:
                    System.out.println(nomeUsuario + ", foi um prazer ter você por aqui!");
                    break;
                default:
                    erro();
                    break;
            }
        } while (opcao != 7);
        
        scanner.close();
    }
    
    // Função para exibir o menu principal
    public static void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Criar Conta");
        System.out.println("2. Saldo");
        System.out.println("3. Extrato");
        System.out.println("4. Saque");
        System.out.println("5. Depósito");
        System.out.println("6. Transferência");
        System.out.println("7. Sair");
    }
    
    // Função para exibir erro
    public static void erro() {
        System.out.println("Opção inválida! Tente novamente.");
    }

    // Função para criar conta (apenas armazena um número fictício para a conta)
    public static void criarConta(Scanner scanner) {
        System.out.print("Digite o número da sua conta: ");
        numeroConta = scanner.nextLine();
        System.out.println("Conta criada com sucesso! Número da conta: " + numeroConta);
    }

    // Função para acessar saldo, com validação de senha
    public static void acessarSaldo(Scanner scanner) {
        if (validarSenha(scanner)) {
            System.out.println("Seu saldo é: R$ " + saldo);
        }
    }

    // Função para ver extrato, com validação de senha
    public static void verExtrato(Scanner scanner) {
        if (validarSenha(scanner)) {
            if (extrato.isEmpty()) {
                System.out.println("Nenhuma transação realizada até o momento.");
            } else {
                System.out.println("Extrato:\n" + extrato);
            }
        }
    }

    // Função para saque, com validação de senha e verificação de saldo
    public static void saque(Scanner scanner) {
        if (validarSenha(scanner)) {
            System.out.print("Digite o valor para saque: R$ ");
            double valorSaque = scanner.nextDouble();
            
            // Verificar se o valor do saque é válido
            if (isValorValido(valorSaque)) {
                if (valorSaque <= saldo) {
                    saldo -= valorSaque;
                    extrato += "Saque de R$ " + valorSaque + "\n";
                    System.out.println("Saque realizado com sucesso! Seu saldo atual é: R$ " + saldo);
                } else {
                    System.out.println("Operação não autorizada. Saldo insuficiente.");
                }
            }
        }
    }

    // Função para depósito, com validação de senha e verificação de valor positivo
    public static void deposito(Scanner scanner) {
        if (validarSenha(scanner)) {
            System.out.print("Digite o valor para depósito: R$ ");
            double valorDeposito = scanner.nextDouble();
            
            // Verificar se o valor do depósito é válido
            if (isValorValido(valorDeposito)) {
                saldo += valorDeposito;
                extrato += "Depósito de R$ " + valorDeposito + "\n";
                System.out.println("Depósito realizado com sucesso! Seu saldo atual é: R$ " + saldo);
            }
        }
    }

    // Função para transferência, com validação de senha e saldo suficiente
    public static void transferencia(Scanner scanner) {
        if (validarSenha(scanner)) {
            System.out.print("Digite o número da conta para transferência: ");
            String contaDestino = scanner.nextLine();
            System.out.print("Digite o valor da transferência: R$ ");
            double valorTransferencia = scanner.nextDouble();
            
            // Verificar se o valor da transferência é válido
            if (isValorValido(valorTransferencia)) {
                if (valorTransferencia <= saldo) {
                    saldo -= valorTransferencia;
                    extrato += "Transferência de R$ " + valorTransferencia + " para a conta " + contaDestino + "\n";
                    System.out.println("Transferência realizada com sucesso! Seu saldo atual é: R$ " + saldo);
                } else {
                    System.out.println("Operação não autorizada. Saldo insuficiente.");
                }
            }
        }
    }

    // Função para validar a senha
    public static boolean validarSenha(Scanner scanner) {
        System.out.print("Digite sua senha: ");
        int senha = scanner.nextInt();
        if (senha != SENHA_CORRETA) {
            System.out.println("Senha incorreta. Tente novamente.");
            return false;
        }
        return true;
    }

    // Função para verificar se o valor informado é válido (maior que zero)
    public static boolean isValorValido(double valor) {
        if (valor <= 0) {
            System.out.println("Operação não autorizada. O valor deve ser maior que zero.");
            return false;
        }
        return true;
    }
}
