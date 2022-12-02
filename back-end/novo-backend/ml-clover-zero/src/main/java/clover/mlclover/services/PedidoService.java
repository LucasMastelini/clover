package clover.mlclover.services;

import clover.mlclover.entities.Cliente;
import clover.mlclover.entities.ItemPedido;
import clover.mlclover.entities.PagamentoComBoleto;
import clover.mlclover.entities.Pedido;
import clover.mlclover.entities.enums.EstadoPagamento;
import clover.mlclover.repositories.ItemPedidoRepository;
import clover.mlclover.repositories.PagamentoRepository;
import clover.mlclover.repositories.PedidoRepository;
//import clover.mlclover.security.UserSS;
//import clover.mlclover.services.exceptions.AuthorizationException;
import clover.mlclover.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    @Autowired
    private BoletoService boletoService;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ClienteService clienteService;

//    @Autowired
//    private EmailService emailService;

    public Pedido find(Integer id) {
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }

    public Pedido insert(Pedido obj) {
        obj.setId(null);
        obj.setInstante(new Date());
        obj.setCliente(clienteService.find(obj.getCliente().getId()));
        obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
        obj.getPagamento().setPedido(obj);
        if (obj.getPagamento() instanceof PagamentoComBoleto) {
            PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
            boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
        }
        obj = repo.save(obj);
        pagamentoRepository.save(obj.getPagamento());
        for (ItemPedido ip : obj.getItens()) {
            ip.setDesconto(0.0);
            ip.setProduto(produtoService.find(ip.getProduto().getId()));
            ip.setPreco(ip.getProduto().getPreco());
            ip.setPedido(obj);
        }
        itemPedidoRepository.saveAll(obj.getItens());
       // emailService.sendOrderConfirmationEmail(obj);
        return obj;
    }

//    public Page<Pedido> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
//        UserSS user = UserService.authenticated();
//        if (user == null) {
//            throw new AuthorizationException("Acesso negado");
//        }
//        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
//        Cliente cliente =  clienteService.find(user.getId());
//        return repo.findByCliente(cliente,  pageRequest);
//    }
}
