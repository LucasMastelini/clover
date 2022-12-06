package clover.mlclover.controllers;


import clover.mlclover.dtos.CarrinhoDTO;
import clover.mlclover.dtos.PedidoDTO;
import clover.mlclover.dtos.ProdutoDTO;
import clover.mlclover.entities.Pedido;
import clover.mlclover.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Stack;

@RestController
@RequestMapping(value="/pedidos")
@CrossOrigin("*")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<PedidoDTO> find(@PathVariable Integer id) {
        PedidoDTO obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody Pedido obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method =RequestMethod.POST, value = "/carrinho")
    public ResponseEntity<List<Stack<ProdutoDTO>>> carrinho(@RequestBody CarrinhoDTO carrinho){
        List<Stack<ProdutoDTO>> produtos = service.carrinho(carrinho);
        return produtos != null ? ResponseEntity.status(200).body(produtos) : ResponseEntity.status(204).build();
    }

//    @RequestMapping(method=RequestMethod.GET)
//    public ResponseEntity<Page<Pedido>> findPage(
//            @RequestParam(value="page", defaultValue="0") Integer page,
//            @RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
//            @RequestParam(value="orderBy", defaultValue="instante") String orderBy,
//            @RequestParam(value="direction", defaultValue="DESC") String direction) {
//        Page<Pedido> list = service.findPage(page, linesPerPage, orderBy, direction);
//        return ResponseEntity.ok().body(list);
//    }
}