package com.devbattle.view;

import com.devbattle.domain.Controlador;
import com.devbattle.domain.Jogador;
import com.devbattle.domain.Mesa;
import com.devbattle.utils.Enumeradores;

import java.util.ArrayList;

/**
 * Created by ronal on 23/06/2017.
 */
public class AtorJogador {
    private Mesa Mesa;
    private Controlador Controlador;
    private MesaView MesaView;
    public AtorJogador(Controlador pControlador)
    {
        MesaView = new MesaView(this);
        Controlador = pControlador;
    }
    public void mostrarView()
    {
        MesaView.setVisible(true);
    }
    public void descartarPassar(JCarta pCartaSelecionada)
    {
        String _nomeCarta = pCartaSelecionada.getText();
        _nomeCarta = _nomeCarta.indexOf("Dica") == -1 ? _nomeCarta : _nomeCarta.substring(0, _nomeCarta.indexOf("Dica"));
        Controlador.descartarPassar(_nomeCarta);
    }

    public void descartarBater(JCarta pCartaSelecionada, ArrayList<String> pValoresComboBox) {
        Controlador.descartarBater(pCartaSelecionada.getIdCarta(),  pValoresComboBox );
    }

    public void verificarBatida(JCarta pCartaSelecionada, ArrayList<String> pValoresCombo) {

    }

     private void enviarJogada(Mesa mesa) {
    }


    public Enumeradores.EstadoServidor conectar(String pNomeServidor, String pNomeJogador) {
       return Controlador.conectar(pNomeServidor, pNomeJogador);
    }

    public Enumeradores.EstadoPartida iniciarPartida() {
        return Controlador.iniciarPartida();
    }

    public void atualizaViewMesa(Mesa pMesa, Jogador pjogador) {
        MesaView.atualizaViewMesa(pMesa, pjogador);
    }

    public boolean verificarSubtrairAjudaJogador()
    {
        return Controlador.verificarSubtrairAjudaJogador();
    }

    public void comprarCartaDescarte() {
        Controlador.comprarCartaDescarte();
    }

    public void comprarCartaBaralho() {
        Controlador.comprarCartaBaralho();
    }
    public void mostraMensagem(String pMsg)
    {
        MesaView.mostrarMensagem(pMsg);
    }
    public void travarBotoesMesa()
    {
        MesaView.travaBotoesMesa();
    }
    public void destravarBotoesMesa()
    {
        MesaView.destravaBotoesMesa();
    }


}

