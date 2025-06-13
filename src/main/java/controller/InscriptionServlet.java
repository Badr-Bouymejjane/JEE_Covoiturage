package controller;

import dao.UtilisateurDao;
import model.Role;
import model.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UtilisateurDao utilisateurDao = new UtilisateurDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Utilisateur nouvelUtilisateur = new Utilisateur();
        nouvelUtilisateur.setNom(request.getParameter("nom"));
        nouvelUtilisateur.setPrenom(request.getParameter("prenom"));
        nouvelUtilisateur.setEmail(request.getParameter("email"));
        nouvelUtilisateur.setMotDePasse(request.getParameter("motDePasse"));
        nouvelUtilisateur.setRole(Role.valueOf(request.getParameter("role").toUpperCase()));
        
        try {
            utilisateurDao.creerUtilisateur(nouvelUtilisateur);
            response.sendRedirect("connexion.jsp?success=true");
        } catch (SQLException e) {
            if (e.getSQLState().equals("23505")) {
                request.setAttribute("erreur", "Cette adresse email est déjà utilisée.");
            } else {
                request.setAttribute("erreur", "Une erreur technique est survenue. Veuillez réessayer.");
            }
            request.getRequestDispatcher("inscription.jsp").forward(request, response);
        }
    }
}