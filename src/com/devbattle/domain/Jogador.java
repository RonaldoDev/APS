package com.devbattle.domain;

import com.devbattle.utils.Enumeradores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Jogador implements Serializable {

	private int IdJogador;
	private String NomeJogador;
	private String NomeAdversario;
	private int Ajudas;
	private List<Carta> Baralho;
	private List<Carta> Descarte;
	private List<Carta> Mao;
	private Mesa Mesa;
	private boolean IsJogadorDaVez;
	private Enumeradores.EstadoJogador EstadoJogador;

    public Jogador(int pIdJogador,  List<Carta> pBralho,  List<Carta> pDescarte, Mesa pMesa)
    {
        IdJogador = pIdJogador;
        setBaralho(pBralho);
        setDescarte(pDescarte);
        Mesa = pMesa;
    }
	public Jogador(int pIdJogador)
	{
		IdJogador = pIdJogador;
	}
	public Jogador(String pNomeJogador)
	{
		NomeJogador = pNomeJogador;
	}
	/*
	/**
	 *
	 * @param pPosicao
	 */
	public void retiraCarta(int pPosicao) {
		// TODO - implement Jogador.retiraCarta
		throw new UnsupportedOperationException();
	}
	/**
	 *
	 * @param pCartaSelecionada
	 */
	public String pedirAjuda(Carta pCartaSelecionada) {
		if(Ajudas > 0)
		{
			subtrairAjudaJogador();
			return pCartaSelecionada.getAjuda();
		}
		return "Você não tem mais Ajudas disponíveis.";
	}

	public void subtrairAjudaJogador() {
		Ajudas--;
	}

	/**
	 * 
	 * @param pCartaSelecionada
	 */
	public void descartarCarta(Carta pCartaSelecionada) {
		Mao.remove(pCartaSelecionada);
	}

	/**
	 * 
	 * @param mao
	 */
	public boolean verificarSequencias(ArrayList<Carta> mao) {
		// TODO - implement Jogador.verificarSequencias
		throw new UnsupportedOperationException();
	}

	public boolean verificarComboBoxLinguagens() {
		// TODO - implement Jogador.verificarComboBoxLinguagens
		throw new UnsupportedOperationException();
	}

	public int getIdJogador() {
		return IdJogador;
	}

	public void setIdJogador(int idJogador) {
		this.IdJogador = idJogador;
	}

	public String getNomeJogador() {
		return NomeJogador;
	}

	public void setNomeJogador(String nomeJogador) {
		this.NomeJogador = nomeJogador;
	}

	public int getAjudas() {
		return Ajudas;
	}

	public void setAjudas(int pAjudas) {
		this.Ajudas = pAjudas;
	}

	public List<Carta> getMao() {
		return Mao;
	}

	public void setMao(List<Carta> mao) {
		Mao = new ArrayList<>(mao);
	}

	public List<Carta> getBaralho() {
		return Baralho;
	}

	public void setBaralho(List<Carta> baralho) {
		Baralho = baralho;
	}

	public List<Carta> getDescarte() {
		return Descarte;
	}

	public void setDescarte(List<Carta> descarte) {
		Descarte = descarte;
	}

	public boolean isJogadorDaVez() {
		return IsJogadorDaVez;
	}

	public void setJogadorDaVez(boolean pJogadorDaVez) {
		IsJogadorDaVez = pJogadorDaVez;
	}

	public String getNomeAdversario() {
		return NomeAdversario;
	}

	public void setNomeAdversario(String nomeAdversario) {
		NomeAdversario = nomeAdversario;
	}
}