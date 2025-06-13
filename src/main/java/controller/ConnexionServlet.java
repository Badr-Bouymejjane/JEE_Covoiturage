package controller;

import dao.UtilisateurDao;
import model.Utilisateur;
import util.PasswordUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UtilisateurDao utilisateurDao = new UtilisateurDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String plainPassword = request.getParameter("motDePasse");

        Utilisateur user = utilisateurDao.findByEmail(email);

        if (user != null && PasswordUtils.checkPassword(plainPassword, user.getMotDePasse())) {
            HttpSession session = request.getSession();
            user.setMotDePasse(null);
            session.setAttribute("utilisateur", user);
            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("erreur", "Email ou mot de passe incorrect.");
            request.getRequestDispatcher("connexion.jsp").forward(request, response);
        }
    }
}