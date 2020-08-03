package com.example.comunidade;

public class Reporte {
    private String redacao;
    private String tipo;
    private String id;
    private String local;

    public Reporte() {
    }

    public Reporte(String redacao, String tipo, String id,String local) {
        this.redacao = redacao;
        this.tipo = tipo;
        this.id = id;
        this.local = local;

    }

    public String getRedacao() {
        return redacao;
    }

    public void setRedacao(String redacao) {
        this.redacao = redacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
