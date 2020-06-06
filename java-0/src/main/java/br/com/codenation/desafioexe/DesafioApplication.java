package br.com.codenation.desafioexe;

import java.util.List;
import java.util.ArrayList;

public class DesafioApplication {

	public @interface Desafio {
		String value();
	}

	@Desafio("Fibonacci")
	public static List<Integer> fibonacci() {
		List<Integer> fibonacci = new ArrayList();
		// Como fibonacci começa com 0 e 1, já incluo inicialmente estes valores
		fibonacci.add(0);
		fibonacci.add(1);

		// Enquanto o último valor da lista for abaixo ou igual a 350,
		// adiciono nela a soma dos dois últimos elementos
		while (fibonacci.get(fibonacci.size()-1) <= 350)
			fibonacci.add(fibonacci.get(fibonacci.size()-2) + fibonacci.get(fibonacci.size()-1));

		return fibonacci;
	}

	@Desafio("isFibonnaci")
	public static Boolean isFibonacci(Integer a) {
		return fibonacci().contains(a);
	}
}