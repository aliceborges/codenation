package challenge;

import java.util.ArrayList;
import java.util.List;

public class CriptografiaCesariana implements Criptografia {

    protected List<Character> getAlfabeto() {
        // Criei uma função que retorna uma lista com o alfabeto
        // para facilitar na hora de ver se os caracteres do
        // texto pertencem ao mesmo
        List<Character> alfabeto = new ArrayList();
        for (char letra='a'; letra<='z'; letra++)
            alfabeto.add(letra);

        return alfabeto;
    }

    protected int getPosicaoLetra(List alfabeto, int posicao) {
        // Esta é uma função recursiva. Caso a posição retornada seja
        // negativa, eu adiciono a posição o tamanho do alfabeto e
        // retorno a função. Caso o valor seja positivo, retorno o valor.
        // Assim, não dará erros na hora de ver a posição do caractere no
        // alfabeto.
        if (posicao < 0)
            return getPosicaoLetra(alfabeto,alfabeto.size() + posicao);
        return posicao;
    }

    @Override
    public String criptografar(String texto) {
        List<Character> alfabeto = getAlfabeto();
        String texto_criptografado = "";

        // Para cada caractere do texto
        for (char caracter:texto.toCharArray()) {
            caracter = Character.toLowerCase(caracter);
            // Verifico se ele está contido dentro do alfabeto. Se estiver, eu adiciono a
            // variável do texto criptografado já criptografando.
            // Para criptografar, eu pego a letra do array do alfabeto que está na
            // posição do caractere atual no alfabeto + 3, filtrando na função getPosicaoLetra
            // para não ter posição negativa.
            // Caso o caractere atual não esteja no alfabeto, eu somente o adiciono na variável.
            if (alfabeto.contains(caracter))
                texto_criptografado += alfabeto.get(getPosicaoLetra(alfabeto,alfabeto.indexOf(caracter) + 3));
            else
                texto_criptografado += caracter;
        }

        // Caso o texto esteja vazio, retorno erro.
        if (texto_criptografado.isEmpty())
            throw new IllegalArgumentException();
        return texto_criptografado;
    }

    @Override
    public String descriptografar(String texto) {
        List<Character> alfabeto = getAlfabeto();
        String texto_descriptografado = "";

        // Para cada caractere do texto
        for (char caracter:texto.toCharArray()) {
            caracter = Character.toLowerCase(caracter);
            // Verifico se ele está contido dentro do alfabeto. Se estiver, eu adiciono a
            // variável do texto descriptografado já descriptografando.
            // Para descriptografar, eu pego a letra do array do alfabeto que está na
            // posição do caractere atual no alfabeto - 3, filtrando na função getPosicaoLetra
            // para não ter posição negativa.
            // Caso o caractere atual não esteja no alfabeto, eu somente o adiciono na variável.
            if (alfabeto.contains(caracter))
                texto_descriptografado += alfabeto.get(getPosicaoLetra(alfabeto, alfabeto.indexOf(caracter) - 3));
            else
                texto_descriptografado += caracter;
        }

        // Caso o texto esteja vazio, retorno erro.
        if (texto_descriptografado.isEmpty())
            throw new IllegalArgumentException();
        return texto_descriptografado;
    }
}
