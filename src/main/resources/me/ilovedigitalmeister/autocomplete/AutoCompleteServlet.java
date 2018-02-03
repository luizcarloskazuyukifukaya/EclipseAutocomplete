package me.ilovedigitalmeister.autocomplete;

import javax.servlet.http.HttpServlet;

public class AutoCompleteServlet extends HttpServlet {

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

        String action = request.getParameter("action");
        // targetId is actuly a key that should match with the searching name in the first few letters.
        String targetId = request.getParameter("id");
        StringBuilder sb = new StringBuilder();

        if (targetId != null) {
            // doAutoCompleteGet
            doAutoCompleteGet(targetId.toLowerCase(), request, response);
        } else if(action == null ) {
            context.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

}
