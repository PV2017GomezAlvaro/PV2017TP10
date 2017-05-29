/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.dominio;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.Date;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Alumno
 */
public class Cliente implements Serializable {

    private int clienteID;
    private Integer dni;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String correoElectronico;
    private byte[] foto;
    private StreamedContent muestraFoto = null;

    public Cliente() {
        dni = 0;
    }
    
    public StreamedContent getMuestraFoto(){
        if(getFoto() != null){
            return new DefaultStreamedContent(new ByteArrayInputStream(getFoto()));
        }
        else{
            return null;
        }
    }

    public Cliente(int clienteID, Integer dni, String nombre, String apellido, Date fechaNacimiento, String correoElectronico, byte[] foto) {
        this.clienteID = clienteID;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
        this.foto = foto;
    }

    

    public boolean getConFoto() {
        boolean resu = false;
        if (getFoto() != null) {
            resu = true;
        }
        return resu;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setMuestraFoto(StreamedContent muestraFoto) {
        this.muestraFoto = muestraFoto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
    
    
    
}