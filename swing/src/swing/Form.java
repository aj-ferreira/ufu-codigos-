/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swing;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Amand
 */
public class Form extends JFrame implements ActionListener {
    
    protected static JLabel lbNome,lbCpf,lbData,lbSexo,lbConta,lbSenha,lbEmail,lbNoticiaCkBx; //info antes da caixa de texto
    protected static  JTextField campoNome,campoCpf,campoData,campoConta,campoSenha,campoEmail;
    protected static JButton btnSalvar,btnCancelar;
    protected static JCheckBox checkNovidades;
    protected static JComboBox comboSexo;
    protected static String[] nomes = {"Feminino","Masculino"};
    //super("Janelaaa");
    public Form(){
    setTitle("Preencher");
    setSize(400, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    lbNome        = new JLabel("Nome: ");
    lbCpf         = new JLabel("CPF: ");
    lbData        = new JLabel("Data de Nascimento: ");
    lbSexo        = new JLabel("Sexo");
    lbConta       = new JLabel("Numero da conta: ");
    lbSenha       = new JLabel("Senha: ");
    lbEmail       = new JLabel("Email: ");
    //lbNoticiaCkBx = new JLabel("Desejo receber noticias");
    campoNome     = new JTextField(20);
    campoCpf      = new JTextField(15);
    campoData     = new JTextField(8);
    campoConta    = new JTextField(10);
    campoSenha    = new JTextField(20);
    campoEmail    = new JTextField(20);
    btnSalvar     = new JButton("Salvar");
    btnCancelar   = new JButton("Cancelar");
    comboSexo     = new JComboBox(nomes);
    checkNovidades = new JCheckBox("Desejo receber noticias");
    
    JPanel panelF = new JPanel(new GridLayout(18,2));
    panelF.add(lbNome);
    panelF.add(campoNome);
    panelF.add(lbCpf);
    panelF.add(campoCpf);
    panelF.add(lbData);
    panelF.add(campoData);
    panelF.add(lbSexo);
    panelF.add(comboSexo);
    panelF.add(lbConta);
    panelF.add(campoConta);
    panelF.add(lbSenha);
    panelF.add(campoSenha);
    panelF.add(lbEmail);
    panelF.add(campoEmail);
    panelF.add(checkNovidades);
    panelF.add(btnSalvar);
    panelF.add(btnCancelar);
    btnSalvar.addActionListener(this);
    add(panelF);
    
    setVisible(true);
    //fazercheckbox e adicionar
    //add botoes de salvar e  cancelar
    
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSalvar)
        {
         System.out.println("**clicou em salvar**");
         //salvar informações no arquivo
         String nome  = campoNome.getText();
         String cpf   = campoCpf.getText();
         String data  = campoData.getText();
         String sexo  = (String) comboSexo.getSelectedItem();
         String conta = campoConta.getText();
         String senha = campoSenha.getText();
         String email = campoEmail.getText();
         try
         {
             File arquivo = new File("dados.txt");
             FileWriter fileWriter = new FileWriter(arquivo,true);
             BufferedWriter writer = new BufferedWriter(fileWriter);
             writer.write("CPF:"+cpf+"| Nome:"+nome+" Data:"+data+" Sexo:"+sexo+
                     " Conta:"+conta+" Senha:"+senha+" Email:"+email);
            writer.newLine();
            writer.close();
            //JOptionPane.showMessageDialog(panelF,"Cadastro salvo");
            System.out.println("**salvou**");
         }catch(IOException ex)
         {
             ex.printStackTrace();
         }
        }else if(e.getSource() == btnCancelar)
        {
            
        }
    }
}
