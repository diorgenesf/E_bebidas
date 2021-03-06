/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diorgenes
 */
@Entity
@Table(name = "itens_pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItensPedido.findAll", query = "SELECT i FROM ItensPedido i"),
    @NamedQuery(name = "ItensPedido.findByIditens", query = "SELECT i FROM ItensPedido i WHERE i.iditens = :iditens")})
public class ItensPedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iditens")
    private Integer iditens;
    @JoinColumn(name = "idpedido", referencedColumnName = "idpedido")
    @ManyToOne(optional = false)
    private Pedido idpedido;
    @JoinColumn(name = "idproduto", referencedColumnName = "idproduto")
    @ManyToOne(optional = false)
    private Produto idproduto;

    public ItensPedido() {
    }

    public ItensPedido(Integer iditens) {
        this.iditens = iditens;
    }

    public Integer getIditens() {
        return iditens;
    }

    public void setIditens(Integer iditens) {
        this.iditens = iditens;
    }

    public Pedido getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Pedido idpedido) {
        this.idpedido = idpedido;
    }

    public Produto getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(Produto idproduto) {
        this.idproduto = idproduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iditens != null ? iditens.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItensPedido)) {
            return false;
        }
        ItensPedido other = (ItensPedido) object;
        if ((this.iditens == null && other.iditens != null) || (this.iditens != null && !this.iditens.equals(other.iditens))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ItensPedido[ iditens=" + iditens + " ]";
    }
    
}
