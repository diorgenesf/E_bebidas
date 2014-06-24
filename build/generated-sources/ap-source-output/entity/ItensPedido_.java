package entity;

import entity.Pedido;
import entity.Produto;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-24T09:50:06")
@StaticMetamodel(ItensPedido.class)
public class ItensPedido_ { 

    public static volatile SingularAttribute<ItensPedido, Integer> iditens;
    public static volatile SingularAttribute<ItensPedido, Pedido> idpedido;
    public static volatile SingularAttribute<ItensPedido, Produto> idproduto;
    public static volatile SingularAttribute<ItensPedido, BigDecimal> valorProduto;

}