package entity;

import entity.Pedido;
import entity.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-24T09:50:06")
@StaticMetamodel(Endereco.class)
public class Endereco_ { 

    public static volatile SingularAttribute<Endereco, String> uf;
    public static volatile SingularAttribute<Endereco, String> cidade;
    public static volatile SingularAttribute<Endereco, String> complemento;
    public static volatile SingularAttribute<Endereco, Integer> numero;
    public static volatile SingularAttribute<Endereco, String> bairro;
    public static volatile CollectionAttribute<Endereco, Pedido> pedidoCollection;
    public static volatile SingularAttribute<Endereco, Integer> idendereco;
    public static volatile CollectionAttribute<Endereco, Usuario> usuarioCollection;
    public static volatile SingularAttribute<Endereco, String> rua;
    public static volatile SingularAttribute<Endereco, String> cep;
    public static volatile SingularAttribute<Endereco, Usuario> username;

}