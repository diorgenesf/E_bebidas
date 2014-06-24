package entity;

import entity.Pedido;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-24T14:12:14")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> senha;
    public static volatile SingularAttribute<Usuario, String> foto;
    public static volatile SingularAttribute<Usuario, String> fixo;
    public static volatile SingularAttribute<Usuario, String> cpf;
    public static volatile SingularAttribute<Usuario, String> celular;
    public static volatile SingularAttribute<Usuario, String> nome;
    public static volatile CollectionAttribute<Usuario, Pedido> pedidoCollection;
    public static volatile SingularAttribute<Usuario, String> sobrenome;
    public static volatile SingularAttribute<Usuario, String> dataNascimento;
    public static volatile SingularAttribute<Usuario, String> type;
    public static volatile SingularAttribute<Usuario, String> username;

}