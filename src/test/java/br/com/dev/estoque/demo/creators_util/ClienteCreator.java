package br.com.dev.estoque.demo.creators_util;

import br.com.dev.estoque.demo.model.Cliente;

public class ClienteCreator {

    public static Cliente createValidCliente() {
        return Cliente.builder()
                .nome("Lucas da Silva")
                .CPF("227.246.460-29")
                .RG("34.262.347-3")
                .build();
    }

    public static Cliente createNullCliente(boolean nomeIsNull, boolean cpfIsNull, boolean rgIsNull) {
        Cliente cliente = new Cliente();
        if(!nomeIsNull) { cliente.setNome("Lucas da Silva"); }
        if(!cpfIsNull) { cliente.setCPF("227.246.460-29"); }
        if(!rgIsNull) { cliente.setRG("34.262.347-3"); }
        return cliente;
    }

    public static Cliente createEmptyCliente(boolean nomeIsEmpty, boolean cpfIsEmpty, boolean rgIsEmpty) {
        Cliente cliente = new Cliente();
        if(nomeIsEmpty) { cliente.setNome(""); }
        if(cpfIsEmpty) { cliente.setCPF(""); }
        if(rgIsEmpty) { cliente.setRG(""); }
        return cliente;
    }


}
