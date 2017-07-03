package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Servico;

public class ServicoDAO extends Conexao {
	
		public Servico createServico(ResultSet rs) throws Exception {
			Servico s = new Servico(); // crio o objeto "vazio"
			// vou carregando meu objeto
			s.setId(rs.getInt(1));
			s.setImagem(rs.getString(2));
			s.setDescricao(rs.getString(3));
			s.setValor(rs.getDouble(4));
			return s;
		}
		
		public void save(Servico s) throws SQLException {
			Connection conn = null;
			PreparedStatement stmt = null;
			
			// tentativa
			try {
				conn = getConnection();
				stmt = conn.prepareStatement("insert into servico values(null, ?, ?, ?)");
				stmt.setString(1, s.getImagem());
				stmt.setString(2, s.getDescricao());
				stmt.setDouble(3, s.getValor());
				
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
		
		public List<Servico> lista() {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			List<Servico> servicos = new ArrayList<Servico>();
			try {
				conn = getConnection();
				stmt = conn.prepareStatement("select * from service");
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					servicos.add(createServico(rs));
				}
			} catch (Exception e) {
				e.printStackTrace();
				return new ArrayList<Servico>();
			}
			return servicos;
		}
		
		public Servico busca(String nome) {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			try {
				conn = getConnection();
				stmt = conn.prepareStatement("select * from service where nome like ?");
				stmt.setString(1, nome);
				rs = stmt.executeQuery();
				
				if(rs.next()) {
					return createServico(rs);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public Servico busca(int id) {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			try {
				conn = getConnection();
				stmt = conn.prepareStatement("select * from service where id = ?");
				stmt.setInt(1, id);
				rs = stmt.executeQuery();
				
				if(rs.next()) {
					return createServico(rs);
				}
			} catch (Exception e) {
				
			}
			return null;
		}
		
		public void edita(Servico s) throws SQLException {
			Connection conn = null;
			PreparedStatement stmt = null;
			
			//tentativa
			try{
				conn = getConnection();
				stmt = conn.prepareStatement("UPDATE SERVICO SET imagem=?, descricao=?, valor=? WHERE id=?");
				stmt.setString(1, s.getImagem());
				stmt.setString(1, s.getDescricao());
				stmt.setDouble(3, s.getValor());
				
			}catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(stmt != null)
					stmt.close();
				if(stmt != null);
					conn.close();
		}

	}

		public void deleta(Servico s) throws SQLException{
			Connection conn = null;
			PreparedStatement stmt = null;
			
			try {
				conn = getConnection();
				stmt = conn.prepareStatement("DELETE FROM SERVICO where id=?");
				stmt.setInt(1, s.getId());
				
			
			} catch (Exception e) {
				
			} finally {
				
			}
		}
}