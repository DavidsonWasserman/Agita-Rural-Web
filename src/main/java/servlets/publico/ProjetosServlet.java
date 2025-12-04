package servlets.publico;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Projeto;

import java.io.IOException;
import java.util.List;

import dao.ProjetoDAO;


@WebServlet("/projetos")
public class ProjetosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProjetosServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeProjeto = (String) request.getParameter("nomeProjeto");
		
		ProjetoDAO projetoDAO = new ProjetoDAO();
		List<Projeto> projetos;
		
		if (nomeProjeto != null && !nomeProjeto.trim().isEmpty()) {
	        projetos = projetoDAO.buscarPorNome(nomeProjeto);
	    } else {
	        projetos = projetoDAO.listar();
	    }
		
		request.setAttribute("projetos", projetos);
		
		request.getRequestDispatcher("publico/projetos.jsp").forward(request, response);
	}
}
