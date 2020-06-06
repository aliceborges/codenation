package challenge;


import java.util.Objects;

public class Carro {

    private Motorista motorista;
    private String placa;
    private Cor cor;

    private Carro(Builder builder) {
        this.motorista = builder.motorista;
        this.placa = builder.placa;
        this.cor = builder.cor;
    }

    // Construo um builder
    public static final class Builder {
        private String placa;
        private Cor cor;
        private Motorista motorista;

        public Builder() {}

        public Builder withPlaca(String placa) {
            this.placa = placa;
            return this;
        }

        public Builder withCor(Cor cor) {
            this.cor = cor;
            return this;
        }

        public Builder withMotorista(Motorista motorista) {
            this.motorista = motorista;
            return this;
        }

        public Carro build() {
            // Caso a placa ou cor não forem preenchidos, retorna erro
            Objects.requireNonNull(this.placa, "A placa não foi preenchida.");
            Objects.requireNonNull(this.cor, "A cor não foi preenchida.");
            return new Carro(this);
        }

    }

    public String getPlaca() {
        return placa;
    }

    public Cor getCor() {
        return cor;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public static Builder builder() {
        return new Builder();
    }
}