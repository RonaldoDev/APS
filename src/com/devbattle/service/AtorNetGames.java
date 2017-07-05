package com.devbattle.service;
import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.*;
import com.devbattle.domain.Controlador;
import com.devbattle.domain.EstadoJogada;
import com.devbattle.utils.Enumeradores;

import java.util.List;

/**
 * Created by ronal on 25/06/2017.
 */
public class AtorNetGames  implements OuvidorProxy {
    /**
     *
     */

   private static final long serialVersionUID = 1L;
    protected Proxy Proxy;
    protected Controlador Controlador;

    public AtorNetGames(Controlador controlador) {
        super();
        this.Controlador = controlador;
        this.Proxy = Proxy.getInstance();
        this.Proxy.addOuvinte(this);
    }

    public Enumeradores.EstadoServidor conectar(String servidor, String nome) {
        try {
            this.Proxy.conectar(servidor, nome);
        } catch (JahConectadoException | NaoPossivelConectarException
                | ArquivoMultiplayerException e) {
            e.printStackTrace();
            return Enumeradores.EstadoServidor.FALHA;
        }
        return Enumeradores.EstadoServidor.CONECTADO;
    }

    public Enumeradores.EstadoServidor desconectar() {
        try {
            this.Proxy.desconectar();
        } catch (NaoConectadoException e) {
            e.printStackTrace();
            return Enumeradores.EstadoServidor.FALHA;
        }
        return Enumeradores.EstadoServidor.DESCONECTADO;
    }

    public Enumeradores.EstadoPartida iniciarPartida() {
        try {
            this.Proxy.iniciarPartida(2);
        } catch (NaoConectadoException e) {
            e.printStackTrace();
            return Enumeradores.EstadoPartida.NAO;
        }
        return Enumeradores.EstadoPartida.AguardandoEscolhaAdversario;
    }

    public String obterNomeAdversario(int ordem) {
        return this.Proxy.obterNomeAdversario(ordem);
    }

    public void enviarJogada(EstadoJogada pEstadoJogada) {
        try {
            this.Proxy.enviaJogada(pEstadoJogada);
        } catch (NaoJogandoException e) {
            e.printStackTrace();
        }
    }
    public List<String> obterNomeAdversarios()
    {
        return this.Proxy.obterNomeAdversarios();
    }
    @Override
    public void iniciarNovaPartida(Integer pOrdem) {
        Controlador.prepararPartida(pOrdem);
    }

    @Override
    public void receberJogada(Jogada jogada) {
        this.Controlador.receberJogada((EstadoJogada) jogada);
    }

    @Override
    public void finalizarPartidaComErro(String message) {
        return;
    }

    @Override
    public void receberMensagem(String msg) {
        return;
    }


    @Override
    public void tratarConexaoPerdida() {
        return;
    }

    @Override
    public void tratarPartidaNaoIniciada(String message) {
        return;
    }

}
