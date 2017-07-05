package app;

import entity.Comentario;
import service.ComentarioService;

public class TesteComentario {

	public static void main(String[] args) {

		ComentarioService comentarios = new ComentarioService();
		
		comentarios.save(new Comentario("Zackias", "Teste3", "Ramos", 5, "S"));
		
		System.out.println(comentarios.getPublicado());

	}

}
