package dao.jdbc;

import ubs.exceptions.ObjetoNaoEncontradoException;
import ubs.exceptions.ObjetoSemDadosException;
import ubs.interfaces.OperacoesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.postgres.SingleConnection;
import model.Medicamento;
import model.Paciente;

public class MedicamentoDAO extends ConexaoDAO implements OperacoesDAO<Medicamento> {

	public MedicamentoDAO() {
		super();
	}

	public void create(Medicamento medicamentoSalvar) throws Exception {

		if (medicamentoSalvar == null)
			throw new ObjetoSemDadosException();

		try {

			if (findByCategoryAndName(medicamentoSalvar.getCategoria().getNomeCategoria(), medicamentoSalvar.getNome()))
				update(medicamentoSalvar);

		} catch (ObjetoNaoEncontradoException e0) {
			String sql = "INSERT INTO MEDICAMENTO(NOME, QUANTIDADE, CATEGORIA) "
									+ "VALUES(?, ?, ?)";

			try {
				PreparedStatement insert = conexao.prepareStatement(sql);
				insert.setString(1, medicamentoSalvar.getNome());
				insert.setInt(2, medicamentoSalvar.getQuantidade());
				insert.setString(3, medicamentoSalvar.getCategoria().getNomeCategoria());

				insert.execute();
				conexao.commit();

			} catch (Exception e1) {
				try {
					conexao.rollback();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				e1.printStackTrace();
			}
		}

	}

	public List<Medicamento> findAll() throws Exception {
		List<Medicamento> lista = new ArrayList<Medicamento>();
		String sql = "SELECT * FROM PACIENTE";

		PreparedStatement statement = conexao.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();

		while (resultado.next()) {
			Medicamento buscado = new Medicamento();
			// buscado.setCategoria(resultado.getString("CATEGORIA"));
			buscado.setNome(resultado.getString("NOME"));
			lista.add(buscado);
		}
		return lista;
	}

	public void update(Medicamento medicamentoAlterar) {
		String sql = "UPDATE MEDICAMENTO " + 
			"SET QUANTIDADE = QUANTIDADE + ? WHERE CATEGORIA = '"
				+ medicamentoAlterar.getCategoria().getNomeCategoria() 
				+ "' AND NOME = '" + medicamentoAlterar.getNome()
				+"'";
		try {
			PreparedStatement update = conexao.prepareStatement(sql);
			update.setInt(1, medicamentoAlterar.getQuantidade());
			update.execute();
			conexao.commit();
		} catch (SQLException e) {
			try {
				conexao.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public boolean findByCategoryAndName(String categoria, String nome) throws Exception {
		String sql = "SELECT * FROM MEDICAMENTO WHERE CATEGORIA = " 
					+ "'" + categoria + "' AND NOME = '" + nome + "'";

		PreparedStatement statement = conexao.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();

		if (!resultado.next())
			throw new ObjetoNaoEncontradoException();

		return true;
	}

	public void delete(String codigo) {

	}

	public Medicamento findById(String chavePk) throws Exception {

		// String sql = "SELECT * FROM MEDICAMENTO " + "WHERE CATEGORIA = '" + chavePk +
		// "'";

		// PreparedStatement statement = conexao.prepareStatement(sql);
		// ResultSet resultado = statement.executeQuery();

		Medicamento medicamentoEncontrado = new Medicamento();

		// if (!resultado.next())
		// throw new ObjetoNaoEncontradoException();

		return medicamentoEncontrado;
	}
}
