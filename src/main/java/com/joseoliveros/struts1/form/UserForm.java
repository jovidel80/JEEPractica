package com.joseoliveros.struts1.form;

import org.apache.struts.validator.ValidatorForm;

public class UserForm extends ValidatorForm {

    private String rol;
    private String url;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String valor) {
        this.url = valor;
    }

//    @Override
//    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//
//        ActionErrors errors = new ActionErrors();
//
//        if (getUsername() == null || ("".equals(getUsername()))) {
//            errors.add("common.name.err", new ActionMessage("error.common.name.required"));
//        }
//        return errors;
//
//    }

//
//    @Override
//    public void reset(ActionMapping mapping, HttpServletRequest request) {
//        username = "";
//    }
}
