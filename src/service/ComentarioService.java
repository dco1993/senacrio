package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Comentario;
import persistence.ComentarioDAO;

public class ComentarioService {
	
	ComentarioDAO comt = new ComentarioDAO();
	
	public boolean save(Comentario C) {
		try {
			comt.save(C);
			return Boolean.TRUE;
		} catch (SQLException e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
	}
	
	public List<Comentario> getPublicado() {
		List<Comentario> comentarios;
		try {
			comentarios = comt.getPublicado();
			return comentarios;
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Comentario>();
		}
	}
	
	public List<Comentario> getNaoPublicado() {
		List<Comentario> comentarios;
		try {
			comentarios = comt.getNaoPublicado();
			return comentarios;
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Comentario>();
		}
	}

}
