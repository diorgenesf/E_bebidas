package entity;

import entity.Produto;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-24T14:12:14")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile SingularAttribute<Categoria, String> titulo;
    public static volatile SingularAttribute<Categoria, Integer> idcategoria;
    public static volatile CollectionAttribute<Categoria, Produto> produtoCollection;

}