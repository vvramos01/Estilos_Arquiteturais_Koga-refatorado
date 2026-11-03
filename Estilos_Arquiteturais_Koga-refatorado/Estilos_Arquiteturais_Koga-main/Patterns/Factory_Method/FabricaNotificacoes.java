package Patterns.Factory_Method;

/**
 * Criador abstrato (Factory Method). O fluxo comum fica aqui, fechado
 * para modificação (final) e dependente apenas de IntNotificacoes.
 * Novas variantes são novas subclasses; esta classe não é editada.
 */
public abstract class FabricaNotificacoes {

    protected abstract IntNotificacoes criarNotificacoes();

    public final void notificar() {
        IntNotificacoes notificacoes = criarNotificacoes();
        notificacoes.enviar();
    }
}
