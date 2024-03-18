package StoneBridgeStudios.MythMachine.MythMachine;

public  class resetpasswd extends HttpServlet{
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String cpassword = request.getParameter("cpassword");
        String token = request.getParameter("token");
        String message = "";
        if (email.isEmpty() || password.isEmpty() || cpassword.isEmpty() || token.isEmpty()) {
            message = "Please fill all the fields";
            request.setAttribute("message", message);
            request.getRequestDispatcher("resetpassword.jsp").forward(request, response);
        } else if (!password.equals(cpassword)) {
            message = "Password and Confirm Password do not match";
            request.setAttribute("message", message);
            request.getRequestDispatcher("resetpassword.jsp").forward(request, response);
        } else {
            try {
                Connection con = DBConnection.createConnection();
                PreparedStatement ps = con.prepareStatement("select * from users where email=? and token=?");
                ps.setString(1, email);
                ps.setString(2, token);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    PreparedStatement ps1 = con.prepareStatement("update users set password=?, token=? where email=?");
                    ps1.setString(1, password);
                    ps1.setString(2, "");
                    ps1.setString(3, email);
                    int i = ps1.executeUpdate();
                    if (i > 0) {
                        message = "Password reset successfully";
                        request.setAttribute("message", message);
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    } else {
                        message = "Password reset failed";
                        request.setAttribute("message", message);
                        request.getRequestDispatcher("resetpassword.jsp").forward(request, response);
                    }
                } else {
                    message = "Invalid email or token";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("resetpassword.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
