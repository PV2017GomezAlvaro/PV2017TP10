/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.datos;

import aplicacion.modelo.dominio.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Alumno
 */
public class ColeccionUsuarios {
    
    private Usuario usuario;
    private ArrayList<Usuario> usuarios;

    public ColeccionUsuarios() {
        usuarios = new ArrayList();
        usuarios.add(new Usuario("alvaro","alvaro"));
    }
    
    public Usuario validarUsuario(String unUsuario, String unaContraseña){
        usuario = new Usuario();
        Usuario usuario = null;
        for(Usuario u : usuarios){
            if(u.getUsuario().equals(unUsuario) && u.getContraseña().equals(unaContraseña) ){
                usuario = u;
                break;
            }
        }
        return usuario;
    }

    public ColeccionUsuarios(Usuario usuario, ArrayList<Usuario> usuarios) {
        this.usuario = usuario;
        this.usuarios = usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
    
}
