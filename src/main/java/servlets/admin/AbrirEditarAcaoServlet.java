package servlets.admin;

import dao.AcaoDAO;
import dao.UnidadeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import modelos.Acao;
import java.io.IOException;

@WebServlet("/admin/acaoMod")
public class AbrirEditarAcaoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParam = request.getParameter("id");

        if (idParam == null) {
            request.setAttribute("erro", "ID da ação não informado.");
            request.getRequestDispatcher("/admin/acaoListar.jsp").forward(request, response);
            return;
        }

        int id = Integer.parseInt(idParam);

        AcaoDAO acaoDAO = new AcaoDAO();
        Acao acao = acaoDAO.buscarPorId(id);

        if (acao == null) {
            request.setAttribute("erro", "Ação não encontrada.");
            request.getRequestDispatcher("/admin/acaoListar.jsp").forward(request, response);
            return;
        }

        request.setAttribute("unidades", new UnidadeDAO().listar());
        request.setAttribute("acao", acao);

        request.getRequestDispatcher("/admin/acaoMod.jsp").forward(request, response);
    }
}
