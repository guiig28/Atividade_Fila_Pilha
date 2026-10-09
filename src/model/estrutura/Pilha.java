package model.estrutura;

public class Pilha<T> {
    private NoDuplo<T> ultimo;

    public void push(T elemento) {
        NoDuplo<T> novo = new NoDuplo<>(elemento);

        if (this.ultimo != null) {
            NoDuplo<T> anterior = this.ultimo;
            novo.setAnterior(anterior);
        }

        this.ultimo = novo;
    }

    public T pop() {
        if (this.ultimo == null)
            return null;

        NoDuplo<T> elemento = this.ultimo;
        this.ultimo = elemento.getAnterior();

        return elemento.getValor();
    }

    @Override
    public String toString() {
        if (this.ultimo == null)
            return "[]";

        StringBuilder builder = new StringBuilder("[");
        NoDuplo<T> buffer = this.ultimo;
        builder.append(buffer.getValor());

        while (buffer.getAnterior() != null) {
            builder.append(", ");
            buffer = buffer.getAnterior();
            builder.append(buffer.getValor());
        }

        builder.append("]");

        return builder.toString();
    }
}
