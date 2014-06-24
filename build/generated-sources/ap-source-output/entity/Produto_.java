package entity;

import entity.Avaliacao;
import entity.Categoria;
import entity.ItensPedido;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-24T09:50:06")
@StaticMetamodel(Produto.class)
public class Produto_ { 

    public static volatile SingularAttribute<Produto, Integer> vendidos;
    public static volatile SingularAttribute<Produto, BigDecimal> desconto;
    public static volatile CollectionAttribute<Produto, ItensPedido> itensPedidoCollection;
    public static volatile SingularAttribute<Produto, String> imagem;
    public static volatile SingularAttribute<Produto, String> titulo;
    public static volatile SingularAttribute<Produto, Integer> idproduto;
    public static volatile SingularAttribute<Produto, Categoria> idcategoria;
    public static volatile SingularAttribute<Produto, String> destaque;
    public static volatile SingularAttribute<Produto, Integer> quantidade;
    public static volatile SingularAttribute<Produto, String> descricao;
    public static volatile SingularAttribute<Produto, BigDecimal> valorUnitario;
    public static volatile CollectionAttribute<Produto, Avaliacao> avaliacaoCollection;

}