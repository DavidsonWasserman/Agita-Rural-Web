package servlets.admin;

import java.io.IOException;
import java.util.List;

import dao.UnidadeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Unidade;

@WebServlet("/admin/acao/criar")
public class AbrirCriarAcaoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UnidadeDAO unidadeDAO = new UnidadeDAO();
        List<Unidade> unidades = unidadeDAO.listar();

        request.setAttribute("unidades", unidades);

        request.getRequestDispatcher("/admin/acaoCriar.jsp")
               .forward(request, response);
    }
}
