package challenge;


import java.util.Objects;

public class Motorista {

    private String nome;
    private int idade;
    private int pontos;
    private String habilitacao;

    private Motorista(Builder builder) {

        this.nome = builder.nome;
        this.idade = builder.idade;
        this.pontos = builder.pontos;
        this.habilitacao = builder.habilitacao;
    }

    // Construo um builder
    public static final class Builder {

        private String nome;
        private int idade;
        private int pontos;
        private String habilitacao;

        public Builder() {}

        public Builder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder withIdade(int idade) {
            this.idade = idade;
            // Caso o motorista tenha idade negativa, retorna erro
            if (this.idade < 0)
                throw new IllegalArgumentException();
            return this;
        }

        public Builder withPontos(int pontos) {
            this.pontos = pontos;
            // Caso o motorista tenha pontos negativos, retorna erro
            if (this.pontos < 0)
                throw new IllegalArgumentException();
            return this;
        }

        public Builder withHabilitacao(String habilitacao) {
            this.habilitacao = habilitacao;
            return this;
        }

        public Motorista build() {
            // Caso o nome ou habilitação não serem preenchidos, retorna erro
            Objects.requireNonNull(this.nome, "O nome é obrigatorio.");
            Objects.requireNonNull(this.habilitacao, "A habilitação é obrigatória.");
            return new Motorista(this);
        }

    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getPontos() {
        return pontos;
    }

    public String getHabilitacao() {
        return habilitacao;
    }

    public static Builder builder() {
        return new Builder();
    }

}