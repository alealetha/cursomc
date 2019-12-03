package com.cursomc.domain;

import com.cursomc.domain.enums.EstadoPagamento;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity
public class PagamentoComBoleto extends Pagamento {
    private static final long serialVersionUID = 1L;

    private Date dataVencimento;
    private Date dataPamento;

    public PagamentoComBoleto() {
    }

    public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPamento) {
        super(id, estado, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPamento = dataPamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPamento() {
        return dataPamento;
    }

    public void setDataPamento(Date dataPamento) {
        this.dataPamento = dataPamento;
    }
}
