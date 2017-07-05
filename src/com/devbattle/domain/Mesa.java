package com.devbattle.domain;

import com.devbattle.model.Database;
import com.devbattle.utils.Enumeradores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mesa implements Serializable {

	private List<Carta> Descarte;
	private List<Carta> Baralho;
	private List<Jogador> Jogadores;
	private Carta DescarteDaRodada;
	private Jogador Vencedor;
	private Enumeradores.EstadoPartida EstadoPartida;
	private Enumeradores.EstadoJogador EstadoJogador;

	public Mesa()
	{
		Jogadores = new ArrayList<>();
	}
	public void criarBaralho() {
		Database db = new Database();
		Baralho = db.retornaBaralho();
		Collections.shuffle(Baralho);
	}

	public void criarDescarte() {
		Descarte = new ArrayList<Carta>();
	}

	/**
	 * 
	 * @param pJogadores
	 */
	public void definirJogadores(List<Jogador> pJogadores) {
		// TODO - implement com.devbattle.domain.Mesa.definirJogadores
		Jogadores =  pJogadores;
	}

	public void distribuirCartas()
	{
		for (Jogador jog: Jogadores)
		{
			jog.setMao(getBaralho().subList(0,7));
			getBaralho().subList(0,7).clear();
		}
	}
	public void atualizaContagemCartas() {
		Jogadores.forEach(f -> {f.setBaralho(getBaralho());f.setDescarte(getDescarte());});
	}

	public void descartaCarta(Carta pCarta)
	{
		this.getDescarte().add(pCarta);
	}
	public Carta compraCarta()
	{
		Carta _retorno = getBaralho().get(0);
		getBaralho().remove(0);
		return _retorno;
	}
	public List<Jogador> getJogadores()
	{
		return Jogadores;
	}
	public void addJogadores(Jogador pJogador)
	{
		Jogadores.add(pJogador);
	}

	public void virarPrimeiraCarta()
	{
		this.descartaCarta(compraCarta());
	}

	public List<Carta> getDescarte() {
		return Descarte;
	}

	public List<Carta> getBaralho() {
		return Baralho;
	}

	public Enumeradores.EstadoPartida getEstadoPartida() {
		return EstadoPartida;
	}
	public void setEstadoPartida(Enumeradores.EstadoPartida pEstadoPartida) {
		EstadoPartida = pEstadoPartida;
	}

	public Carta getDescarteDaRodada() {
		return DescarteDaRodada;
	}

	public void setDescarteDaRodada(Carta descarteDaRodada) {
		DescarteDaRodada = descarteDaRodada;
	}

	public Enumeradores.EstadoJogador getEstadoJogador() {
		return EstadoJogador;
	}

	public void setEstadoJogador(Enumeradores.EstadoJogador estadoJogador) {
		EstadoJogador = estadoJogador;
	}

	public Jogador getVencedor() {
		return Vencedor;
	}

	public void setVencedor(Jogador vencedor) {
		Vencedor = vencedor;
	}
}