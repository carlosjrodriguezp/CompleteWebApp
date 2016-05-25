package com.webapp.persistencia.dao;

import com.webapp.dominio.Registro;

public interface RegistroDAO {
    void insert(Registro registro) throws Exception;
    
    Registro get(int idRegistro) throws Exception;
    
}
