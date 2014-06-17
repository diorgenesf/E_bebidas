<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<sql:query var="produto" dataSource="jdbc/ebebidas">
    SELECT * FROM PRODUTO WHERE idproduto = ?
    <sql:param value="${pageContext.request.queryString}"/>
</sql:query>
    
<sql:query var="catprod" dataSource="jdbc/ebebidas">
    SELECT * FROM CATEGORIA WHERE idcategoria = ?
    <sql:param value="${produto.rows[0].idcategoria}"/>
</sql:query>

<sql:query var="categories" dataSource="jdbc/ebebidas">
    SELECT * FROM CATEGORIA
</sql:query>

<div class="row">    
    <div class="col-left sidebar col-xs-3">

        <div class="block block-list block-manufacturer first">
            <div class="block-title base-background"><span>Categorias</span></div>
            <div class="block-content">
                <ul>
                    <c:forEach var="category" items="${categories.rows}">
                        <li class="item">
                            <a href="categoria?id=${category.idcategoria}">${category.titulo}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>

        <div class="delivery">
            <img src="images/frete.jpg">
        </div>

    </div>

    <div class="col-main col-xs-9">        
        <div class="page-title category-title breadcrumb">
            <a href="http://localhost:8080/E_bebidas/">Home</a> > <a href="http://localhost:8080/E_bebidas/categoria?id=${catprod.rows[0].idcategoria}"> ${catprod.rows[0].titulo} </a>  > ${produto.rows[0].titulo}
        </div>
        <div class="product">
            <div class="compra">
                <div class="col-left col-xs-3">
                    <div class="row">
                        <div class="content-product-image bordered">
                            <img src="${initParam.productImagePath}${produto.rows[0].imagem}">
                        </div>
                    </div>
                </div>

                <div class="col-right col-xs-9 main-compra">                
                    <h2 class="nome">${produto.rows[0].titulo}</h2>
                    <div class="box-shopping">
                        <div class="preco-antigo">De R$ ${produto.rows[0].valor_unitario}</div>
                        <div class="preco-novo">Por R$ ${produto.rows[0].valor_unitario - produto.rows[0].desconto}</div>
                        <div class="comprar">
                            <div class="quantidade">
                                <span>Quantidade: </span>
                                <input type="number" min="1" value="1">
                            </div>
                            <input type="button" class="button btn-cart" value="+ Carrinho">
                        </div>
                    </div>
                </div>
            </div>
                    
            <div class="page-title category-title detalhes-title">
                <h2>Detalhes</h2>
            </div>
                    
            <div class="detalhes">  
                ${produto.rows[0].descricao}
            </div>
        
        </div>
           
    </div>
</div>