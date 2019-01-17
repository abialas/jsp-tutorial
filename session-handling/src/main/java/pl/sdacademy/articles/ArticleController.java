package pl.sdacademy.articles;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by adam.
 */
@WebServlet(name = "ArticleController", value = "/articles")
public class ArticleController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        Collection<Article> articles = new ArticleService().getAvailableArticles();

        String articlesOptions = articles.stream()
                .map(article -> "<option value='" + article.getId() + "'>" + article.getName() + "</option>")
                .collect(Collectors.joining());

        String selectWithArticles = "<label for=\"user\">User:</label>" +
                "<select name=\"articleId\" id=\"articles\">" +
                articlesOptions +
                "</select>";

        PrintWriter writer = response.getWriter();
        writer.println("<html>\n" +
                "<body>\n" +
                "    <form action=\"/articles\" method=\"post\">\n" +
                selectWithArticles +
                "        <br />\n" +
                "        <label for=\"quantity\">Quantity:</label>\n" +
                "        <input type=\"number\" id=\"quantity\" name=\"quantity\">\n" +
                "        <br />\n" +
                "        <input type=\"submit\" value=\"Add\">\n" +
                "    </form>\n" +
                "    <br />\n" +
                "    <a href=\"/basket\">Go to basket</a>" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long articleId = Long.parseLong(request.getParameter("articleId"));
        BigDecimal quantity = new BigDecimal(request.getParameter("quantity"));

        Map<Long, BigDecimal> articleQuantityMap = (Map<Long, BigDecimal>) request.getSession().getAttribute("selectedArticles");
        if (articleQuantityMap == null) {
            articleQuantityMap = new HashMap<>();
            request.getSession().setAttribute("selectedArticles", articleQuantityMap);
        }
        articleQuantityMap.compute(articleId, (k, v) -> (v == null) ? quantity : v.add(quantity));

        PrintWriter writer = response.getWriter();
        writer.println("<html>\n" +
                "<body>\n" +
                "   <p>Article added to the basket</p>\n" +
                "   <br />\n" +
                "   <a href=\"/articles\">Add another article</a>" +
                "   <br />\n" +
                "   <a href=\"/basket\">Go to basket</a>" +
                "   <br />\n" +
                "</body>\n" +
                "</html>");
    }
}
