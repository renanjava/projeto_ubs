package classes;

import java.sql.Connection;

import conexao.postgres.SingleConnection;

public abstract class PessoaDAO {
	protected Connection conexao;

	public PessoaDAO() {
		conexao = SingleConnection.getConnection();
	}
}
