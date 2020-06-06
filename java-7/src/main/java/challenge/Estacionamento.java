package challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Estacionamento {

    // Para ter fácil manutenção de código, defini todas as informações dadas
    // dentro de variáveis.
    private final Integer maxVagas = 10;
    private final Integer idadeMinima = 18;
    private final Integer idadeIdoso = 55;
    private final Integer maxPontuacaoCarteiraHabilitacao = 20;

    // Crieu=i uma lista para armazenar os carros estacionados
    List<Carro> carrosEstacionados = new ArrayList<>(maxVagas);

    // Criei uma mensagem para cada erro que possa ser encontrado, de acordo com as regras
    public void verifyRequiredItems(Carro carro) {
        if (carro.getMotorista() == null)
            throw new EstacionamentoException("O carro não deve ser autônomo.");
        if (carro.getMotorista().getIdade() < idadeMinima)
            throw new EstacionamentoException("Motorista é menor de 18 anos.");
        if (carro.getMotorista().getPontos() > maxPontuacaoCarteiraHabilitacao)
            throw new EstacionamentoException("Habilitação com mais de 20 pontos.");
    }

    public void estacionar(Carro carro) {
        // Verifico se o carro e o motorista estão dentro das regras
        verifyRequiredItems(carro);

        // Para controle, criei esta variável para ver se o carro
        // será estacionado
        Boolean estacionou = false;

        // Caso o estacionamento tenha vagas, adiciono o carro
        // E seto a variável estacionou como true
        if (carrosEstacionados.size() < maxVagas) {
            carrosEstacionados.add(carro);
            estacionou = true;
        }
        else {
            // Caso o estacionamento já esteja cheio, percorro a lista
            // de carros já estacionados
            for (Carro carroEstacionado: carrosEstacionados) {
                // Caso o motorista do carro estacionado tenha menos de 55 anos
                if (carroEstacionado.getMotorista().getIdade() < 55) {
                    // Retiro o carro do estacionamento
                    carrosEstacionados.remove(carroEstacionado);
                    // Estaciono o carro atual
                    carrosEstacionados.add(carro);
                    // E seto a variável estacionou como true
                    estacionou = true;
                    break;
                }
            }
        }
        // Caso o carro não tenha estacionado, retorno um erro informando
        // Que não há vahas
        if (!estacionou)
            throw new EstacionamentoException("Não há vagas!");
    }

    public int carrosEstacionados() {
        return carrosEstacionados.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return carrosEstacionados.contains(carro);
    }
}
