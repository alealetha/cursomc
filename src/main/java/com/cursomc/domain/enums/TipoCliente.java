package com.cursomc.domain.enums;

public enum TipoCliente {

    PESSOAFISICA(1, "Pessoa Fisica"),
    PESSOAJURIFICA(2, "Pessoa Juridica");

    private int cod;
    private String descricao;

    private TipoCliente(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoCliente toEnum(Integer id) throws IllegalAccessException {
        if (id == null) {
            return null;
        }

        for (TipoCliente tipoCliente : TipoCliente.values()) {
            if (id.equals(tipoCliente.getCod())) {
                return tipoCliente;
            }
        }

        throw new IllegalArgumentException("Id inválido " + id);
    }
}
