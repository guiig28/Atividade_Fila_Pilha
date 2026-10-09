package controller;

import model.estrutura.Fila;
import model.estrutura.Pilha;
import model.Mensagem;

public class Agente {
    private Fila<Mensagem> filaMsg;
    private Pilha<String> desfazer;

    public Agente() {
        this.filaMsg = new Fila<>();
        this.desfazer = new Pilha<>();
    }

    public void receber(Mensagem m) {
        this.filaMsg.enqueue(m);
    }

    public void processarTudo() {
        StringBuilder anotacao = new StringBuilder();
        Mensagem Msg = this.filaMsg.dequeue();

        while (Msg != null) {
            String textoMsg = Msg.getTexto();

            if (textoMsg.startsWith("/escreve ")) {
                textoMsg = textoMsg.substring(9);
                this.desfazer.push(textoMsg);

                if (anotacao.length() > 0)
                    anotacao.append(" ");

                anotacao.append(textoMsg);
            } else if (textoMsg.startsWith("/desfaz")) {
                String popText = this.desfazer.pop();

                // verificando se existe item na pilha
                if (popText != null) {
                    anotacao.setLength(anotacao.length() - popText.length());

                    // verificando se precisa remover o espaço do texto
                    if (anotacao.length() > 0) {
                        anotacao.setLength(anotacao.length() - 1);
                    }
                }
            }

            System.out.println(anotacao);
            Msg = this.filaMsg.dequeue();
        }
    }
}
