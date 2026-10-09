package model.estrutura;

public class Fila<T> {
    private NoDuplo<T> inicio;

    private NoDuplo<T> last() {
        if (this.inicio == null)
            throw new IllegalStateException("Nao existe elemento na fila.");

        NoDuplo<T> buffer = this.inicio;

        while (buffer.getProximo() != null)
            buffer = buffer.getProximo();

        return buffer;
    }

    public void enqueue(T elemento) {
        NoDuplo<T> buffer = new NoDuplo<>(elemento);

        if (this.inicio == null) {
            this.inicio = buffer;
        } else {
            this.last().setProximo(buffer);
        }
    }

    public T dequeue() {
        if (this.inicio == null) {
            return null;
        }

        NoDuplo<T> primeiro = this.inicio;
        this.inicio = primeiro.getProximo();

        return primeiro.getValor();
    }

    @Override
    public String toString() {
        if (this.inicio == null)
            return "[]";

        StringBuilder builder = new StringBuilder("[");
        NoDuplo<T> buffer = this.inicio;
        builder.append(buffer.getValor());

        while (buffer.getProximo() != null) {
            builder.append(", ");
            buffer = buffer.getProximo();
            builder.append(buffer.getValor());
        }

        builder.append("]");

        return builder.toString();
    }
}
