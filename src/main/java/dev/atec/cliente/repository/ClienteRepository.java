package dev.atec.cliente.repository;

import dev.atec.cliente.dto.ClienteDadosBasicosProjection;
import dev.atec.cliente.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(value = "SELECT c.id, c.nome, c.email FROM cliente c", nativeQuery = true)
    List<ClienteDadosBasicosProjection> getAllClienteDadosBasicos();
}
