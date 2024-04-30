/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDV.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.pdv.AberturaCaixa;
import view.pdv.PDV;

public class ControllerAbrirCaixa implements ActionListener {

    AberturaCaixa abreCaixaView;

    public ControllerAbrirCaixa(AberturaCaixa abreCaixaView) {
        this.abreCaixaView = abreCaixaView;
        
        this.abreCaixaView.getBotaoAbrirCaixa().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.abreCaixaView.getBotaoAbrirCaixa()) {
            PDV pontoDeVendaView = new PDV(null, true);
            ControllerPontoDeVenda controllerPontoDeVenda = new ControllerPontoDeVenda(pontoDeVendaView);
            pontoDeVendaView.getIdFuncionario().setText(this.abreCaixaView.getIdFuncionario().getText().toString().trim());
            abreCaixaView.dispose();
            pontoDeVendaView.setVisible(true);
            
        }

    }

}
