package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Comentario;

public class ComentarioDAO extends Conexao {
	public Comentario createComentario(ResultSet rs) throws Exception {
		Comentario c = new Comentario(); // crio o objeto "vazio"
		// vou carregando meu objeto
		c.setId(rs.getInt(1));
		c.setNome(rs.getString(2));
		c.setComentario(rs.getString(3));
		c.setBairro(rs.getString(4));
		c.setNota(rs.getInt(5));
		return c;
	}
	
	public void save(Comentario c) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		// tentativa
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("insert into comentario values(null, ?, ?, ?, ?)");
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getComentario());
			stmt.setString(3, c.getBairro());
			stmt.setInt(4, c.getNota());
			
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
	
	public Comentario busca(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select * from comentario where id = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				return createComentario(rs);
			}
		} catch (Exception e) {

		}
		return null;
	}

	public void edita(boolean situacao) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		//tentativa
		try{
			conn = getConnection();
			stmt = conn.prepareStatement("UPDATE COMENTARIO SET ativo = ?");
			stmt.setBoolean(1, situacao);
			
			int flag = stmt.executeUpdate();
			
			if(flag == 0)
				throw new SQLException("Erro ao inserir no banco");
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(stmt != null)
				stmt.close();
			if(stmt != null);
				conn.close();
	}

}
}
