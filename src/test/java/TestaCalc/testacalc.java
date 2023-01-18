package TestaCalc;

import static org.junit.Assert.assertEquals;

import DevCalc.Calc;

import org.junit.Test;
public class testacalc {
    @Test
    public void testarSomarDoisNumeros() {
        // 1 - Prepara  -Configurar - Given
        int num1 = 5;
        int num2 = 7;
        int resultadoEsperado = 12;

        // 2 - Executar - When
        int resultadoAtual = Calc.somarDoisNumeros(num1, num2);

        // 3 - Validar - Then
        System.out.println("O resultado esperado é: " + resultadoEsperado + "\n O resultado Atual foi: "+ resultadoAtual);
        assertEquals(resultadoEsperado,resultadoAtual);
    }


    @Test
    public void testarsubtrairDoisNumeros(){
        int num1 = 6;
        int num2 = 2;
        int resultadoEsperado = 4;

        int resultadoAtual = Calc.subtrairDoisNumeros(num1, num2);

        System.out.println("O resultado esperado é " + resultadoEsperado
                + " e o resultado atual é " + resultadoAtual);

        assertEquals(resultadoAtual,resultadoEsperado);
    }
}


