package com.example.leoneldinh10.mi_ahorcado;

/**
 * Created by Rodri on 25/05/2017.
 */

public class usuario {

    private int Id;
    private String nombre;
    private Boolean online;

    public usuario(int id, String nombree, Boolean onlinee) {
        Id = id;
        nombre =nombree;
        online=onlinee;
    }

    public usuario() {

    }

    public int getId() {
        return Id;
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }
}

