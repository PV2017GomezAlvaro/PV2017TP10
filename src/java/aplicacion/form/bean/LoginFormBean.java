/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;

import aplicacion.modelo.datos.ColeccionUsuarios;
import aplicacion.modelo.dominio.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Alumno
 */
@ManagedBean
@RequestScoped
public class LoginFormBean {

    private String unUsuario;
    private String unaContraseña;

    public String validarUsuario() {
        String resultado = null;
        ColeccionUsuarios usuarios = new ColeccionUsuarios();
        Usuario usuario = new Usuario();
        usuario = usuarios.validarUsuario(getUnUsuario(), getUnaContraseña());
        if (usuario == null) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Credenciales Inválidas", "Credenciales Inválidas");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        } else {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Válido", "Usuario Válido");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("UsuarioValidado", usuario);
            resultado = "/menu";
            //resultado = "/menu?faces";
        }
        return resultado;

    }

    public String getNombreUsuarioValidado() {
        Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("UsuarioValidado");
        return usuario.getUsuario();
    }

    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sesion Cerrada", "Sesion Cerrada");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        String resultado = "/index";
        //String resultado = "index?faces-redirect=true";
        return resultado;
    }

    public boolean verificarSesion() {
        boolean sesionValida = false;
        if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("UsuarioValidado") != null)
            sesionValida = true;
        return sesionValida;
    }

    public LoginFormBean(String unUsuario, String unaContraseña) {
        this.unUsuario = unUsuario;
        this.unaContraseña = unaContraseña;
    }

    /**
     * Creates a new instance of LoginFormBean
     */
    public LoginFormBean() {
    }

    public String getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(String unUsuario) {
        this.unUsuario = unUsuario;
    }

    public String getUnaContraseña() {
        return unaContraseña;
    }

    public void setUnaContraseña(String unaContraseña) {
        this.unaContraseña = unaContraseña;
    }

}
