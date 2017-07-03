package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Equipe;

public class EquipeDAO extends Conexao {
	public Equipe createEquipe(ResultSet rs) throws Exception {
		Equipe e = new Equipe(); // crio o objeto "vazio"
		// vou carregando meu objeto
		e.setId(rs.getInt(1));
		e.setNome(rs.getString(2));
		e.setDesc(rs.getString(3));
		e.setFoto(rs.getString(4));
		e.setTempoprof(rs.getDate(5));
		return e;
	}
	
	public void save(Equipe e) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		// tentativa
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("insert into equipe values(null,?,?,?,?)");
			stmt.setString(1, e.getNome());
			stmt.setString(2, e.getDesc());
			stmt.setString(3, e.getFoto());
			stmt.setDate(4, e.getTempoprof());
			
			int flag = stmt.executeUpdate();
			
			if(flag == 0)
				throw new SQLException("Erro ao inserir no banco");
			
		// alternativa
		}catch (Exception ex) {
			ex.printStackTrace();
		// obrigatorio
		} finally {
			if(stmt != null)
				stmt.close();
			if(conn != null)
				conn.close();
		}
	}
	
	public List<Equipe> lista() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Equipe> equipe = new ArrayList<Equipe>();
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select * from service");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				equipe.add(createEquipe(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Equipe>();
		}
		return equipe;
	}
	
	public Equipe busca(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select * from service where id = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				return createEquipe(rs);
			}
		} catch (Exception e) {

		}
		return null;
	}
	
}
