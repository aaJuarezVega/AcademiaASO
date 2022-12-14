package models;

import exceptions.DineroInsuficienteException;

import java.math.BigDecimal;



public class Cuenta {
    private String persona;
    private BigDecimal saldo;
    private Banco banco;



    public Cuenta(String persona) {

        this.persona = persona;
    }

    public Cuenta(String persona, BigDecimal saldo) {
        this(persona);
        this.saldo = saldo;
    }


    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public void retirar(BigDecimal monto){
        BigDecimal saldoAux = this.saldo.subtract(monto);
        if (saldoAux.compareTo(BigDecimal.ZERO)<0 ){
            throw new DineroInsuficienteException("Dinero insuficiente");
        }this.saldo= saldoAux;

    }

    public void depositar(BigDecimal monto){

        this.saldo= this.saldo.add(monto);
    }




    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Cuenta) ){
            return false;
        }
        Cuenta c = (Cuenta) obj;
        if(this.persona == null || this.saldo == null){
            return false;
        }
        return this.persona.equals(c.getPersona()) && this.saldo.equals(c.getSaldo());
    }
}
