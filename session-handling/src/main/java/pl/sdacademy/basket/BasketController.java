package pl.sdacademy.basket;

import pl.sdacademy.articles.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by adam.
 */
@WebServlet(name = "BasketController", value = "/basket")
public class BasketController extends HttpServlet {

    private BasketService basketService;

    public BasketController() {
        this.basketService = new BasketService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        Map<Long, BigDecimal> selectedArticlesQuantityMap = (Map<Long, BigDecimal>) request.getSession().getAttribute
                ("selectedArticles");
        if (selectedArticlesQuantityMap == null) {
            selectedArticlesQuantityMap = new HashMap<>();
        }
        Map<Article, BigDecimal> articleQuantityMap = basketService.createArticleQuantityMap
                (selectedArticlesQuantityMap);
        PrintWriter writer = response.getWriter();
        writer.println("<html>\n" +
                "<body>\n" +
                "   <p>Basket content</p>\n" +
                "   <table>\n" +
                "       <tr>\n" +
                "           <th>Article name</th>\n" +
                "           <th>Quantity</th>\n" +
                "       </tr>\n" +
                getArticleQuantityMapAsHtmlTableRows(articleQuantityMap) +
                "   </table>\n" +
                "   <br />\n" +
                "   <a href=\"/articles\">Add another article</a>\n" +
                "</body>\n" +
                "</html>");
    }

    private String getArticleQuantityMapAsHtmlTableRows(Map<Article, BigDecimal> articleQuantityMap) {
        return articleQuantityMap.entrySet().stream()
                .map(e -> "<tr><th>" + e.getKey().getName() + "</th><th>" + e.getValue() + "</th></tr>")
                .collect(Collectors.joining("\n"));
    }
}
