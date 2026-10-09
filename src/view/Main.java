package view;

import controller.Agente;
import model.Mensagem;

public class Main {
    public static void main(String[] args) {
        Agente agente = new Agente();

        int i = 0;

        agente.receber(new Mensagem(i++, "/desfaz"));
        agente.receber(new Mensagem(i++, "/escreve Eu"));
        agente.receber(new Mensagem(i++, "/escreve gosto"));
        agente.receber(new Mensagem(i++, "/escreve de"));
        agente.receber(new Mensagem(i++, "/escreve Java"));
        agente.receber(new Mensagem(i++, "/desfaz"));
        agente.receber(new Mensagem(i++, "/desfaz"));
        agente.receber(new Mensagem(i++, "/escreve muito"));
        agente.receber(new Mensagem(i++, "/escreve de"));
        agente.receber(new Mensagem(i++, "/escreve Java"));

        agente.processarTudo();
    }
}
