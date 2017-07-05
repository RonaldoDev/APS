package com.devbattle.domain;

import com.devbattle.model.Database;
import com.devbattle.service.AtorNetGames;
import com.devbattle.utils.Enumeradores;
import com.devbattle.view.AtorJogador;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;


public class Controlador {

	private Mesa Mesa;
	//private ApiNetGames apiNetGames;
	private Enumeradores.EstadoServidor EstadoServidor;
	private boolean partidaEmAndamento;
	private boolean daVez;
	private Database db;
	private String NomeAdversario;
	private AtorJogador AtorJogador;
	private AtorNetGames AtorNetGames;
	private Jogador Jogador;
	private Enumeradores.EstadoPartida EstadoPartida;

	public String getMensagem() {
		return Mensagem;
	}

	public void setMensagem(String mensagem) {
		Mensagem = mensagem;
		mostrarMensagem(Mensagem);
	}

	private String Mensagem;
	private int Ordem;
	private int IdJogada;

	public Controlador() {
		db = new Database();
		AtorNetGames = new AtorNetGames(this);
		AtorJogador = new AtorJogador(this);
		AtorJogador.mostrarView();
		EstadoServidor = Enumeradores.EstadoServidor.DESCONECTADO;
		IdJogada = 0;
	}

	//region Controles de inicio
	public Enumeradores.EstadoServidor conectar(String pServidor, String pNomeJogador) {
		Mesa = new Mesa();
		Mesa.addJogadores(new Jogador(pNomeJogador));
		if (EstadoServidor != Enumeradores.EstadoServidor.CONECTADO) {
			EstadoPartida = Enumeradores.EstadoPartida.TelaInicial;
			return this.AtorNetGames.conectar(pServidor, pNomeJogador);
		} else {
			return EstadoServidor.JA_CONECTADO;
		}
	}

	private void desconectar() {
		desconectar();
		mostrarMensagem(EstadoServidor.DESCONECTADO.toString());
	}
	public Enumeradores.EstadoPartida iniciarPartida()
	{
		return this.AtorNetGames.iniciarPartida();
	}
	public void prepararPartida(int pOrdem) {
		Ordem = pOrdem;

		NomeAdversario = AtorNetGames.obterNomeAdversarios().get(0);
		Mesa.addJogadores(new Jogador(NomeAdversario));
		Mesa.setEstadoPartida(Enumeradores.EstadoPartida.PrimeiraRodada);
		Jogador = Mesa.getJogadores().stream().filter(f -> !f.getNomeJogador().equals(NomeAdversario)).findFirst().get();
		boolean _daVez = this.isPrimeiro();
		if(_daVez)
		{
			Mesa.criarBaralho();
			Mesa.criarDescarte();
			Mesa.distribuirCartas();
			Mesa.virarPrimeiraCarta();
			Mesa.getJogadores().stream().forEach(f -> {f.setAjudas(3);});
			Jogador.setJogadorDaVez(true);
			AtorJogador.destravarBotoesMesa();
			Jogador.setNomeAdversario(NomeAdversario);
			AtorJogador.atualizaViewMesa(Mesa, Jogador);
			montaObjetoJogada();

		}
		else {
			Jogador.setNomeAdversario(NomeAdversario);
			Jogador.setJogadorDaVez(false);
		}
	}

	private boolean isPrimeiro() {
		return this.Ordem == Enumeradores.ControlePartida.OrdemPrimeiroJogador.get();
	}
	//endregion

