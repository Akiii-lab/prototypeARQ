/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Habitacion {
    
    private int id;
    private String titulo;
    private String descripcion;
    private ListCountry pais;
    private ListCitys ciudad;
    private ArrayList<ServiceList> lista;

    public Habitacion(int id, String titulo, String descripcion, ListCountry pais, ListCitys ciudad, ArrayList<ServiceList> lista) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.pais = pais;
        this.ciudad = ciudad;
        this.lista = lista;
    }
    
    public Habitacion() {
    }
    
    @Override
    public String toString() {
        return "Habitacion{" + "id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", pais=" + pais + ", ciudad=" + ciudad + ", lista=" + lista + '}';
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the pais
     */
    public ListCountry getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(ListCountry pais) {
        this.pais = pais;
    }

    /**
     * @return the ciudad
     */
    public ListCitys getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(ListCitys ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the lista
     */
    public ArrayList<ServiceList> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(ArrayList<ServiceList> lista) {
        this.lista = lista;
    }
    
}
