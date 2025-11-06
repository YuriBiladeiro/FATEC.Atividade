package Controller;

import DAO.Empresa;
import VO.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jean
 */
public class ProdutoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // mexendo neste
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        try ( PrintWriter out = response.getWriter()) {
            int operacao = Integer.parseInt(request.getParameter("operacao"));
            Empresa e = new Empresa(); //DAO
            switch (operacao) {
                case 1: // listagem
                    request.setAttribute("lista", e.buscarProdutos());
                    RequestDispatcher rd = request.getRequestDispatcher("/exibe_produtos.jsp");
                    rd.forward(request, response);
                    break;
                case 2: // exclusão
                    int id = Integer.parseInt(request.getParameter("id"));
                    e.excluir(id);
                    response.sendRedirect("ProdutoController?operacao=1");
                    break;
                case 3: // solicitando alterar
                    id = Integer.parseInt(request.getParameter("id"));
                    request.setAttribute("produto", e.localizarRegistro(id));
                    RequestDispatcher r = request.getRequestDispatcher("/alteracao.jsp");
                    r.forward(request, response);                    
                case 4: // efetivando a alteração
                    String nome = request.getParameter("nome");
                    double valor = Double.parseDouble(request.getParameter("valor"));
                    int codigo = Integer.parseInt(request.getParameter("id"));
                    Produto produto = new Produto();
                    produto.setId(codigo);
                    produto.setNome(nome);
                    produto.setValor(valor);
                    e.alterar(produto);
                    response.sendRedirect("ProdutoController?operacao=1");             
                    break;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
