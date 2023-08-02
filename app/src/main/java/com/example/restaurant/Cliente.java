package com.example.restaurant;

public class Cliente
{
    private int id;
    private String nombres;
    private String apellidos;
    private int edad;
    private String sexo;
    private String direccion;
    private String email;
    private String nivel;
    private String comentario;

    public Cliente() {
    }

    public Cliente(int id, String nombres, String apellidos, int edad, String sexo, String direccion, String email, String nivel, String comentario) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.sexo = sexo;
        this.direccion = direccion;
        this.email = email;
        this.nivel = nivel;
        this.comentario = comentario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setCorreo(String string) {
    }

    public void setNivelEstudios(String string) {
    }

    public void setApellido(String string) {
    }

    public void setNombre(String string) {
    }

    public String getCorreo() {
        return null;
    }
}
