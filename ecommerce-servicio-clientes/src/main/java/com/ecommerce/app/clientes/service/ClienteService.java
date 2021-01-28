package com.ecommerce.app.clientes.service;

import org.springframework.stereotype.Service;

import com.ecommerce.app.clientes.repository.IClienteRepository;
import com.ecommerce.app.commons.models.cliente.Cliente;
import com.ecommerce.app.commons.services.CommonService;

@Service
public class ClienteService extends CommonService<Cliente, IClienteRepository> implements IClienteService{

}
