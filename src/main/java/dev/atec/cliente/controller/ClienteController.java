package dev.atec.cliente.controller;

import dev.atec.cliente.dto.ClienteAtualizacaoDto;
import dev.atec.cliente.dto.ClienteCadastroDto;
import dev.atec.cliente.dto.ClienteDetalhesDto;
import dev.atec.cliente.entity.Cliente;
import dev.atec.cliente.mapper.ClienteMapper;
import dev.atec.cliente.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/clientes")
public class ClienteController {

    private ClienteService service;
    private ClienteMapper mapper;

    public ClienteController(ClienteService service, ClienteMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<ClienteDetalhesDto> cadastrar(@RequestBody @Valid ClienteCadastroDto dto){
        Cliente cliente = service.cadastrar(mapper.toEntity(dto));

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance();
        URI uri = uriComponentsBuilder.path("api/v1/clientes/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).body(mapper.toDetalhesDto(cliente));
    }

    @PutMapping
    public ResponseEntity<ClienteDetalhesDto> atualizar(@RequestBody @Valid ClienteAtualizacaoDto dto){
        Cliente cliente = service.atualizar(mapper.toEntity(dto));

        return ResponseEntity.ok(mapper.toDetalhesDto(cliente));
    }

    @GetMapping("{id}")
    public ResponseEntity<ClienteDetalhesDto> buscarPorId(@PathVariable Long id){
        Cliente cliente = service.buscarPorId(id);

        return ResponseEntity.ok(mapper.toDetalhesDto(cliente));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDetalhesDto>> listarTodos(){
        List<Cliente> clientes = service.buscarTodos();

        return ResponseEntity.ok(mapper.toClienteDetalhesDtos(clientes));
    }

    @DeleteMapping("{id}")
    public ResponseEntity excluirPorid(@PathVariable Long id){
        service.excluirPorId(id);

        return ResponseEntity.noContent().build();
    }
}
