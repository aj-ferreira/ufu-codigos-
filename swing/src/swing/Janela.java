/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swing;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Amand
 */
public class Janela extends JFrame implements ActionListener{
    
    
    private JButton botaoPreencher, botaoVisualizar;
    private JComboBox<String> comboCpfs = new JComboBox<>();
    Map<String,String> cpfsCadastrados = new HashMap<>();
    public Janela()
    {
        setTitle("Formulário");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        botaoPreencher = new JButton("Preencher dados: ");
        botaoVisualizar = new JButton("Visualizar Dados:");
        //botaoPreencher.setBounds(50,50,10,10);
        JPanel panel = new JPanel(new GridLayout(3,3));
        panel.add(botaoPreencher);
        panel.add(botaoVisualizar);
        botaoPreencher.addActionListener(this);
        botaoVisualizar.addActionListener(this);
        
        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==botaoPreencher)
        {
            //chama formulario
            new Form();
        }else if(e.getSource()==botaoVisualizar)
        {
            //abrir e ler arquivo
            //panel.add(comboCpfs);
            try
            {
                File arquivo = new File("dados.txt");
                BufferedReader reader = new BufferedReader(new FileReader(arquivo));
                String lido;
                cpfsCadastrados.clear(); // Limpar o mapa anterior
                comboCpfs.removeAllItems(); // Limpar o ComboBox
                while( (lido = reader.readLine())!=null)
                {
                    String[] partes = lido.split("\\|");
                    if(partes.length==2)
                    {
                        String cpf = partes[0].trim();
                        String dados = partes[1].trim();
                        cpfsCadastrados.put(cpf,dados);
                        comboCpfs.addItem(cpf);
                    }
                }
                reader.close();
                
                
            }catch(IOException ex)
            {
                ex.printStackTrace();
            }
            add(comboCpfs);
        }else if(e.getSource()==comboCpfs)
        {
            String selectedCpf = (String) comboCpfs.getSelectedItem();
            if (selectedCpf != null) 
            {
                String dados = cpfsCadastrados.get(selectedCpf);
                if (dados != null) 
                {
                     String[] partes = dados.split("\\|");
                    if (partes.length == 2) 
                    {
                        
//                        Form.campoNome.setText(partes[0].trim());
//                        Form.campoData.setText(partes[1].trim());
//                        Form.campoConta.setText(partes[3].trim());
//                        Form.campoSenha.setText(partes[4].trim());
//                        Form.campoEmail.setText(partes[5].trim());
                          System.out.println(partes[1]);
                    }
                }
            }
        }
    }
}