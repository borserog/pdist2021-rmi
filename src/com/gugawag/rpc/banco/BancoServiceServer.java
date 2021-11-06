package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    private final Map<String, Conta> contas = new HashMap<>();

    public BancoServiceServer() throws RemoteException {
        contas.put("1", new Conta("1", 100.0));
        contas.put("2", new Conta("2", 156.0));
        contas.put("3", new Conta("3", 950.0));
    }
    @Override
    public double saldo(String conta) throws RemoteException {
        return contas.get(conta).saldo;
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return contas.size();
    }

    @Override
    public String adicionarConta() throws RemoteException {
        String numeroDaNovaConta = Integer.toString((int) (Math.random() * 1000));
        contas.put(numeroDaNovaConta, new Conta(numeroDaNovaConta, 0.0));
        return numeroDaNovaConta;
    }
}
