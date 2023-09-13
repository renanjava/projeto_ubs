package ubs.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.*;

import dao.jdbc.AtendimentoDAO;
import model.Paciente;
import ubs.enums.AreaMedico;

public class TelaPacienteConsulta extends JFrame{
	
	public TelaPacienteConsulta(Paciente usuario){
		
		SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("UBS - Consulta");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 230);

            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());

            JLabel comboBoxLabel = new JLabel("Selecione o profissional:");
            panel.add(comboBoxLabel, BorderLayout.NORTH);

            String[] items = {AreaMedico.PSICOLOGO.getAreaMedico(), 
            				  AreaMedico.PSIQUIATRA.getAreaMedico(),
            				  AreaMedico.DENTISTA.getAreaMedico(),
            				  AreaMedico.CIRURGIAO.getAreaMedico(),
            				  AreaMedico.DERMATOLOGISTA.getAreaMedico()};
            
            JComboBox<String> comboBox = new JComboBox<>(items);
            comboBox.setPreferredSize(new Dimension(150, 30));
            panel.add(comboBox, BorderLayout.CENTER);

            JPanel textAreaPanel = new JPanel(new BorderLayout());

            JLabel textAreaLabel = new JLabel("Digite seu problema:");
            textAreaPanel.add(textAreaLabel, BorderLayout.NORTH);

            JTextArea textArea = new JTextArea();
            textArea.setPreferredSize(new Dimension(180, 100));
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            JScrollPane scrollPane = new JScrollPane(textArea);
            textAreaPanel.add(scrollPane, BorderLayout.CENTER);
            
            JButton botaoSalvar = new JButton("Salvar");
            botaoSalvar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    AtendimentoDAO inserirNaFila = new AtendimentoDAO();
                    try {
						String codigoConsulta = inserirNaFila.create(usuario.getPk(), 
								textArea.getText(), (String)comboBox.getSelectedItem());
						
						JOptionPane.showMessageDialog(null, 
	                    		"Consulta cadastrada com "
	                    		+"sucesso, código: "+codigoConsulta);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
                    frame.dispose();
                }
            });
            
            textAreaPanel.add(botaoSalvar, BorderLayout.SOUTH);
            panel.add(textAreaPanel, BorderLayout.SOUTH);

            frame.add(panel);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}






