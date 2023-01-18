// 1 - pacote
package DevCalc;

import java.util.Scanner;

// 2 - bibliotecas
// 3 - classe
public class Calc {
    // 3.1 - Atributos
    static Scanner entrada = new Scanner(System.in);
    //Vai ler a opção colocada no console. Quando o valor for utilizado para vários métodos/funções, é melhor coloca-lo nos atributos

    // 3.2 - Métodos e Funções
    public static void main(String[] args){
        // Exibe o menu da calculadora
        System.out.println(">>> CALCULADORA <<<");
        System.out.println("(1) Soma");
        System.out.println("(2) Subtrair");
        System.out.println("(3) Multiplicar");
        System.out.println("(4) Dividir");
        System.out.print("Escolha o Calculo desejado: ");

        // Recebe a opção desejada (como inteiro)
        int opcao = entrada.nextInt();
        int num1 = 0;
        int num2 = 0;
        // Pergunta os valores a serem usados no calculo
        if (opcao >= 1 && opcao <=4){
            System.out.print("Entre o primeiro numero: ");
            num1 = entrada.nextInt();
            System.out.print("Entre o segundo numero: ");
            num2 = entrada.nextInt();
            System.out.print("O resultado é: ");
        }
        //println pula a linha, para exibir do lado basta apenas usar o print

        // Chama a função do calculo desejado
        switch (opcao){
            case 1:
                System.out.println(somarDoisNumeros(num1, num2));
                break;
            case 2:
                System.out.println(subtrairDoisNumeros(num1, num2));
                break;
            default:
                System.out.println("Opção Inválida");
                break;
        }
    }

    public static int somarDoisNumeros(int num1, int num2){
        return num1 + num2;
    }
    public static int subtrairDoisNumeros(int num1, int num2){
        return num1 - num2;
    }
}
