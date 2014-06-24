package entity;

import entity.AvaliacaoPK;
import entity.Produto;
import entity.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-24T01:59:05")
@StaticMetamodel(Avaliacao.class)
public class Avaliacao_ { 

    public static volatile SingularAttribute<Avaliacao, AvaliacaoPK> avaliacaoPK;
    public static volatile SingularAttribute<Avaliacao, Produto> produto;
    public static volatile SingularAttribute<Avaliacao, Integer> pontos;
    public static volatile SingularAttribute<Avaliacao, Usuario> usuario;

}