package pl.sdacademy.basket;

import pl.sdacademy.articles.Article;
import pl.sdacademy.articles.ArticleService;

import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by adam.
 */
public class BasketService {

    private ArticleService articleService;

    BasketService() {
        this(new ArticleService());
    }

    BasketService(ArticleService articleService) {
        this.articleService = articleService;
    }

    Map<Article, BigDecimal> createArticleQuantityMap(Map<Long, BigDecimal> articleIdQuantityMap) {
        return articleIdQuantityMap.entrySet().stream()
                    .map(e -> new AbstractMap.SimpleEntry<>(articleService.findArticleById(e.getKey()), e.getValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

}
