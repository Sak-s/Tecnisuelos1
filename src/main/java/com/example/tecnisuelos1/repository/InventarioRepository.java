/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.tecnisuelos1.repository;

import com.example.tecnisuelos1.entity.Inventario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author santiago
 */
@Repository
public interface InventarioRepository  extends JpaRepository<Inventario, Long>{
    @Query
    ("SELECT i FROM Inventario i WHERE CONCAT(i.nombreInven, ' ', i.descripcionInven, ' ', i.categoriaInven, ' ', i.cantidadInven) LIKE %?1%")
    public List<Inventario> findAll(String palabraClave);
    
}
