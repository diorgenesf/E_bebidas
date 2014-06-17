<div class="row">
    <div class="page-title no-capitalize category-title base-background">
        <h1>Carrinho de Compras</h1>
    </div>

    <table class="table table-bordered table-hover car-shopping">
        <thead>
            <tr>
                <th class="produto">Produto</th>
                <th class="nome">Nome</th>
                <th class="preco-unitario">Preço Unitário</th>
                <th class="quantidade">Quantidade</th>
                <th class="subtotal">Subtotal</th>
                <th class="remover">Remover</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><a href=""> <img src="images/drink-1.jpg"> </a></td>
                <td>Vinho Legal</td>
                <td>R$ 10,00</td>
                <td><input type="number" min="1" value="2"></td>
                <td>R$ 20,00</td>
                <td><a href="" class="btn-remove"></a></td>
            </tr>

        </tbody>
        <tfoot>
            <tr class="first last">
                <td colspan="6" class="a-right last">
                    <input class="button btn-cart" type="submit" value="Finalizar Compra">
                    <input class="button btn-cart" type="button" value="Continuar Comprando">
                    <input class="button btn-cart" type="button" value="Limpar Carrinho" >
                </td>
            </tr>
        </tfoot>
    </table>

</div>