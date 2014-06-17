<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:set var="offset" value="${pageContext.request.getParameter('offset') eq null ? 0 : pageContext.request.getParameter('offset') }"/>

<c:choose>
    <c:when test="${pageContext.request.getParameter('order') eq null}">
       <c:set var="orderV" value="titulo"/>
       <c:set var="orderF" value="ASC"/>
    </c:when>
    <c:when test="${pageContext.request.getParameter('order') eq 'T-ASC'}">
       <c:set var="orderV" value="titulo"/>
       <c:set var="orderF" value="ASC"/>
    </c:when>
    <c:when test="${pageContext.request.getParameter('order') eq 'T-DESC'}">
       <c:set var="orderV" value="titulo"/>
       <c:set var="orderF" value="DESC"/>
    </c:when>
    <c:when test="${pageContext.request.getParameter('order') eq 'P-ASC'}">
       <c:set var="orderV" value="valor_unitario"/>
       <c:set var="orderF" value="ASC"/>
    </c:when>
    <c:when test="${pageContext.request.getParameter('order') eq 'P-DESC'}">
       <c:set var="orderV" value="valor_unitario"/>
       <c:set var="orderF" value="DESC"/>
    </c:when>
</c:choose>

<sql:query var="categoria" dataSource="jdbc/ebebidas">
    SELECT * FROM CATEGORIA WHERE idcategoria = ?
    <sql:param value="${pageContext.request.getParameter('id')}"/>
</sql:query>
    
<c:set var="sql" value="SELECT * FROM PRODUTO WHERE idcategoria = ${pageContext.request.getParameter('id')} ORDER BY ${orderV} ${orderF} LIMIT 6 OFFSET ${offset*6}"/>
    
<sql:query var="produtos" dataSource="jdbc/ebebidas">
    <c:out value="${sql}"/>
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

        <div class="page-title category-title base-background category">
            <h1>${categoria.rows[0].titulo}</h1>
        </div>

        <div class="page-title category-title row-pagination">
            <form id="formPagination" action="http://localhost:8080/E_bebidas/categoria" method="get">
                <input type="hidden" name="id" value="${pageContext.request.getParameter('id')}">
                <div class="row">
                    <div class="order-by">
                        <span>Ordenar por: </span>
                        <select name="order" id="order">
                            <option value="T-ASC" <c:out value="${pageContext.request.getParameter('order') eq 'T-ASC' ? 'selected' : ''}"/> >A - Z</option>
                            <option value="T-DESC" <c:out value="${pageContext.request.getParameter('order') eq 'T-DESC' ? 'selected' : ''}"/>>Z - A</option>
                            <option value="P-ASC" <c:out value="${pageContext.request.getParameter('order') eq 'P-ASC' ? 'selected' : ''}"/>>Menor preço</option>
                            <option value="P-DESC" <c:out value="${pageContext.request.getParameter('order') eq 'P-DESC' ? 'selected' : ''}"/>>Maior preço</option>
                        </select>
                    </div>
                    
                    <input type="hidden" id="offset" name="offset" value="${offset}">
                    <ul class="pagination" id="paginas">                        
                        <li id="offset-a-1"><a href="">&laquo;</a></li>
                        <li id="offset-x" class="active"><a href="">${offset}</a></li>
                        <li id="offset-p-1"><a href="">${offset+1}</a></li>
                        <li id="offset-p-2"><a href="">${offset+2}</a></li>
                        <li id="offset-p-3"><a href="">${offset+3}</a></li>
                        <li id="offset-p-4"><a href="">${offset+4}</a></li>
                        <li id="offset-l-1"><a href="">&raquo;</a></li>
                    </ul>
                </div>
            </form>
        </div>

        <ul class="products-grid row">
            <c:forEach var="produto" items="${produtos.rows}">
                <li class="item col-xs-4">
                    <div class="wrapper-hover">
                        <a href="produto?${produto.idproduto}" class="product-image">
                            <img src="${initParam.productImagePath}${produto.imagem}">
                        </a>
                        <div class="product-shop">
                            <div class="price-box-border">
                                <div class="price-box">
                                    <p class="old-price">
                                        <span class="price">R$ ${produto.valor_unitario}</span>
                                    </p>
                                    <p class="special-price">
                                        <span class="price">R$ ${produto.valor_unitario - produto.desconto}</span>
                                    </p>
                                </div>
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
    </div>
</div>
<script src="js/pagination.js"></script>