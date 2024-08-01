import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/vote")
public class VoteServlet extends HttpServlet {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/voting_system";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "password"; // Change to your MySQL password

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selectedOption = request.getParameter("vote");

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            // Update vote count
            String updateSQL = "UPDATE votes SET vote_count = vote_count + 1 WHERE option_name = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
                pstmt.setString(1, selectedOption);
                pstmt.executeUpdate();
            }

            // Fetch updated results
            String querySQL = "SELECT * FROM votes";
            StringBuilder results = new StringBuilder();
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(querySQL)) {
                while (rs.next()) {
                    results.append(rs.getString("option_name"))
                           .append(": ")
                           .append(rs.getInt("vote_count"))
                           .append(" votes<br>");
                }
            }

            // Set results as request attribute and forward to JSP
            request.setAttribute("results", results.toString());
            request.getRequestDispatcher("results.jsp").forward(request, response);

        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }
}
