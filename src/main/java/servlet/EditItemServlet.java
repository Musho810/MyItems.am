package servlet;

import manager.CategoryManager;
import manager.ItemManager;
import model.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, //1 Mb
        maxFileSize = 1024 * 1024 * 10, // 10 Mb
        maxRequestSize = 1024 * 1024 * 100 // 100 Mb
)
@WebServlet(urlPatterns = "/myItems/edit")
public class EditItemServlet extends HttpServlet {
    private static final String IMAGE_PATH = "C:\\Users\\Toshiba\\IdeaProjects\\MyItems.am\\projectimages\\";
    ItemManager itemManager = new ItemManager();
    CategoryManager categoryManager = new CategoryManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int itemId = Integer.parseInt(req.getParameter("itemId"));
        Item item = itemManager.getById(itemId);
        req.setAttribute("itemEdit", item);
        req.setAttribute("category", categoryManager.getAll());
        req.getRequestDispatcher("/WEB-INF/editItem.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int itemId = Integer.parseInt(req.getParameter("itemId"));
        String title = req.getParameter("title");
        double price = Double.parseDouble(req.getParameter("price"));
        int categoryId = Integer.parseInt(req.getParameter("category"));
        Part itemPicPart = req.getPart("picUrl");
        String fileName = null;
        if (itemPicPart.getSize() != 0) {
            long nanoTime = System.nanoTime();
            fileName = nanoTime + "_" + itemPicPart.getSubmittedFileName();
            itemPicPart.write(IMAGE_PATH + fileName);
        }
        HttpSession session = req.getSession();
        Item item = Item.builder()
                .id(itemId)
                .title(title)
                .price(price)
                .categoryId(categoryId)
                .picUrl(fileName)
                .userId(Integer.parseInt(String.valueOf(session.getAttribute("userId"))))
                .build();
        itemManager.editItem(item);
        resp.sendRedirect("/myItems");
    }
}
