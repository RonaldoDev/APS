package com.devbattle.domain;

import br.ufsc.inf.leobr.cliente.Jogada;
import com.devbattle.domain.Mesa;

import java.io.Serializable;

public class EstadoJogada implements Jogada {

	private int IdJogada;
	private Mesa Mesa;

	public Mesa getMesa(){
		return Mesa;
	}
	public void setMesa(Mesa pMesa){
		Mesa = pMesa;
	}

	public int getIdJogada() {
		return IdJogada;
	}

	public void setIdJogada(int idJogada) {
		IdJogada = idJogada;
	}
	public void incremetarIdJogada() {
		IdJogada++;
	}
}