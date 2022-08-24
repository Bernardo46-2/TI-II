import java.util.*;

public class SomarDoisNumeros {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// declaracao
		int num1, num2, soma;
		
		// atribuicao
		System.out.printf("Digite o primeiro numero: ");
		num1 = sc.nextInt();
		System.out.printf("Digite o segundo numero: ");
		num2 = sc.nextInt();
		
		// calculo e print
		soma = num1 + num2;
		System.out.printf("O resultado e: " + soma);
	}
}
