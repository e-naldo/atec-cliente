package dev.atec.cliente.mapper;

import dev.atec.cliente.dto.ClienteAtualizacaoDto;
import dev.atec.cliente.dto.ClienteCadastroDto;
import dev.atec.cliente.dto.ClienteDetalhesDto;
import dev.atec.cliente.entity.Cliente;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteMapper {

    public Cliente toEntity(ClienteCadastroDto dto){
        return new Cliente(dto.nome(), dto.documento(), dto.email(), dto.telefone());
    }

    public Cliente toEntity(ClienteAtualizacaoDto dto){
        return new Cliente(dto.id(), dto.nome(), dto.documento(), dto.email(), dto.telefone());
    }

    public ClienteDetalhesDto toDetalhesDto(Cliente cliente){
        return new ClienteDetalhesDto(cliente.getId(), cliente.getNome(), cliente.getDocumento(),
                cliente.getEmail(), cliente.getTelefone(), cliente.getDataCadastro(),
                cliente.getDataAtualizacao());
    }

    public List<ClienteDetalhesDto> toClienteDetalhesDtos(List<Cliente> clientes){
        return clientes.stream().map(this::toDetalhesDto).collect(Collectors.toList());
    }
}
