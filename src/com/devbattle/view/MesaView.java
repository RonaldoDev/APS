/*
 * Created by JFormDesigner on Fri Jun 23 00:52:27 BRT 2017
 */

package com.devbattle.view;

import java.awt.event.*;

import com.devbattle.domain.Carta;
import com.devbattle.domain.Jogador;
import com.devbattle.domain.Mesa;
import com.devbattle.utils.Enumeradores;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;


/**
 * @author unknown
 */
public class MesaView extends JFrame {
    private int NumeroCartaBaralho;
    private int NumeroCartaDescarte;
    private AtorJogador AtorJogador;
    private Enumeradores.EstadoPartida EstadoPartida;

    public MesaView(AtorJogador pAtorJogador) {
        initComponents();
        AtorJogador = pAtorJogador;

    }

    private void label6MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    public void mostrarMensagem(String pMensagem) {
        JOptionPane.showMessageDialog(this, pMensagem);

    }

    public void mostrarMensagemBarra(String pMensagem)
    {
        lblMensagem.setText(pMensagem);
        lblMensagem.setForeground(Color.BLUE);
    }
    private void btnDescarteActionPerformed(ActionEvent e)
    {
        JCarta _cartaSelecionada = validarCartaSeleciona("pnlMao");
        if(_cartaSelecionada != null)
        {
            AtorJogador.descartarPassar(_cartaSelecionada);
        }
    }
    private JCarta validarCartaSeleciona(String pPanelNome)
    {
        int contSelecionado = 0;
        Component[] cartas = pPanelNome == "pnlMao" ? pnlMao.getComponents() : pnlMesa.getComponents();
        JCarta cartaRetorno = new JCarta(true, "");
        for (int i = 0; i < cartas.length; i++) {
            if (cartas[i].getClass() == JCarta.class) {
                JCarta carta = (JCarta) cartas[i];
                if (carta.isSelecionado()) {
                    cartaRetorno = carta;
                    contSelecionado++;
                }
            }
        }
        if(contSelecionado > 1) {
            mostrarMensagem("Selecione somente uma carta para continuar.");
            return null;
        }
        else if(contSelecionado == 0){
            mostrarMensagem("Selecione ao menos uma carta.");
            return null;
        }
        else
            return cartaRetorno;
    }
    private ArrayList<String> RetornaValoresCombobox()
    {
        ArrayList<String> _valoresCombo = new ArrayList<>();
        int contSelecionado = 0;
        Component[] combos = pnlAcao.getComponents();
        for (int i = 0; i < combos.length; i++) {
            if (combos[i].getClass() == JComboBox.class) {
                JComboBox combo = (JComboBox) combos[i];
                if(combo.getSelectedItem().toString() != "")
                    _valoresCombo.add(combo.getSelectedItem().toString());
            }
        }
        if(_valoresCombo.stream().filter(f -> f.toString() == "").count() == 6)
        {
            mostrarMensagem("Preencha o(s) combobox com os valores correspondentes a suas cartas;");
            return null;
        }
        else
        {
            return _valoresCombo;
        }
    }
    private void btnComprarActionPerformed(ActionEvent e) {
        //travaBotoesMesa(Enumeradores.EstadoJogador.VezAdversario);
        JCarta cartaSelecionada = validarCartaSeleciona("pnlMesa");
        if(cartaSelecionada != null)
        {
            if(cartaSelecionada.getName() == "cartaDescarte")
                AtorJogador.comprarCartaDescarte();
            else
                AtorJogador.comprarCartaBaralho();
        }
    }

        private void btnBaterActionPerformed(ActionEvent e) {
            ArrayList<String> _valoresCombo = RetornaValoresCombobox();
            if(_valoresCombo != null)
            {
                JCarta cartaSelecionada = validarCartaSeleciona("pnlMao");
                if (cartaSelecionada != null) {
                    AtorJogador.descartarBater(cartaSelecionada, _valoresCombo);
                }
            }
            else
            {
                mostrarMensagem("Seleciona ao menos um valor na combobox");
            }
    }

