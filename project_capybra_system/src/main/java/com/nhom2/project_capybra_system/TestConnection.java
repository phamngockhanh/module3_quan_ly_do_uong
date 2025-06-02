package com.nhom2.project_capybra_system;

import com.nhom2.project_capybra_system.util.DatabaseUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet(value = "/test-connection")
public class TestConnection extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try (Connection conn = DatabaseUtil.getConnection()) {
            if (conn != null && !conn.isClosed()) {
                out.println("<h2>Kết nối database thành công!</h2>");
            } else {
                out.println("<h2>Không thể kết nối đến database!</h2>");
            }
        } catch (Exception e) {
            out.println("<h2>Lỗi khi kết nối database:</h2>");
            out.println("<pre>" + e.getMessage() + "</pre>");
            e.printStackTrace(out);
        }
    }
}
