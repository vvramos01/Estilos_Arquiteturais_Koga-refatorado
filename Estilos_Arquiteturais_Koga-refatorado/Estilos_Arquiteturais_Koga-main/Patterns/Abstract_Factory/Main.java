package Patterns.Abstract_Factory;

import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Composition root: único ponto que conhece as fábricas concretas.
 * A seleção é feita por tabela (Map), sem if/else/switch.
 * Para uma nova plataforma basta criar a fábrica e registrar uma linha aqui.
 */
public class Main {
    private static final Map<String, Supplier<Fabricas>> PLATAFORMAS = Map.of(
            "andr", FabricaAndroid::new,
            "ios", FabricaIOS::new
    );

    public static void main(String[] args) {
        String tipo = "andr";

        Fabricas fabrica = Optional.ofNullable(PLATAFORMAS.get(tipo))
                .orElseThrow(() -> new IllegalArgumentException("Plataforma inválida: " + tipo))
                .get();

        new Aplicacao(fabrica).renderizar();
    }
}
