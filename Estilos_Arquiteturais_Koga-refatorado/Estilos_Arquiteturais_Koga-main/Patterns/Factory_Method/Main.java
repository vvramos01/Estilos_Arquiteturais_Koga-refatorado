package Patterns.Factory_Method;

import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Composition root: escolhe a fábrica concreta por tabela, sem condicionais.
 * Para um novo canal (ex.: Push) basta criar EnvioPush + FabricaPush
 * e registrar uma linha no mapa.
 */
public class Main {
    private static final Map<String, Supplier<FabricaNotificacoes>> CANAIS = Map.of(
            "email", FabricaEmail::new,
            "sms", FabricaSMS::new
    );

    public static void main(String[] args) {
        String tipo = "email";

        FabricaNotificacoes fabrica = Optional.ofNullable(CANAIS.get(tipo))
                .orElseThrow(() -> new IllegalArgumentException("Tipo de notificação inválido: " + tipo))
                .get();

        fabrica.notificar();
    }
}