    private void btnAjudasActionPerformed(ActionEvent e) {
        JCarta _cartaSelecionada = validarCartaSeleciona("pnlMao");
        if(_cartaSelecionada != null)
            if(AtorJogador.verificarSubtrairAjudaJogador())
                _cartaSelecionada.mostrarDica();
            else
                mostrarMensagem("Sem Dicas");

    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ronaldo Spranger
        menuBarPartida = new JMenuBar();
        pnlAcao = new JPanel();
        btnDescarte = new JButton();
        btnBater = new JButton();
        comboBox4 = new JComboBox();
        comboBox2 = new JComboBox();
        comboBox1 = new JComboBox();
        comboBox3 = new JComboBox();
        comboBox5 = new JComboBox();
        comboBox6 = new JComboBox();
        btnAjudas = new JButton();
        lblNumAjudas = new JLabel();
        panel3 = new JPanel();
        pnlMao = new JPanel();
        carta1 = new JCarta(false, "carta1");
        carta5 = new JCarta(false, "carta5");
        carta6 = new JCarta(false, "carta6");
        carta4 = new JCarta(false, "carta4");
        carta2 = new JCarta(false, "carta2");
        carta3 = new JCarta(false, "carta3");
        carta7 = new JCarta(false, "carta7");
        carta8 = new JCarta(false, "carta8");
        pnlMesa = new JPanel();
        cartaDescarte = new JCarta(false, "cartaDescarte");
        cartaMonte = new JCarta(false, "cartaBaralho");
        btnComprar = new JButton();
        lblNomeAdversario = new JLabel();
        lblMensagem = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        setJMenuBar(menuBarPartida);

        //======== pnlAcao ========
        {

            // JFormDesigner evaluation mark
            pnlAcao.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), pnlAcao.getBorder())); pnlAcao.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


            //---- btnDescarte ----
            btnDescarte.setText("Descartar e Passar");
            btnDescarte.addActionListener(e -> btnDescarteActionPerformed(e));

            //---- btnBater ----
            btnBater.setText("Descartar e Bater");
            btnBater.addActionListener(e -> btnBaterActionPerformed(e));

            //---- btnAjudas ----
            btnAjudas.setText("Ajuda");
            btnAjudas.addActionListener(e -> btnAjudasActionPerformed(e));

            //---- lblNumAjudas ----
            lblNumAjudas.setText("3");
            lblNumAjudas.setIconTextGap(10);
            lblNumAjudas.setHorizontalTextPosition(SwingConstants.CENTER);
            lblNumAjudas.setHorizontalAlignment(SwingConstants.CENTER);
            lblNumAjudas.setFont(lblNumAjudas.getFont().deriveFont(lblNumAjudas.getFont().getStyle() | Font.BOLD, 16f));

            GroupLayout pnlAcaoLayout = new GroupLayout(pnlAcao);
            pnlAcao.setLayout(pnlAcaoLayout);
            pnlAcaoLayout.setHorizontalGroup(
                pnlAcaoLayout.createParallelGroup()
                    .addGroup(pnlAcaoLayout.createSequentialGroup()
                        .addGroup(pnlAcaoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlAcaoLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlAcaoLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(pnlAcaoLayout.createParallelGroup()
                                    .addComponent(comboBox2)
                                    .addGroup(pnlAcaoLayout.createSequentialGroup()
                                        .addGroup(pnlAcaoLayout.createParallelGroup()
                                            .addGroup(pnlAcaoLayout.createSequentialGroup()
                                                .addComponent(lblNumAjudas, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnAjudas, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
                                            .addComponent(comboBox4, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, pnlAcaoLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(pnlAcaoLayout.createParallelGroup()
                                            .addComponent(comboBox1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnDescarte, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(btnBater, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(48, Short.MAX_VALUE))
                    .addGroup(pnlAcaoLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(pnlAcaoLayout.createParallelGroup()
                            .addComponent(comboBox6, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBox5, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(48, Short.MAX_VALUE))
            );
            pnlAcaoLayout.setVerticalGroup(
                pnlAcaoLayout.createParallelGroup()
                    .addGroup(pnlAcaoLayout.createSequentialGroup()
                        .addComponent(btnDescarte)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBater)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlAcaoLayout.createParallelGroup()
                            .addComponent(lblNumAjudas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlAcaoLayout.createSequentialGroup()
                                .addComponent(btnAjudas)
                                .addGap(0, 24, Short.MAX_VALUE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBox4, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBox5, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBox6, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
        }

        //======== panel3 ========
        {

            //======== pnlMao ========
            {

                //---- carta2 ----
                carta2.setVerticalTextPosition(SwingConstants.BOTTOM);
                carta2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

                GroupLayout pnlMaoLayout = new GroupLayout(pnlMao);
                pnlMao.setLayout(pnlMaoLayout);
                pnlMaoLayout.setHorizontalGroup(
                    pnlMaoLayout.createParallelGroup()
                        .addGroup(pnlMaoLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(carta1, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(carta2, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(carta3, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(carta4, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(carta5, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(carta6, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(carta7, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(carta8, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(251, Short.MAX_VALUE))
                );
                pnlMaoLayout.setVerticalGroup(
                    pnlMaoLayout.createParallelGroup()
                        .addGroup(pnlMaoLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(pnlMaoLayout.createParallelGroup()
                                .addComponent(carta8, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnlMaoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(carta2, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(carta3, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(carta4, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(carta5, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(carta6, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(carta7, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(carta1, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
            }

            GroupLayout panel3Layout = new GroupLayout(panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlMao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
            panel3Layout.setVerticalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlMao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }

        //======== pnlMesa ========
        {

            //---- cartaMonte ----
            cartaMonte.setIcon(new ImageIcon("C:\\Users\\ronal\\Documents\\UFSC\\Java\\APS\\src\\com\\devbattle\\utils\\img\\carta_virada.png"));

            //---- btnComprar ----
            btnComprar.setText("Comprar Carta");
            btnComprar.addActionListener(e -> btnComprarActionPerformed(e));

            GroupLayout pnlMesaLayout = new GroupLayout(pnlMesa);
            pnlMesa.setLayout(pnlMesaLayout);
            pnlMesaLayout.setHorizontalGroup(
                pnlMesaLayout.createParallelGroup()
                    .addGroup(pnlMesaLayout.createSequentialGroup()
                        .addGroup(pnlMesaLayout.createParallelGroup()
                            .addGroup(pnlMesaLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(cartaMonte, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(cartaDescarte, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlMesaLayout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(btnComprar, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(117, Short.MAX_VALUE))
            );
            pnlMesaLayout.setVerticalGroup(
                pnlMesaLayout.createParallelGroup()
                    .addGroup(pnlMesaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlMesaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(cartaMonte, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
                            .addComponent(cartaDescarte, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnComprar)
                        .addContainerGap(12, Short.MAX_VALUE))
            );
        }

        //---- lblNomeAdversario ----
        lblNomeAdversario.setText("Nome Advers\u00e1rio :");


        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(pnlMesa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblNomeAdversario, GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                                .addComponent(lblMensagem, GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE))))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 595, Short.MAX_VALUE)
                    .addComponent(pnlAcao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel3, GroupLayout.PREFERRED_SIZE, 1405, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(42, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(lblNomeAdversario)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblMensagem)
                            .addGap(20, 20, 20)
                            .addComponent(pnlMesa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(pnlAcao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(7, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
//
        JMenu partidaMenu = new JMenu("Partida");
        menuBarPartida.add(partidaMenu);
        JMenuItem connAction = new JMenuItem("Conectar");
        JMenuItem startAction = new JMenuItem("Iniciar Partida");
        JMenuItem logoutAction = new JMenuItem("Desconectar");
        partidaMenu.add(connAction);
        partidaMenu.add(startAction);
        partidaMenu.add(logoutAction);


        comboBox1.setModel(new DefaultComboBoxModel<>(Enumeradores.TipoCombobox.values()));
        comboBox2.setModel(new DefaultComboBoxModel<>(Enumeradores.TipoCombobox.values()));
        comboBox3.setModel(new DefaultComboBoxModel<>(Enumeradores.TipoCombobox.values()));
        comboBox4.setModel(new DefaultComboBoxModel<>(Enumeradores.TipoCombobox.values()));
        comboBox5.setModel(new DefaultComboBoxModel<>(Enumeradores.TipoCombobox.values()));
        comboBox6.setModel(new DefaultComboBoxModel<>(Enumeradores.TipoCombobox.values()));

        carta8.setVisible(false);
        cartaDescarte.setVisible(false);
        connAction.addActionListener(e -> clickConexao(e));
        startAction.addActionListener(e -> clickIniciar(e));
        travaBotoesMesa();

    }

    private void clickIniciar(ActionEvent e) {
        if(EstadoPartida == Enumeradores.EstadoPartida.TelaInicial) {
            mostrarMensagemBarra(AtorJogador.iniciarPartida().toString());
        }
        else
        {
            mostrarMensagem("Nao deu Bao");
        }
    }

    private void clickConexao(ActionEvent e) {
            String[] _resultado = JOptionPaneMultiInput.main(null);
            EstadoPartida = Enumeradores.EstadoPartida.TelaInicial;
            mostrarMensagemBarra(AtorJogador.conectar(_resultado[0], _resultado[1]).toString());
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ronaldo Spranger
    private JMenuBar menuBarPartida;
    private JPanel pnlAcao;
    private JButton btnDescarte;
    private JButton btnBater;
    private JComboBox comboBox4;
    private JComboBox comboBox2;
    private JComboBox comboBox1;
    private JComboBox comboBox3;
    private JComboBox comboBox5;
    private JComboBox comboBox6;
    private JButton btnAjudas;
    private JLabel lblNumAjudas;
    private JPanel panel3;
    private JPanel pnlMao;
    private JCarta carta1;
    private JCarta carta5;
    private JCarta carta6;
    private JCarta carta4;
    private JCarta carta2;
    private JCarta carta3;
    private JCarta carta7;
    private JCarta carta8;
    private JPanel pnlMesa;
    private JCarta cartaDescarte;
    private JCarta cartaMonte;
    private JButton btnComprar;
    private JLabel lblNomeAdversario;
    private JLabel lblMensagem;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public void travaBotoesMesa()
    {
            btnAjudas.setEnabled(false);
            btnBater.setEnabled(false);
            btnComprar.setEnabled(false);
            btnDescarte.setEnabled(false);
    }
    public void destravaBotoesMesa()
    {
        btnAjudas.setEnabled(true);
        btnBater.setEnabled(true);
        btnComprar.setEnabled(true);
        btnDescarte.setEnabled(true);
    }

    public void atualizaViewMesa(Mesa pMesa, Jogador pJogador) {
        try {
            //region Inicializar variaveis
            NumeroCartaBaralho = pMesa.getBaralho().size();
            NumeroCartaDescarte = pMesa.getDescarte().size();
            EstadoPartida = pMesa.getEstadoPartida();
            Component[] lstCartas = pnlMao.getComponents();
            Carta _descarteRodada = pMesa.getDescarteDaRodada();
            List<Carta> _maoJogadorDaVez = pMesa.getJogadores().stream().filter(f -> f.isJogadorDaVez() == true).findFirst().get().getMao();
            //endregion

            //region Controle de Botoes dentro de um Turno
            realizaControleBotoes(pJogador, _maoJogadorDaVez);
            //endregion

            //region  Controle de Labels na tela
            if(lblNomeAdversario.getText().equals("Nome Adversário :"))
                lblNomeAdversario.setText(lblNomeAdversario.getText() +  pJogador.getNomeAdversario());
            lblNumAjudas.setText(String.valueOf(pMesa.getJogadores().stream().filter(f -> f.getNomeJogador().equals(pJogador.getNomeJogador())).findFirst().get().getAjudas()));
            mostrarMensagemBarra(pJogador.isJogadorDaVez() ? "Sua vez." : "Vez do adversário.");
            //endregion

            //region Verifica baralho descarte == 0, esconde carta
            setVisibilidadeMonteDescarte();

            if (_descarteRodada != null) {
                cartaDescarte.setCarta(_descarteRodada);
                cartaDescarte.setMostraCarta();
                for (int i = 0; i < lstCartas.length; i++) {
                    if (lstCartas[i].getClass() == JCarta.class) {
                        if (((JCarta) lstCartas[i]).getIdCarta() == _descarteRodada.getIdCarta()) {
                            for (int j = i + 1; j < lstCartas.length; j++) {
                                JCarta _carta = ((JCarta) lstCartas[j]);
                                ((JCarta) lstCartas[i]).setCarta(_carta.getCartaBaralho());
                                ((JCarta) lstCartas[i]).setMostraCarta();

                            }
                            carta8.setVisible(false);

                        }
                    }

                }

                _descarteRodada = null;
            }


            if (_maoJogadorDaVez.size() == 8) {
                for (int i = 0; i < lstCartas.length; i++) {
                    if (lstCartas[i].getClass() == JCarta.class) {
                        if (!((JCarta) lstCartas[i]).isVisible()) {
                            ((JCarta) lstCartas[i]).setVisible(true);
                            ((JCarta) lstCartas[i]).setCarta(_maoJogadorDaVez.get(_maoJogadorDaVez.size() - 1));
                            if (!((JCarta) lstCartas[i]).getMostraCarta())
                                ((JCarta) lstCartas[i]).setMostraCarta();
                        }
                    }
                }
            }
            //region Virar Todas Cartas Primeira Rodada
            if(pJogador.isJogadorDaVez())
                if (EstadoPartida == Enumeradores.EstadoPartida.PrimeiraRodada) {
                    _maoJogadorDaVez.forEach(fr -> {
                        for (int i = 0; i < lstCartas.length; i++) {
                            if (lstCartas[i].getClass() == JCarta.class) {
                                if (!((JCarta) lstCartas[i]).getMostraCarta()) {
                                    ((JCarta) lstCartas[i]).setCarta(fr);
                                    ((JCarta) lstCartas[i]).setMostraCarta();
                                    break;
                                }
                            }
                        }
                    });
                    //endregion
                    //region Exibir Primeiro descarte

                    cartaDescarte = cartaDescarte.setCarta(pMesa.getDescarte().get(pMesa.getDescarte().size() - 1));
                    cartaDescarte.setMostraCarta();
                }
            //endregion
            if(pMesa.getDescarte().size() > 0)
            {
                cartaDescarte = cartaDescarte.setCarta(pMesa.getDescarte().get(pMesa.getDescarte().size() - 1));
                cartaDescarte.setMostraCarta();
            }
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }

    private void setVisibilidadeMonteDescarte() {
        if (NumeroCartaBaralho == 0)
            cartaMonte.setVisible(false);
        else
            cartaMonte.setVisible(true);
        if (NumeroCartaDescarte == 0)
            cartaDescarte.setVisible(false);
        else {
            cartaDescarte.setVisible(true);
        }
    }

    private void realizaControleBotoes(Jogador pJogador, List<Carta> _maoJogadorDaVez) {
        if (_maoJogadorDaVez.size() == 7 && pJogador.isJogadorDaVez()) {
            btnBater.setEnabled(false);
            btnDescarte.setEnabled(false);
            btnAjudas.setEnabled(false);
        } else if (pJogador.isJogadorDaVez()) {
            btnComprar.setEnabled(false);
            btnBater.setEnabled(true);
            btnDescarte.setEnabled(true);
            btnAjudas.setEnabled(true);
        }
    }
}
