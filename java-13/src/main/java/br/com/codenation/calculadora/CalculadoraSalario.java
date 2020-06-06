package br.com.codenation.calculadora;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculadoraSalario {

	// Nas duas primeiras funções, eu tenho o retorno de um Map com a porcentagem de
	// desconto e faixas salariais do INSS e do IRRF. Pensei nesta forma de fazer pois
	// facilitaria caso futuramente fosse colocada uma integração com API, e normalmente
	// seria neste formado que os dados seriam tratados, recebendo uma lista com todos
	// os dados.
	private static Map<Double, List<Double>> getPercentageDiscountsAndRangeValuesINSS() {
		Map<Double, List<Double>> percentageDiscountAndRangeValues = new HashMap<Double, List<Double>>();

		List<Double> firstDiscount = new ArrayList<Double>();
		firstDiscount.add(0.00);
		firstDiscount.add(1500.00);
		percentageDiscountAndRangeValues.put(8.0, firstDiscount);

		List<Double> secondDiscount = new ArrayList<Double>();
		secondDiscount.add(1500.01);
		secondDiscount.add(4000.00);
		percentageDiscountAndRangeValues.put(9.0, secondDiscount);

		List<Double> thirdDiscount = new ArrayList<Double>();
		thirdDiscount.add(4000.01);
		thirdDiscount.add(Double.POSITIVE_INFINITY);
		percentageDiscountAndRangeValues.put(11.0, thirdDiscount);

		return percentageDiscountAndRangeValues;
	}

	private static Map<Double, List<Double>> getPercentageDiscountsAndRangeValuesIRRF() {
		Map<Double, List<Double>> percentageDiscountAndRangeValues = new HashMap<Double, List<Double>>();

		List<Double> firstDiscount = new ArrayList<Double>();
		firstDiscount.add(0.00);
		firstDiscount.add(3000.00);
		percentageDiscountAndRangeValues.put(0.0, firstDiscount);

		List<Double> secondDiscount = new ArrayList<Double>();
		secondDiscount.add(3000.01);
		secondDiscount.add(6000.00);
		percentageDiscountAndRangeValues.put(7.5, secondDiscount);

		List<Double> thirdDiscount = new ArrayList<Double>();
		thirdDiscount.add(6000.01);
		thirdDiscount.add(Double.POSITIVE_INFINITY);
		percentageDiscountAndRangeValues.put(15.0, thirdDiscount);

		return percentageDiscountAndRangeValues;
	}

	private static double calculateValueWithDiscount(double discountPercentage, double value) {
		return value - value * discountPercentage / 100;
	}

	private static double calculateSalaryWithDiscounts(double salarioBase, Map<Double, List<Double>> valueDiscounts) {
		// Já defino o salário retornado como 0.
		double salaryWithDiscount = 0;

		// Para cada faixa salarial e taxa de desconto enviado para esta função
		for (Map.Entry<Double, List<Double>> valorDesconto : valueDiscounts.entrySet()) {
			// Atribuo a porcentagem de desconto a variavel discountPercentage
			double discountPercentage = valorDesconto.getKey();
			// Atribuo a faixa salarial ao salaryRange
			List<Double> salaryRange = valorDesconto.getValue();
			// Caso o salarioBase esteja entre a faixa salarial, calculo o valor com desconto
			// e atribuo a variavel
			if (salarioBase >= salaryRange.get(0) && salarioBase <= salaryRange.get(1))
				salaryWithDiscount = calculateValueWithDiscount(discountPercentage, salarioBase);
		}

		return salaryWithDiscount;
	}

	public static long calcularSalarioLiquido(double salarioBase) {
		double salaryWithDiscounts = 0;

		// Caso o salario base seja menor que 1039,
		// retorno zero.
		if (salarioBase < 1039)
			return (long) salaryWithDiscounts;

		// CALCULANDO VALOR DE DESCONTO - INSS
		salaryWithDiscounts = calculateSalaryWithDiscounts(salarioBase, getPercentageDiscountsAndRangeValuesINSS());
		// CALCULANDO VALOR DE DESCONTO - IRRF
		salaryWithDiscounts = calculateSalaryWithDiscounts(salaryWithDiscounts, getPercentageDiscountsAndRangeValuesIRRF());

		return Math.round(salaryWithDiscounts);
	}

}