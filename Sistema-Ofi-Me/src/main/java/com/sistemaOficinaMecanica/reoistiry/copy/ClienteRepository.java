package com.sistemaOficinaMecanica.reoistiry.copy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemaOficinaMecanica.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	//Exemplo de método customizado:
	boolean existsByCpfCnpj(String cpfCnpj);

}
