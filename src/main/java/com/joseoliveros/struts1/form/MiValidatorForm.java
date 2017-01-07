package com.joseoliveros.struts1.form;

import org.apache.commons.validator.Field;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.Resources;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MiValidatorForm implements Serializable {

    private static List<String> urlAllowed = new ArrayList<>();

    static {
        urlAllowed.add("http://localhost:9999/struts1/Permitida.jsp");
    }

    public static boolean test(Object obj,
                               ValidatorAction va,
                               Field field,
                               ActionMessages actionMessages,
                               Validator validator,
                               HttpServletRequest request) {

        UserForm userForm = (UserForm) obj;
        boolean result = userForm.getRol() == null || userForm.getRol().isEmpty();
        if (!result) {
            for (String url : urlAllowed) {
                if (userForm.getUrl().equals(url)) {
                    return true;
                }
            }
            actionMessages.add(field.getKey(), Resources.getActionMessage(validator, request, va, field));
            userForm.setRol(null);
        }
        return result;
    }
}
