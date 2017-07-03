package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Contato;

public class ContatoDAO extends Conexao {
	public Contato createComentario(ResultSet rs) throws Exception {
		Contato c = new Contato(); // crio o objeto "vazio"
		// vou carregando meu objeto
		c.setId(rs.getInt(1));
		c.setNome(rs.getString(2));
		c.setEmail(rs.getString(3));
		c.setIdade(rs.getInt(4));
		c.setConheceu(rs.getString(5));
		c.setMensagem(rs.getString(6));
		return c;
	}
	
	public void save(Contato c) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		// tentativa
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("insert into contato values(null, ?, ?, ?, ?, ?)");
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getEmail());
			stmt.setInt(3, c.getIdade());
			stmt.setString(4, c.getConheceu());
			stmt.setString(5, c.getMensagem());

			int flag = stmt.executeUpdate();
			
			if(flag == 0)
				throw new SQLException("Erro ao inserir no banco");
			
		// alternativa
		}catch (Exception e) {
			e.printStackTrace();
		// obrigatorio
		} finally {
			if(stmt != null)
				stmt.close();
			if(conn != null)
				conn.close();
		}
	}
	

}
