package entity;

import entity.Endereco;
import entity.ItensPedido;
import entity.Usuario;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-24T01:59:05")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, Date> data;
    public static volatile SingularAttribute<Pedido, BigDecimal> desconto;
    public static volatile CollectionAttribute<Pedido, ItensPedido> itensPedidoCollection;
    public static volatile SingularAttribute<Pedido, Integer> idpedido;
    public static volatile SingularAttribute<Pedido, Endereco> idendereco;
    public static volatile SingularAttribute<Pedido, String> status;
    public static volatile SingularAttribute<Pedido, Usuario> username;

}