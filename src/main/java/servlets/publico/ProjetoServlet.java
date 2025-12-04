package servlets.publico;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Projeto;

import java.io.IOException;

import dao.ProjetoDAO;

@WebServlet("/projeto")
public class ProjetoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProjetoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("id");

        if (idParam == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID do projeto não informado.");
            return;
        }
        
        int id;
        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido.");
            return;
        }
        
        ProjetoDAO projetoDAO = new ProjetoDAO();
        Projeto projeto = projetoDAO.getPorId(id);
        
        if (projeto == null) {
        	response.sendError(HttpServletResponse.SC_NOT_FOUND, "Projeto não encontrado");
            return;
        }
        
        request.setAttribute("projeto", projeto);
        
        request.getRequestDispatcher("publico/projeto.jsp").forward(request, response);
	}

}
