package com.webapp.presentacion.controller;

import com.webapp.dominio.Registro;
import com.webapp.persistencia.dao.RegistroDAO;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistroController {
    
    @Autowired
    private RegistroDAO registroDAO;
    
    @RequestMapping({"/index.html"})
    public ModelAndView read(){
        Map<String, Object> model = new HashMap<>();
        String viewName;
        
        try{
            Registro registro = registroDAO.get(1);
            model.put("texto", registro);
            viewName = "registro";
        }catch(Exception ex){
            model.put("msgError", "No se encuentra registro");
            viewName = "error";
        }
        
        return new ModelAndView(viewName, model);
    }
}
