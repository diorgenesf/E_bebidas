/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diorgenes
 */
@Entity
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByIdproduto", query = "SELECT p FROM Produto p WHERE p.idproduto = :idproduto"),
    @NamedQuery(name = "Produto.findByTitulo", query = "SELECT p FROM Produto p WHERE p.titulo = :titulo"),
    @NamedQuery(name = "Produto.findByDescricao", query = "SELECT p FROM Produto p WHERE p.descricao = :descricao"),
    @NamedQuery(name = "Produto.findByQuantidade", query = "SELECT p FROM Produto p WHERE p.quantidade = :quantidade"),
    @NamedQuery(name = "Produto.findByValorUnitario", query = "SELECT p FROM Produto p WHERE p.valorUnitario = :valorUnitario"),
    @NamedQuery(name = "Produto.findByDesconto", query = "SELECT p FROM Produto p WHERE p.desconto = :desconto"),
    @NamedQuery(name = "Produto.findByDestaque", query = "SELECT p FROM Produto p WHERE p.destaque = :destaque"),
    @NamedQuery(name = "Produto.findByImagem", query = "SELECT p FROM Produto p WHERE p.imagem = :imagem"),
    @NamedQuery(name = "Produto.findByVendidos", query = "SELECT p FROM Produto p WHERE p.vendidos = :vendidos")})
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproduto")
    private Integer idproduto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6000)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private int quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_unitario")
    private BigDecimal valorUnitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "desconto")
    private BigDecimal desconto;
    @Size(max = 1)
    @Column(name = "destaque")
    private String destaque;
    @Size(max = 100)
    @Column(name = "imagem")
    private String imagem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vendidos")
    private int vendidos;
    @JoinColumn(name = "idcategoria", referencedColumnName = "idcategoria")
    @ManyToOne(optional = false)
    private Categoria idcategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproduto")
    private Collection<ItensPedido> itensPedidoCollection;

    public Produto() {
    }

    public Produto(Integer idproduto) {
        this.idproduto = idproduto;
    }

    public Produto(Integer idproduto, String titulo, String descricao, int quantidade, BigDecimal valorUnitario, BigDecimal desconto, int vendidos) {
        this.idproduto = idproduto;
        this.titulo = titulo;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.desconto = desconto;
        this.vendidos = vendidos;
    }

    public Integer getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(Integer idproduto) {
        this.idproduto = idproduto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public String getDestaque() {
        return destaque;
    }

    public void setDestaque(String destaque) {
        this.destaque = destaque;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getVendidos() {
        return vendidos;
    }

    public void setVendidos(int vendidos) {
        this.vendidos = vendidos;
    }

    public Categoria getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Categoria idcategoria) {
        this.idcategoria = idcategoria;
    }

    @XmlTransient
    public Collection<ItensPedido> getItensPedidoCollection() {
        return itensPedidoCollection;
    }

    public void setItensPedidoCollection(Collection<ItensPedido> itensPedidoCollection) {
        this.itensPedidoCollection = itensPedidoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproduto != null ? idproduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idproduto == null && other.idproduto != null) || (this.idproduto != null && !this.idproduto.equals(other.idproduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Produto[ idproduto=" + idproduto + " ]";
    }
    
}
