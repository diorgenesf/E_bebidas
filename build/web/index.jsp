<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%--
<sql:query var="categories" dataSource="jdbc/ebebidas">
    SELECT * FROM CATEGORIA
</sql:query>

<sql:query var="novos_produtos" dataSource="jdbc/ebebidas">
    SELECT * FROM PRODUTO ORDER BY idproduto DESC LIMIT 3
</sql:query>
    
<sql:query var="mais_vendidos" dataSource="jdbc/ebebidas">
    SELECT * FROM PRODUTO ORDER BY idproduto ASC LIMIT 3
</sql:query>
--%>

<div class="row">    
    <div class="col-left sidebar col-xs-3">

        <div class="block block-list block-manufacturer first">
            <div class="block-title base-background"><span>Categorias</span></div>
            <div class="block-content">
                <ul>
                    <c:forEach var="category" items="${categories}">
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
        <div class="slide-show">

            <div id="myCarousel" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class=""></li>
                    <li data-target="#myCarousel" data-slide-to="1" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="2" class=""></li>
                </ol>
                <div class="carousel-inner">
                    <div class="item">
                        <img alt="First slide" src="images/drink-1.jpg">
                        <div class="container">
                            <div class="carousel-caption">

                            </div>
                        </div>
                    </div>
                    <div class="item active">
                        <img  alt="Second slide" src="images/drink-2.jpg">
                        <div class="container">
                            <div class="carousel-caption">

                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <img alt="Third slide" src="images/drink-3.jpg">
                        <div class="container">
                            <div class="carousel-caption">

                            </div>
                        </div>
                    </div>
                </div>
                <!--
                <a class="left carousel-control" href="#myCarousel" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
                <a class="right carousel-control" href="#myCarousel" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
                -->
            </div>
        </div>

        <div class="page-title category-title base-background">
            <h1>Novos Produtos</h1>
        </div>

        <ul class="products-grid row">
            <c:forEach var="produto" items="${novos_produtos}">
                <li class="item col-xs-4">
                    <div class="wrapper-hover">
                        <a href="produto?${produto.idproduto}" class="product-image">
                            <img src="${initParam.productImagePath}${produto.imagem}">
                        </a>
                        <div class="product-shop">                                     
                            <div class="price-box">
                                <p class="old-price">
                                    <span class="price">R$ ${produto.valorUnitario}</span>
                                </p>
                                <p class="special-price">
                                    <span class="price">R$ ${produto.valorUnitario - produto.desconto}</span>
                                </p>
                            </div>

                            <h3 class="product-name">
                                <a href="produto?${produto.idproduto}">${produto.titulo}</a>
                            </h3>

                            <div class="desc_grid">
                                <c:set var="descricao" value="${fn:substring(produto.descricao, 0, 70)}" />
                                ${descricao}...
                            </div>

                            <div class="actions">
                                <input type="button" class="button btn-cart" value="+ Carrinho">
                                <input type="button" class="button btn-details" value="Detalhes">
                            </div>

                        </div>
                    </div>
                </li>
            </c:forEach>  
            
        </ul>

        <div class="widget widget-catalogsale-products">
            <div class="page-title category-title base-background">
                <h1>Mais vendidos</h1>
            </div>

            <ul class="products-grid row">
                <c:forEach var="mvproduto" items="${mais_vendidos}">
                    <li class="item col-xs-4 first">
                        <div class="wrapper-hover">
                            <a href="produto?${mvproduto.idproduto}" class="product-image">
                                <img src="${initParam.productImagePath}${mvproduto.imagem}">
                            </a>
                            <div class="product-shop">
                                <div class="price-box-border">
                                    <div class="price-box">
                                        <p class="old-price">
                                            <span class="price">R$ ${mvproduto.valorUnitario}</span>
                                        </p>
                                        <p class="special-price">
                                            <span class="price">R$ ${mvproduto.valorUnitario - mvproduto.desconto}</span>
                                        </p>
                                    </div>
                                </div>

                                <h3 class="product-name">
                                    <a href="produto?${mvproduto.idproduto}">${mvproduto.titulo}</a>
                                </h3>

                                <div class="desc_grid">
                                    <c:set var="descricao" value="${fn:substring(mvproduto.descricao, 0, 70)}" />
                                    ${descricao}...
                                </div>

                                <div class="actions">
                                    <input type="button" class="button btn-cart" value="+ Carrinho">
                                    <input type="button" class="button btn-details" value="Detalhes">
                                </div>

                            </div>
                        </div>
                    </li>
                </c:forEach>                
            </ul>
        </div>
    </div>
</div>