package com.devbattle.utils;

import java.io.Serializable;

/**
 * Created by ronal on 18/06/2017.
 */
public class Enumeradores implements Serializable{
    public enum Caracteristica {
        Delegate, ArrowFunction, Coringa, TipagemDinamica, CallBack, Threads, Linq, Ponteiro, AngularJS;
    }

    public enum TipoLinguagem {
        Compilada, MultiParadigma, Interpretada, BancoDados, LinguagemMarcacao, EngSoftware;



    }
    public enum TipoCombobox {
         nulo(""),csharp("C#"), cplusplus("C/C++"), java("Java"), php("PHP"), ruby("Ruby"), python("Python"),javascript("Javascript"),html("HTML"), xml("XML"), css("CSS"), relacional("Modelo Relacional"),mongodb("MongoDB"), sql("SGBD/SQL"), graph("GraphDB"), agile("Scrum"), uml("UML"), modeloCascata("Modelo Cascata"), modeloIncremental("Modelo Incremental");;
        private final String display;
        TipoCombobox(String s) {
            display = s;
        }
        @Override
        public String toString() {
            return display;
        }

    }
    public enum EstadoServidor {

        CONECTADO("Conectado"), DESCONECTADO("Desconectado"), FALHA("Falha de Conexão."), JA_CONECTADO("Já Conectado");
        private final String display;
        EstadoServidor(String s) {
            display = s;
        }
        @Override
        public String toString() {
            return display;
        }
    }

    public enum  EstadoPartida{
        TelaInicial, AguardandoInicioJogo, AguardandoEscolhaAdversario, PrimeiraRodada, PartidaAndamento, PartidaFinalizada, MinhaVez, VezAdversario, NAO
    }
    public enum TipoMensagem{
        Aviso, Sucesso, Nulo
    }
    public enum EstadoJogador{
        Conectado, Desconectado, Jogando, MinhaVez, VezAdversario, Descartando, AguardandoInicioPartida
    }
    public enum ControlePartida{
        OrdemPrimeiroJogador(1);
        private final int display;
        ControlePartida(int s) {
            display = s;
        }
        public int get() {
            return display;
        }
    }
}
