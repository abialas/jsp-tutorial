package pl.sdacademy.articles;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by adam.
 */
public class ArticleService {

    private Collection<Article> availableArticles = Arrays.asList(
            new Article(1L, "Beer", new BigDecimal(4.5)),
            new Article(2L, "Mineral Water", new BigDecimal(2.2)),
            new Article(3L, "Orange Juice", new BigDecimal(5.1)),
            new Article(4L, "Milk", new BigDecimal(1.8))
    );

    Collection<Article> getAvailableArticles() {
        return availableArticles;
    }

    public Article findArticleById(Long articleId) {
        return availableArticles.stream()
                .filter(a -> a.getId().equals(articleId))
                .findFirst()
                .orElse(null);
    }
}
