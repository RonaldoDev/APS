package com.devbattle.domain;

import com.devbattle.model.Database;

import javax.xml.crypto.Data;
import java.text.MessageFormat;
import java.util.List;

/**
 * Created by ronal on 25/06/2017.
 */
public class MensagemException {
    private int IdMensagem;
    private String CorpoMensagem;
    private List<MensagemException> Msg;

    public MensagemException(int pIdMensagem, String pCorpoMensagem )
    {
        IdMensagem = pIdMensagem;
        CorpoMensagem = pCorpoMensagem;
        Msg = Database.getMensagens();
    }

    public int getIdMensagem() {
        return IdMensagem;
    }

    public void setIdMensagem(int idMensagem) {
        IdMensagem = idMensagem;
    }

    public String getCorpoMensagem() {
        return CorpoMensagem;
    }

    public void setCorpoMensagem(String corpoMensagem) {
        CorpoMensagem = corpoMensagem;
    }
    public String getMensagemException(int pIdMsg)
    {
        return Msg.stream().filter(f -> f.getIdMensagem() == pIdMsg).findFirst().get().getCorpoMensagem();
    }
    public  String getMensagemException(int pIdMsg, String pParametro)
    {
        String retorno = Msg.stream().filter(f -> f.getIdMensagem() == pIdMsg).findFirst().get().getCorpoMensagem();
        return MessageFormat.format(retorno,pParametro);
    }
    public  String getMensagemException(int pIdMsg, String pParametro1, String pParametro2)
    {
        String retorno = Msg.get(pIdMsg).getCorpoMensagem();
        return MessageFormat.format(retorno, new Object[]{pParametro1, pParametro2});
    }
}
