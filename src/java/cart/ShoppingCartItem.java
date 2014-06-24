/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cart;

import entity.Produto;
import java.math.BigDecimal;

/**
 *
 * @author tgiunipero
 */
public class ShoppingCartItem {

    Produto product;
    int quantity;

    public ShoppingCartItem(Produto product) {
        this.product = product;
        quantity = 1;
    }

    public Produto getProduto() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void incrementQuantity() {
        quantity++;
    }

    public void decrementQuantity() {
        quantity--;
    }

    public double getTotal() {
        double amount = 0;
        BigDecimal Price = product.getValorUnitario().subtract(product.getDesconto());
        amount = (this.getQuantity() * Price.doubleValue());
        return amount;
    }

}