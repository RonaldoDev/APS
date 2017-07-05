package com.devbattle.view;

import com.devbattle.domain.Carta;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by ronal on 23/06/2017.
 */
public class JCarta extends JLabel implements Cloneable {
    private int IdCarta;
    private Carta Carta;
    private String Ajuda;
    ImageIcon ii;
    private boolean IsSelecionado;
    private boolean MostraCarta;
    public JCarta (boolean pIsMostraCarta, String pNomeCarta)
    {
        MostraCarta = pIsMostraCarta;
        setSize(161,245);
        setName(pNomeCarta);
        IsSelecionado = false;
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JCartaListener(e);
            }
        });
        virarCarta(pIsMostraCarta);
        this.setVerticalAlignment(TOP);
        MontarCarta();
    }
    private void virarCarta(boolean pMostrarCarta)
    {
        if(pMostrarCarta == true){
            ii = new ImageIcon(getClass().getResource("/com/devbattle/utils/img/carta_desvirada.png"));
        }
        else{
            ii = new ImageIcon(getClass().getResource("/com/devbattle/utils/img/carta_virada.png"));
        }
        super.setIcon(ii);
    }
    private void MontarCarta() {
        this.setVerticalTextPosition(SwingConstants.BOTTOM);
        this.setHorizontalTextPosition(0);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
    public void mostrarDica()
    {
        setText("<html>" + Carta.getTexto() + "<br />Dica: " + Carta.getAjuda()+"</html>");
    }
    private void JCartaListener(MouseEvent e) {
        if(!IsSelecionado) {
            this.setBorder(new LineBorder(new Color(255, 165, 0)));
            IsSelecionado = true;
            getToolTipText();
        }
        else{
            this.setBorder(null);
            IsSelecionado = false;
        }
    }

    public JCarta getCarta() {
        return this;
    }

    public JCarta setCarta(Carta pCarta) {
        IdCarta = pCarta.getIdCarta();
        Carta = pCarta;
        setText(Carta.getTexto());
        ii = new ImageIcon(getClass().getResource(Carta.getImagem()));
        setIcon(ii);
        setToolTipText(Carta.getTipoLinguagem() + ":" + Carta.getToolTip());
        MostraCarta = false;
        return this;
    }
    public boolean isSelecionado()
    {
        return IsSelecionado;
    }
    public int getIdCarta()
    {
        return IdCarta;
    }
    public void setMostraCarta()
    {
        MostraCarta = true;
        virarCarta(MostraCarta);
    }
    public void setEscondeCarta()
    {
        MostraCarta = false;
        virarCarta(MostraCarta);
    }
    public boolean getMostraCarta()
    {
        return  MostraCarta;
    }
    public Carta getCartaBaralho()
    {
        return  Carta;
    }


}
