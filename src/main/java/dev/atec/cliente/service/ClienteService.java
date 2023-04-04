package dev.atec.cliente.service;

import dev.atec.cliente.entity.Cliente;
import dev.atec.cliente.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements GenericService<Cliente> {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente cadastrar(Cliente cliente) {
        cliente.registarDataCadastro();

        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente atualizar(Cliente cliente) {
        Cliente clienteAtual = clienteRepository.findById(cliente.getId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        clienteAtual.setNome(cliente.getNome());
        clienteAtual.setEmail(cliente.getEmail());
        clienteAtual.setDocumento(cliente.getDocumento());
        clienteAtual.setTelefone(cliente.getTelefone());
        clienteAtual.registrarDataAtualizacao();

        return clienteRepository.save(clienteAtual);
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
    }

    @Override
    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public void excluirPorId(Long id) {
        clienteRepository.deleteById(id);
    }
}
