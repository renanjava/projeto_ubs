package ubs.swing;

import javax.swing.*;

import dao.jdbc.AtendimentoDAO;
import dao.jdbc.FunctionDAO;
import dao.jdbc.MedicoDAO;
import model.Atendimento;
import model.Medico;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaMedicoConsulta {
    public TelaMedicoConsulta(Medico medicoVisualizarConsultas) throws Exception {
    	
    	MedicoDAO medicoDAO = new MedicoDAO();
    	FunctionDAO functionDAO = new FunctionDAO();
    	medicoVisualizarConsultas = medicoDAO.findById(medicoVisualizarConsultas.getPk());
    	int quantidade = functionDAO.qtdPacienteAtendimentoPorEspecializacao(
    			medicoVisualizarConsultas.getNomeEsp());
    	

        // Cria uma janela JFrame
        JFrame janela = new JFrame("Tela com Lista de Objetos");

        // Configura o tamanho da janela
        janela.setSize(400, 300);

        // Fecha a janela quando o usuário clicar no botão Fechar
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Cria um JPanel para conter os componentes
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS)); // Layout vertical
        
        painel.add(new JLabel("Quantidade de consultas para "
        		+medicoVisualizarConsultas.getNomeEsp()
        		+": "+quantidade));

        // Cria uma lista de objetos
        AtendimentoDAO atendimentoDAO = new AtendimentoDAO();
        List<Atendimento> listaAtendimento = atendimentoDAO
        		.findByProfissional(medicoVisualizarConsultas.getNomeEsp());

        // Define a margem entre os objetos
        Insets margem = new Insets(10, 10, 10, 10);

        // Adiciona um JPanel (contendo JTextArea e botão) para cada objeto na lista
        for (Atendimento atendimentoPaciente : listaAtendimento) {
            JPanel objetoPanel = new JPanel();
            objetoPanel.setLayout(new BorderLayout());

            JTextArea textArea = new JTextArea(5, 30);
            textArea.setEditable(false);
            textArea.setLineWrap(true); // Habilita quebra de linha
            textArea.setWrapStyleWord(true); // Quebra de palavras
            textArea.append("CPF: " + atendimentoPaciente.getPk() + "\n");
            textArea.append("Profissional: " + atendimentoPaciente.getProfissional() + "\n");
            textArea.append("Problema: " + atendimentoPaciente.getProblema() + "\n");

            JScrollPane textAreaScrollPane = new JScrollPane(textArea); // Adiciona o JTextArea em um JScrollPane

            objetoPanel.add(textAreaScrollPane, BorderLayout.CENTER);

            // Adiciona margens ao JPanel
            objetoPanel.setBorder(BorderFactory.createEmptyBorder(
                    margem.top, margem.left, margem.bottom, margem.right));

            // Adiciona o JPanel ao painel principal
            painel.add(objetoPanel);
            painel.add(Box.createVerticalStrut(10)); // Espaço entre objetos
        }

        // Cria um JScrollPane para a lista de objetos
        JScrollPane scrollPane = new JScrollPane(painel);

        // Adiciona o JScrollPane à janela
        janela.add(scrollPane);

        // Torna a janela visível
        janela.setVisible(true);
    }
}