package com.devbattle.domain;

import com.devbattle.utils.Enumeradores;

import java.io.Serializable;

public class Linguagem implements Serializable {

	private int IdLinguagem;
	private String NomeLinguagem;
	private Enumeradores.TipoLinguagem TipoLinguagem;
	private boolean IsMultiParadigma;

	public Linguagem(int pIdLinguagem, String pNomeLinguagem, Enumeradores.TipoLinguagem pTipoLinguagem, boolean pIsMultiParadigma)
	{
		IdLinguagem = pIdLinguagem;
		NomeLinguagem = pNomeLinguagem;
		TipoLinguagem = pTipoLinguagem;
		IsMultiParadigma = pIsMultiParadigma;
	}
	public Linguagem()
	{

	}
	public Integer getIdLinguagem() {
		return IdLinguagem;
	}

	public Enumeradores.TipoLinguagem getTipoLinguagem() {
		return TipoLinguagem;
	}

	public String getNomeLinguagem() {
		return NomeLinguagem;
	}

	public boolean IsMultiParadigma() {
		return IsMultiParadigma;
	}



}