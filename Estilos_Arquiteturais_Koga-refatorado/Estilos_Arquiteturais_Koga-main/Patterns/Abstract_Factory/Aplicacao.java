package Patterns.Abstract_Factory;

/**
 * Cliente da família de componentes (DIP): depende apenas da abstração
 * Fabricas e das interfaces Botao/Input. Não conhece nenhuma classe
 * concreta de plataforma e não tem condicionais de seleção.
 */
public class Aplicacao {
    private final Fabricas fabrica;

    public Aplicacao(Fabricas fabrica) {
        this.fabrica = fabrica;
    }

    public void renderizar() {
        Botao botao = fabrica.criarBotao();
        Input input = fabrica.criarInput();

        botao.renderizarBotao();
        input.renderizarInput();
    }
}
