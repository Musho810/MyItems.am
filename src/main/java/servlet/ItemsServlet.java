package servlet;

import manager.ItemManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/items/show")
public class ItemsServlet extends HttpServlet {
    ItemManager itemManager = new ItemManager();
    int defaultCategoryId = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (defaultCategoryId == Integer.parseInt(req.getParameter("categoryId"))) {
            req.setAttribute("itemslist", itemManager.getLast20());
            req.getRequestDispatcher("/").forward(req, resp);
        } else {
            req.setAttribute("itemslist", itemManager.getLastByCategory((Integer.parseInt(req.getParameter("categoryId")))));
            req.getRequestDispatcher("/").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
