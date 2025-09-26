package br.com.infnet.ProjetoInfnet.model.domain.entities;

import br.com.infnet.ProjetoInfnet.model.domain.enumerator.StatusPedido;
import br.com.infnet.ProjetoInfnet.model.domain.enumerator.TipoPagamentoPedido;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_email")
    private Usuario usuario;


    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<PedidoItem> conteudo;

    private Double preco;
    private String endereco;
    private StatusPedido status;
    private TipoPagamentoPedido pagamento;

    public Pedido(String endereco,TipoPagamentoPedido pagamento) {
        this.endereco = endereco;
        this.pagamento = pagamento;
    }

    public Pedido() {
    }

    @Override
    public String toString() {
        return String.format("Pedido %d - Endereço: %s - Status do pedido %s - Preço: %.2f - tipo de pagamento: %s -  ", id,endereco,status.toString(),preco,pagamento.toString());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<PedidoItem> getConteudo() {
        return conteudo;
    }

    public void setConteudo(List<PedidoItem> conteudo) {
        this.conteudo = conteudo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public TipoPagamentoPedido getPagamento() {
        return pagamento;
    }

    public void setPagamento(TipoPagamentoPedido pagamento) {
        this.pagamento = pagamento;
    }
}
