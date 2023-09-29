
package com.example.tecnisuelos1.services;

import com.example.tecnisuelos1.entity.PruebaCampo;
import java.util.List;

public interface PruebaCampoInterface {
    public List<PruebaCampo> getAllPruebas(String palabraClave);
    public PruebaCampo getPruebaById(Long id);
    public PruebaCampo createPrueba(PruebaCampo pruebaCampo);
    public PruebaCampo updatePrueba(PruebaCampo pruebaCampo);
    public void deletePrueba(Long id);
}
