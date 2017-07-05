package com.devbattle.domain;
import com.devbattle.utils.Enumeradores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Carta implements Serializable {


	private int IdCarta;
	private List<Linguagem> Linguagens;
	private String Texto;
	private String Ajuda;
	private String Imagem;
	private String ToolTip;
	private Enumeradores.TipoLinguagem TipoLinguagem;

	public int getIdCarta() {
		return IdCarta;
	}

	public Carta(int pIdCarta, ArrayList<Linguagem> pLinguagem, String pTexto, String pToolTip , String pAjuda, String pImagem, Enumeradores.TipoLinguagem pTipoLinguagem){
		setIdCarta(pIdCarta);
		setLinguagens(pLinguagem);
		setTexto(pTexto);
		setAjuda(pAjuda);
		setToolTip(pToolTip);
		setImagem(pImagem);
		TipoLinguagem = pTipoLinguagem;

	}
	public void setIdCarta(int idCarta) {
		IdCarta = idCarta;
	}

	public List<Linguagem> getLinguagens() {
		return Linguagens;
	}

	public void setLinguagens(List<Linguagem> linguagem) {
		Linguagens = linguagem;
	}

	public String getTexto() {
		return Texto;
	}

	public void setTexto(String texto) {
		Texto = texto;
	}

	public String getAjuda() {
		return Ajuda;
	}

	public void setAjuda(String ajuda) {
		Ajuda = ajuda;
	}

	public String getImagem() {
		return Imagem;
	}

	public void setImagem(String imagem) {
		Imagem = imagem;
	}

	public String getTipoLinguagem() {
		return TipoLinguagem.toString();
	}

	public String getToolTip() {
		return ToolTip;
	}

	public void setToolTip(String toolTip) {
		ToolTip = toolTip;
	}
}