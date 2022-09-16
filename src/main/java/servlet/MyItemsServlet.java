package servlet;

import manager.ItemManager;
import model.Item;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/myItems")

public class MyItemsServlet extends HttpServlet {

    private ItemManager itemManager = new ItemManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("active");
        List<Item> myitemlist = itemManager.getAllMyItem(user.getId());
        req.setAttribute("myItems", myitemlist);
        req.getRequestDispatcher("/WEB-INF/myItems.jsp").forward(req, resp);
    }


}