	//region Funcao para fazer Distinct na Lista
	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
		Map<Object, Boolean> seen = new ConcurrentHashMap<>();
		return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}
	//endregion

	//region Validações
	public void verificarBatida(List<String> pValoresComboBox) {
		List<Carta> _maoJogador =  Mesa.getJogadores().stream().filter(f -> f.isJogadorDaVez()).findFirst().get().getMao();
		boolean _batida = false;
		//region Valida Valores ComboBox com Carta
		List<Linguagem> _listaLinguagensCartas = new ArrayList<>();

		_batida = validarValoresSelecionadosComboCarta(pValoresComboBox, _maoJogador, _listaLinguagensCartas);
		//endregion
		if(_batida)
			_batida = 	validarLinguagensCarta(_maoJogador, _listaLinguagensCartas);
		if(_batida)
			_batida =  validarTipoLinguagem(_maoJogador);

		if(!_batida) {
			lancarErroBatidaInvalida(Mensagem);
		}
		else {
			Mesa.setVencedor(Jogador);
		}
		montaObjetoJogada();
	}
	private boolean validarValoresSelecionadosComboCarta(List<String> pListaSelecionados, List<Carta> _maoJogador, List<Linguagem> _listaLinguagensCartas) {
		_maoJogador.forEach(f -> {
			_listaLinguagensCartas.addAll(f.getLinguagens());
		});
		List<Linguagem> _listaLinguagesDiferentes = _listaLinguagensCartas.stream().filter(distinctByKey(f -> f.getIdLinguagem())).collect(Collectors.toList());
		for(String str : pListaSelecionados)
		{
			if (_listaLinguagesDiferentes.stream().filter(fi -> fi.getNomeLinguagem().equals(str)).count() == 0) {
				setMensagem("Linguagem escolhida nao pertence as suas cartas.");
				return false;
			}
		};
		int contador = 0;
		for (String str : pListaSelecionados)
		{
			for(Carta crt : _maoJogador)
			{
				contador += crt.getLinguagens().stream().filter(f -> f.getNomeLinguagem().equals(str)).count();
			}
		}
		if(contador < 7)
		{
			setMensagem("cartas diferentes combo");
			return false;
		}
		if(_maoJogador.stream().filter(f -> f.getLinguagens().get(0).getNomeLinguagem() == "CSS").count() > 1 &&
				_maoJogador.stream().filter(f -> f.getLinguagens().get(0).getNomeLinguagem() == "HTML").count() == 0)
		{
			setMensagem("Você não pode bater com CSS sem uma carta HTML");
			return false;
		}
		else if(_maoJogador.stream().filter(f -> f.getLinguagens().get(0).getNomeLinguagem() == "HTML").count() > 0)
		{
			setMensagem("Você não pode bater com mais de uma carta HTML");
			return false;
		}
		else if(_maoJogador.stream().filter(f -> f.getLinguagens().get(0).getNomeLinguagem() == "XML").count() > 0)
		{
			setMensagem("Você não pode bater com mais de uma carta XML");
			return false;
		}
		else if(_maoJogador.stream().filter(f -> f.getLinguagens().get(0).getNomeLinguagem() == "Javascript").count() > 0)
		{
			setMensagem("Você não pode bater com mais de uma carta Javascript");
			return false;
		}
		else if(_maoJogador.stream().filter(f -> f.getLinguagens().get(0).getNomeLinguagem() == "Modelo Cascata").count() +
				 	_maoJogador.stream().filter(f -> f.getLinguagens().get(0).getNomeLinguagem() == "Modelo Incremental").count()  > 1)
		{
			setMensagem("Você não pode bater com dois Modelos de Projeto");
			return false;
		}

		else if(_maoJogador.stream().filter(f -> f.getLinguagens().get(0).getNomeLinguagem() == "UML").count() > 0)
		{
			setMensagem("Você não pode bater com mais de uma carta UML");
			return false;
		}

		else if(_maoJogador.stream().filter(f -> f.getLinguagens().get(0).getNomeLinguagem() == "GraphDB").count()  +
					_maoJogador.stream().filter(f -> f.getLinguagens().get(0).getNomeLinguagem() == "MongoDB").count() +
						_maoJogador.stream().filter(f -> f.getLinguagens().get(0).getNomeLinguagem() == "Modelo Relacional").count() > 1)
		{
			setMensagem("Você só pode escolher um tipo de Banco de Dados");
			return false;
		}
		else if(_maoJogador.stream().filter(f -> f.getLinguagens().get(0).getNomeLinguagem() == "GraphDB").count()  +
					_maoJogador.stream().filter(f -> f.getLinguagens().get(0).getNomeLinguagem() == "MongoDB").count() +
						_maoJogador.stream().filter(f -> f.getLinguagens().get(0).getNomeLinguagem() == "SGBD/SQL").count() > 1)
		{
			setMensagem("Você só pode escolher um tipo de Banco de Dados");
			return false;
		}
		else if(_maoJogador.stream().filter(f -> f.getTexto().equals("PL")).count()  +
				_maoJogador.stream().filter(f -> f.getTexto().equals("PgAdmin")).count() >= 2)
		{
			setMensagem("Você só pode escolher um tipo de SGBD");
			return false;
		}
		return true;
	}

	private boolean validarLinguagensCarta(List<Carta> pMaoJogador, List<Linguagem> pListaLinguagemCarta) {
		for (Enumeradores.TipoLinguagem tpLinguagem : Arrays.stream(Enumeradores.TipoLinguagem.values()).filter(f -> f != Enumeradores.TipoLinguagem.EngSoftware && f != Enumeradores.TipoLinguagem.LinguagemMarcacao).collect(Collectors.toList())) {
			List<Carta> _listaVerificacaoTipo = pMaoJogador.stream().filter(f -> f.getTipoLinguagem() == tpLinguagem.toString()).collect(Collectors.toList());
			pListaLinguagemCarta.clear();
			for (Carta crt : _listaVerificacaoTipo) {

				pListaLinguagemCarta.addAll(crt.getLinguagens());

			}
			Map<String, Long> _groupLinguagens = pListaLinguagemCarta.stream().collect(groupingBy(g -> g.getNomeLinguagem(), counting()));
			if(_groupLinguagens.size() != 0 && _listaVerificacaoTipo.size() != 0)
				if (_groupLinguagens.entrySet().stream().filter(f -> f.getValue() >= _listaVerificacaoTipo.size()).findFirst().orElse(null) == null) {
					setMensagem("Errouu, suas linguagens das cartas não coincidem");
					return false;
				}
		}
		return true;
	}

	private boolean validarTipoLinguagem(List<Carta> pMaoJogador) {
		Map<String, Long> _tiposLinguagem = pMaoJogador.stream().collect(groupingBy(g -> g.getTipoLinguagem(), Collectors.counting()));
		//region Tipos de linguagem não permitidos bater
		if (_tiposLinguagem.entrySet().stream().filter(f -> f.getKey() == Enumeradores.TipoLinguagem.Compilada.toString()).count() > 0 &&
				_tiposLinguagem.entrySet().stream().filter(f -> f.getKey() == Enumeradores.TipoLinguagem.Interpretada.toString()).count() > 0) {
			setMensagem("Errrrrrrrrrrrrrrrou, você não pode bater com linguagem Compilada e Interpretada.");
			return false;
		}
		else if (_tiposLinguagem.entrySet().stream().filter(f -> f.getKey() == Enumeradores.TipoLinguagem.Interpretada.toString()).count() > 0 &&
				_tiposLinguagem.entrySet().stream().filter(f -> f.getKey() == Enumeradores.TipoLinguagem.LinguagemMarcacao.toString()).count() == 0) {
			setMensagem("Errrrrrrrrrrrrrrrou, você não pode bater com linguagem Interpretada sem uma Linguagem de Marcação.");
			return false;
		}
		//endregion

		//region Somatótios
		else if (_tiposLinguagem.entrySet().stream().filter(f -> f.getKey() == Enumeradores.TipoLinguagem.BancoDados.toString()).count() +
				_tiposLinguagem.entrySet().stream().filter(f -> f.getKey() == Enumeradores.TipoLinguagem.LinguagemMarcacao.toString()).count() == 7) {
			setMensagem("Errrrrrrrrrrrrrrrou, você não pode bater somente com Banco de Dados e Linguagem de Marcação.");
			return false;
		}else if (_tiposLinguagem.entrySet().stream().filter(f -> f.getKey() == Enumeradores.TipoLinguagem.BancoDados.toString()).count() +
				_tiposLinguagem.entrySet().stream().filter(f -> f.getKey() == Enumeradores.TipoLinguagem.LinguagemMarcacao.toString()).count() +
				_tiposLinguagem.entrySet().stream().filter(f -> f.getKey() == Enumeradores.TipoLinguagem.EngSoftware.toString()).count() == 7) {
			setMensagem("Errrrrrrrrrrrrrrrou, você não pode bater somente com Banco de Dados e Linguagem de Marcação.");
			return false;
		}
		else if (_tiposLinguagem.entrySet().stream().filter(f -> f.getKey() == Enumeradores.TipoLinguagem.EngSoftware.toString()).count() +
				_tiposLinguagem.entrySet().stream().filter(f -> f.getKey() == Enumeradores.TipoLinguagem.BancoDados.toString()).count() == 7) {
			setMensagem("Errrrrrrrrrrrrrrrou, você não pode bater somente com Banco de Dados e Eng. Software.");
			return false;
		} else if (_tiposLinguagem.entrySet().stream().filter(f -> f.getKey() == Enumeradores.TipoLinguagem.EngSoftware.toString()).count() +
				_tiposLinguagem.entrySet().stream().filter(f -> f.getKey() == Enumeradores.TipoLinguagem.BancoDados.toString()).count() == 7) {
			setMensagem("Errrrrrrrrrrrrrrrou, você não pode bater somente com Banco de Dados e Eng. Software.");
			return false;
		}
		//endregion

		//region Somente uma linguagem
		else if (_tiposLinguagem.entrySet().stream().filter(f -> f.getKey() == Enumeradores.TipoLinguagem.BancoDados.toString()).count() >  1)
		{
			setMensagem("Errrrrrrrrrrrrrrrou, você não pode bater somente com Banco de Dados.");
			return false;
		} else if (_tiposLinguagem.entrySet().stream().filter(f -> f.getKey() == Enumeradores.TipoLinguagem.EngSoftware.toString()).count() > 1)

		{
			setMensagem("Errrrrrrrrrrrrrrrou, você não pode bater somente com Engenharia de software.");
			return false;
		}
		else if (_tiposLinguagem.entrySet().stream().filter(f -> f.getKey() == Enumeradores.TipoLinguagem.BancoDados.toString()).count() >  2)
		{
			setMensagem("Errrrrrrrrrrrrrrrou, você não pode bater somente com Banco de Dados.");
			return false;
		} else if (_tiposLinguagem.entrySet().stream().filter(f -> f.getKey() == Enumeradores.TipoLinguagem.EngSoftware.toString()).count() > 3)

		{
			setMensagem("Errrrrrrrrrrrrrrrou, você não pode bater somente com Engenharia de software.");
			return false;
		}
		//endregion
		return true;
	}

	private void lancarErroBatidaInvalida(String pMsgErro) {
			Mesa.getJogadores().stream().filter(f -> f.isJogadorDaVez()).findFirst().get().subtrairAjudaJogador();
			verificarDerrotaPorAjudas();
			mostrarMensagem(this.getMensagem());
			AtorJogador.atualizaViewMesa(Mesa, Jogador);
	}

	private void verificarDerrotaPorAjudas() {
		int _numeroDicas = Mesa.getJogadores().stream().filter(f -> f.getNomeJogador().equals(Jogador.getNomeJogador())).findFirst().get().getAjudas();
		if (_numeroDicas  < 0) {
			Mensagem = "Seu contador  de Ajudas chegou a 0, infelizmente você perdeu!";
			Mesa.setVencedor(Mesa.getJogadores().stream().filter(f -> !f.isJogadorDaVez()).findFirst().get());
		}
	}
	//endregion

	//region Control de Troca de Jogadas
	private void mostrarMensagem(String s) {
		AtorJogador.mostraMensagem(s);
	}

	public void montaObjetoJogada()
	{
		IdJogada++;
		EstadoJogada _estadoJogada = new EstadoJogada();
		_estadoJogada.setIdJogada(IdJogada);
		_estadoJogada.setMesa(Mesa);
		enviarJogada(_estadoJogada);
	}

	public void enviarJogada(EstadoJogada pEstadoJogada)
	{
	    try {
			Jogador _proximo = Mesa.getJogadores().stream().filter(f -> !f.isJogadorDaVez()).collect(Collectors.toList()).iterator().next();
            Jogador _daVez = Mesa.getJogadores().stream().filter(f -> f.isJogadorDaVez()).findFirst().get();
            if (pEstadoJogada.getIdJogada() > 0) {
                _proximo.setJogadorDaVez(true);
                _daVez.setJogadorDaVez(false);
				AtorJogador.atualizaViewMesa(Mesa, Jogador);
                AtorJogador.travarBotoesMesa();
            }
            AtorNetGames.enviarJogada(pEstadoJogada);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
	}

	public void receberJogada(EstadoJogada pEstadoJogada)
	{
	    try {
            Mesa = pEstadoJogada.getMesa();
            Jogador _jogadorVencedor = Mesa.getVencedor();
            if(_jogadorVencedor != null)
			{
				if(_jogadorVencedor.getNomeJogador().equals(Jogador.getNomeJogador()))
					setMensagem("Parabéns você venceu! Observe a Mesa de seu adversário.");
				else
					setMensagem("Que pena, você perdeu! Observe a Mesa de seu adversário.");
				Jogador = Mesa.getJogadores().stream().filter(f -> f.getNomeJogador() == NomeAdversario).findFirst().get();
				Jogador.setJogadorDaVez(true);
				AtorJogador.atualizaViewMesa(Mesa, Jogador);
				AtorJogador.destravarBotoesMesa();
				desconectar();
			}
			else {
				Jogador.setJogadorDaVez(Mesa.getJogadores().stream().filter(f -> f.isJogadorDaVez()).findFirst().get().getNomeJogador().equals(Jogador.getNomeJogador()));
				if (pEstadoJogada.getIdJogada() > 0) {
					AtorJogador.destravarBotoesMesa();
					AtorJogador.atualizaViewMesa(Mesa, Jogador);
					Mesa.setEstadoPartida(Enumeradores.EstadoPartida.PartidaAndamento);
					IdJogada++;
				} else {
					AtorJogador.atualizaViewMesa(Mesa, Jogador);
				}
			}
        }
        catch(Exception e)
        {
            e.getMessage();
        }
	}


	//endregion

	//region Metodos de Controle de View
	public void comprarCartaDescarte() {
		Carta _descarte = Mesa.getDescarte().get(Mesa.getDescarte().size() -1);
		Mesa.getJogadores().stream().filter(f -> f.isJogadorDaVez()).findFirst().get().getMao().add(_descarte);
		Mesa.getDescarte().remove(_descarte);
		AtorJogador.atualizaViewMesa(Mesa, Jogador);

	}
	public void comprarCartaBaralho() {
		Carta _cartaCompra = Mesa.getBaralho().get(0);
		Mesa.getJogadores().stream().filter(f -> f.isJogadorDaVez()).findFirst().get().getMao().add(_cartaCompra);
		Mesa.getBaralho().remove(_cartaCompra);
		AtorJogador.atualizaViewMesa(Mesa, Jogador);
	}

	public void descartarPassar(String pNomeCarta) {
		try {
			Carta _descarte =  Mesa.getJogadores().stream().filter(f -> f.isJogadorDaVez()).findFirst().get().getMao().stream().filter(f -> f.getTexto().equals(pNomeCarta)).findFirst().get();
			Mesa.getDescarte().add(_descarte);
			Mesa.setDescarteDaRodada(_descarte);
			Mesa.getJogadores().stream().filter(f -> f.isJogadorDaVez()).findFirst().get().getMao().remove(_descarte);
			AtorJogador.atualizaViewMesa(Mesa, Jogador);
			Mesa.setDescarteDaRodada(null);
			montaObjetoJogada();
		}
		catch (Exception e)
		{
			e.getMessage();
		}

	}
	public void descartarBater(int pIdCarta, List<String> pValoresComboBox) {
		try {
            Carta _descarte =  Mesa.getJogadores().stream().filter(f -> f.isJogadorDaVez()).findFirst().get().getMao().stream().filter(f -> f.getIdCarta() == pIdCarta).findFirst().get();
            Mesa.getDescarte().add(_descarte);
            Mesa.setDescarteDaRodada(_descarte);
            Mesa.getJogadores().stream().filter(f -> f.isJogadorDaVez()).findFirst().get().getMao().remove(_descarte);
            verificarBatida(pValoresComboBox);
            AtorJogador.atualizaViewMesa(Mesa, Jogador);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
	}

	public boolean verificarSubtrairAjudaJogador() {
		if(Mesa.getJogadores().stream().filter(f -> f.isJogadorDaVez()).findFirst().get().getAjudas() > 0) {
			Mesa.getJogadores().stream().filter(f -> f.isJogadorDaVez()).findFirst().get().subtrairAjudaJogador();
			AtorJogador.atualizaViewMesa(Mesa, Jogador);
			return true;
		}
		else{
			return false;
		}

	}
	//endregion
}