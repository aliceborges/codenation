package br.com.codenation;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StatisticUtil {

	public static int average(int[] elements) {
		// Retorna a soma de todos os elementos via stream
		return (int) Arrays.stream(elements).average().getAsDouble();
	}

	public static int mode(int[] elements) {
		// Cria um hashmap - array que podemos definir o index dos elementos
		Map<Integer, Integer> occurrences = new HashMap<>();

		// Para cada elemento
		for(Integer element : elements) {
			// Se o hashmap não tem nenhum item com o index sendo o elemento,
			// cria um com o valor inicial 0
			if (!occurrences.containsKey(element))
				occurrences.put(element, 0);

			Integer atualValue = occurrences.get(element);
			// Soma +1 para cada vez que o elemento é percorrido
			occurrences.put(element, atualValue+1);
		}

		// Compara cada valor dentro do hashmap e volta o index do maior valor via stream
		return occurrences.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
	}

	public static int median(int[] elements) {
		// Já que o cálculo da mediana só é feito com arrays ordenados, primeiro ordenamos
		Arrays.sort(elements);

		// Caso a quantidade de elementos seja par, volta a média dos valores do meio do array
		if (elements.length % 2 == 0)
			return ((elements[elements.length/2] + elements[elements.length/2 -1]) / 2);
		// Caso a quantidade de elementos seja ímpar, volta o elemento do meio do array
		return elements[(elements.length-1)/2];
	}
}