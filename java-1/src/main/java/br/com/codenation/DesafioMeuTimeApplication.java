package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	// Cria hashmap para guardar times e jogadores cadastrados.
	// O ID de cada item cadastrado será o id do time e o id do jogador
	private Map<Long, Time> timesCadastrados = new HashMap<>();
	private Map<Long, Jogador> jogadoresCadastrados = new HashMap<>();

	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		// Caso o time já existe, retorna erro
		if (timesCadastrados.containsKey(id))
			throw new IdentificadorUtilizadoException();

		timesCadastrados.put(id, new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));
	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		// Caso o jogador já exista ou caso o time dele não exista, retorna erro
		if (jogadoresCadastrados.containsKey(id))
			throw new IdentificadorUtilizadoException();

		if (!timesCadastrados.containsKey(idTime))
			throw new TimeNaoEncontradoException();

		jogadoresCadastrados.put(id, new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario));
	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {
		// Caso o jogador não exista ou caso o time do jogador não exista, retorna erro
		if (!jogadoresCadastrados.containsKey(idJogador))
			throw new JogadorNaoEncontradoException();

		Jogador jogador = jogadoresCadastrados.get(idJogador);

		if (!timesCadastrados.containsKey(jogador.getIdTime()))
			throw new TimeNaoEncontradoException();

		// Seta o capitão do time do jogador
		timesCadastrados.get(jogador.getIdTime()).setCapitao(jogador);
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {
		// Caso o time não exista ou caso o time não possua capitão, retorna erro
		if (!timesCadastrados.containsKey(idTime))
			throw new TimeNaoEncontradoException();

		Time time = timesCadastrados.get(idTime);
		if (time.getCapitao() == null)
			throw new CapitaoNaoInformadoException();

		// Retorna o ID do capitão do time
		return timesCadastrados.get(idTime).getCapitao().getId();
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {
		// Caso o jogador não exista, retorna erro
		if (!jogadoresCadastrados.containsKey(idJogador))
			throw new JogadorNaoEncontradoException();
		//Retorna o nome do jogador
		return jogadoresCadastrados.get(idJogador).getNome();
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {
		// Caso o time não exista, retorna erro
		if (!timesCadastrados.containsKey(idTime))
			throw new TimeNaoEncontradoException();
		// Retorna o nome do time
		return timesCadastrados.get(idTime).getNome();
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		// Caso o time não exista, retorna erro
		if (!timesCadastrados.containsKey(idTime))
			throw new TimeNaoEncontradoException();

		// Para todo jogador, é verificado se ele tem o id do time igual ao do parâmetro
		// ordena e converte o resultado para list()
		return jogadoresCadastrados.entrySet().stream()
				.filter(jogador -> jogador.getValue().getIdTime().equals(idTime))
				.map(jogador -> jogador.getKey())
				.sorted()
				.collect(Collectors.toList());
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		// Caso o time não exista, retorna erro
		if (!timesCadastrados.containsKey(idTime))
			throw new TimeNaoEncontradoException();

		// Para todo jogador, é verificado se ele tem o id do time igual ao do parâmetro
		// e compara todos os níveis de habilidade, e retorna o ID de quem tem o maior nível
		return jogadoresCadastrados.entrySet().stream()
				.filter(jogador -> jogador.getValue().getIdTime().equals(idTime))
				.max(Comparator.comparingInt(jogador -> jogador.getValue().getNivelHabilidade()))
				.get()
				.getKey();
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		// Caso o time não exista, retorna erro
		if (!timesCadastrados.containsKey(idTime))
			throw new TimeNaoEncontradoException();

		// Para todo jogador, é verificado se ele tem o id do time igual ao do parâmetro
		// compara todas as datas de nascimento, e retorna o ID do jogador mais velho
		return jogadoresCadastrados.entrySet().stream()
				.filter(jogador -> jogador.getValue().getIdTime().equals(idTime))
				.min(Comparator.comparing(jogador -> jogador.getValue().getDataNascimento()))
				.get()
				.getKey();
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		// Para todo time cadastrado, ordena por ID e retorna uma lista
		return timesCadastrados.entrySet().stream()
				.map(time -> time.getKey())
				.sorted()
				.collect(Collectors.toList());
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
		// Caso o time não exista, retorna erro
		if (!timesCadastrados.containsKey(idTime))
			throw new TimeNaoEncontradoException();

		// Para todo jogador, é verificado se ele tem o id do time igual ao do parâmetro
		// compara todos os salários e retorna o ID do jogador que tem o maior
		return jogadoresCadastrados.entrySet().stream()
				.filter(jogador -> jogador.getValue().getIdTime().equals(idTime))
				.max(Comparator.comparing(jogador -> jogador.getValue().getSalario()))
				.get()
				.getKey();
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		// Caso o jogador não exista, retorna erro
		if (!jogadoresCadastrados.containsKey(idJogador))
			throw new JogadorNaoEncontradoException();

		// Retorna o salário do jogador com este ID
		return jogadoresCadastrados.get(idJogador).getSalario();
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {
		// Pega todos os jogadores cadastrado, mapeia pelo valor dos itens,
		// ordenena pelo ID, pelo nível de habilitadade, converte para lista
		return jogadoresCadastrados.entrySet().stream()
				.map(jogador -> jogador.getValue())
				.sorted(Comparator.comparingInt(Jogador::getNivelHabilidade).reversed())
				.limit(top)
				.map(jogador -> jogador.getId())
				.collect(Collectors.toList());
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
		// Se um dos times não existir, retorna erro
		if (!timesCadastrados.containsKey(timeDaCasa) || !timesCadastrados.containsKey(timeDeFora))
			throw new TimeNaoEncontradoException();

		// Atribuo para as variáveis de cor de camisa as cores principais dos respectivos times
		String corCamisaTimePrincipal = timesCadastrados.get(timeDaCasa).getCorUniformePrincipal();
		String corCamisaTimeAdversario = timesCadastrados.get(timeDeFora).getCorUniformePrincipal();

		// Caso as cores sejam iguais, atribui a cor segundária ao time adversário
		if (corCamisaTimePrincipal == corCamisaTimeAdversario)
			corCamisaTimeAdversario = timesCadastrados.get(timeDeFora).getCorUniformeSecundario();

		return corCamisaTimeAdversario;
	}

}
