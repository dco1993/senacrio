package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Admin;

public class AdminDAO extends Conexao {
	
	public Admin createAdmin(ResultSet rs) throws Exception {
		Admin a = new Admin(); // crio o objeto "vazio"
		// vou carregando meu objeto
		a.setId(rs.getInt(1));
		a.setLogin(rs.getString(2));
		a.setSenha(rs.getString(3));
		return a;
	}
	
	public void save(Admin a) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		// tentativa
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("insert into admin values(null, ?, md5(?))");
			stmt.setString(1, a.getLogin());
			stmt.setString(2, a.getSenha());
			
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
