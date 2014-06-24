/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diorgenes
 */
@Entity
@Table(name = "avaliacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avaliacao.findAll", query = "SELECT a FROM Avaliacao a"),
    @NamedQuery(name = "Avaliacao.findByUsername", query = "SELECT a FROM Avaliacao a WHERE a.avaliacaoPK.username = :username"),
    @NamedQuery(name = "Avaliacao.findByIdproduto", query = "SELECT a FROM Avaliacao a WHERE a.avaliacaoPK.idproduto = :idproduto"),
    @NamedQuery(name = "Avaliacao.findByPontos", query = "SELECT a FROM Avaliacao a WHERE a.pontos = :pontos")})
public class Avaliacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AvaliacaoPK avaliacaoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pontos")
    private int pontos;
    @JoinColumn(name = "idproduto", referencedColumnName = "idproduto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produto produto;
    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Avaliacao() {
    }

    public Avaliacao(AvaliacaoPK avaliacaoPK) {
        this.avaliacaoPK = avaliacaoPK;
    }

    public Avaliacao(AvaliacaoPK avaliacaoPK, int pontos) {
        this.avaliacaoPK = avaliacaoPK;
        this.pontos = pontos;
    }

    public Avaliacao(String username, int idproduto) {
        this.avaliacaoPK = new AvaliacaoPK(username, idproduto);
    }

    public AvaliacaoPK getAvaliacaoPK() {
        return avaliacaoPK;
    }

    public void setAvaliacaoPK(AvaliacaoPK avaliacaoPK) {
        this.avaliacaoPK = avaliacaoPK;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (avaliacaoPK != null ? avaliacaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avaliacao)) {
            return false;
        }
        Avaliacao other = (Avaliacao) object;
        if ((this.avaliacaoPK == null && other.avaliacaoPK != null) || (this.avaliacaoPK != null && !this.avaliacaoPK.equals(other.avaliacaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Avaliacao[ avaliacaoPK=" + avaliacaoPK + " ]";
    }
    
}
