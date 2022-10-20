package terceirosemestre.clover.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import terceirosemestre.clover.domain.ItemPedido;
import terceirosemestre.clover.domain.PagamentoComBoleto;
import terceirosemestre.clover.domain.Pedido;
import terceirosemestre.clover.domain.enums.EstadoPagamento;
import terceirosemestre.clover.repositories.ItemPedidoRepository;
import terceirosemestre.clover.repositories.PagamentoRepository;
import terceirosemestre.clover.repositories.PedidoRepository;
import terceirosemestre.clover.services.exceptions.ObjectNotFoundException;

import javax.transaction.Transactional;
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

    @Autowired
    EmailService emailService;



    public Pedido find(Integer id) {
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }

    @Transactional
    public Pedido insert(Pedido obj) {
        obj.setInstante(new Date());
        obj.setCliente(clienteService.find(obj.getCliente().getId()));
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
        emailService.sendOrderConfirmationHtmlEmail(obj);
        return obj;
    }
}