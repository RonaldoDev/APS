package com.devbattle.view;

import javax.swing.*;

/**
 * Created by ronal on 25/06/2017.
 */
public class JOptionPaneMultiInput {
    public static String[] main(String[] args) {
        JTextField xField = new JTextField(15);
        JTextField yField = new JTextField(15);
        String[] arrJogServer =  new String[2];
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Servidor:"));
        myPanel.add(xField);
        myPanel.add(Box.createVerticalStrut(15)); // a spacer
        myPanel.add(new JLabel("Nome Jogador:"));
        myPanel.add(yField);

        boolean _isValidado = false;
        do {
            int result = JOptionPane.showConfirmDialog(null, myPanel,
                    "Entre com nome do Servidor e do Jogador", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                arrJogServer[0] = xField.getText();
                arrJogServer[1] = yField.getText();
            }
            if(arrJogServer[0].length() == 0  || arrJogServer[1].length() == 0)
            {
                 JOptionPane.showMessageDialog(myPanel, "Os nomes não podem ser em  branco");
            }
            else
            {
                _isValidado = true;
            }
        } while (!_isValidado);
        return arrJogServer;
    }
}
