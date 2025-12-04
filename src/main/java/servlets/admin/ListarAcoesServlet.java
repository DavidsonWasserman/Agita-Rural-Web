package servlets.admin;

import dao.AcaoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import modelos.Representante;
import modelos.Acao;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/acaoListar")
public class ListarAcoesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();
        Representante admin = (Representante) sessao.getAttribute("adminLogado");

        if (admin == null) {
            response.sendRedirect(request.getContextPath() + "/admin/loginadmin.jsp");
            return;
        }

        AcaoDAO dao = new AcaoDAO();

        List<Acao> acoes = dao.listar()
                .stream()
                .filter(a -> a.getRepresentantes() != null && a.getRepresentantes().contains(admin))
                .toList();

        request.setAttribute("acoes", acoes);

        request.getRequestDispatcher("/admin/acaoListar.jsp")
               .forward(request, response);
    }
}
