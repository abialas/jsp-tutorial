package pl.sdacademy.articles;

import java.math.BigDecimal;

/**
 * Created by adam.
 */
public class ArticleItem {

    private Article article;
    private BigDecimal quantity;

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}
