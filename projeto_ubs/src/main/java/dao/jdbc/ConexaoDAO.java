package dao.jdbc;

import java.sql.Connection;

import conexao.postgres.SingleConnection;

public abstract class ConexaoDAO {
	protected Connection conexao;

	public ConexaoDAO() {
		conexao = SingleConnection.getConnection();
	}
}
