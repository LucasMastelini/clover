package clover.mlclover.services;

import clover.mlclover.dtos.CarrinhoDTO;
import clover.mlclover.dtos.PedidoDTO;
import clover.mlclover.dtos.ProdutoDTO;
import clover.mlclover.dtos.enums.Acao;
import clover.mlclover.entities.*;
import clover.mlclover.entities.enums.EstadoPagamento;
import clover.mlclover.repositories.ItemPedidoRepository;
import clover.mlclover.repositories.PagamentoRepository;
import clover.mlclover.repositories.PedidoRepository;
//import clover.mlclover.security.UserSS;
//import clover.mlclover.services.exceptions.AuthorizationException;
import clover.mlclover.services.exceptions.CarrinhoVazioException;
import clover.mlclover.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

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
    private EmailService emailService;

    public PedidoDTO find(Integer id) {
        Pedido obj = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
        return new PedidoDTO(obj);


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
        emailService.sendOrderConfirmationHtmlEmail(obj);
        return obj;
    }

    public List<Stack<ProdutoDTO>> carrinho(CarrinhoDTO carrinho) {

        if(carrinho.getListaDePilhasDeProdutos().isEmpty() && carrinho.getItem().getAcao().equals(Acao.POP)){
            throw new CarrinhoVazioException("Carrinho sem nenhum item para remover");
        }
        else if(carrinho.getListaDePilhasDeProdutos().isEmpty() && carrinho.getItem().getAcao().equals(Acao.PUSH)){
            Stack<ProdutoDTO> pilha = new Stack<>();
            pilha.push(carrinho.getItem().getProduto());
            carrinho.getListaDePilhasDeProdutos().add(pilha);
        }
        else if(!carrinho.getListaDePilhasDeProdutos().isEmpty() && carrinho.getItem().getAcao().equals(Acao.PUSH)){
            boolean pilhaDoProdutoExiste = false;
            for(Stack<ProdutoDTO> pilha : carrinho.getListaDePilhasDeProdutos()){
                if(pilha.peek().getId().equals(carrinho.getItem().getProduto().getId())){
                    pilha.push(carrinho.getItem().getProduto());
                    pilhaDoProdutoExiste = true;
                }
            }
            if(!pilhaDoProdutoExiste){
                Stack<ProdutoDTO> pilha = new Stack<>();
                pilha.push(carrinho.getItem().getProduto());
                carrinho.getListaDePilhasDeProdutos().add(pilha);
            }
        }
        else if(!carrinho.getListaDePilhasDeProdutos().isEmpty() && carrinho.getItem().getAcao().equals(Acao.POP)){
            boolean produtoNaoExisteEmNenhumaPilha = true;
            int posicaoPilhaVazia = -1;
            for(int i = 0; i < carrinho.getListaDePilhasDeProdutos().size(); i++){
                if(carrinho.getListaDePilhasDeProdutos().get(i).peek().getId().equals(carrinho.getItem().getProduto().getId())){
                    carrinho.getListaDePilhasDeProdutos().get(i).pop();
                    produtoNaoExisteEmNenhumaPilha = false;
                    if(carrinho.getListaDePilhasDeProdutos().get(i).isEmpty()){
                        posicaoPilhaVazia = i;
                    }
                }
            }
            if(posicaoPilhaVazia != -1){
                carrinho.getListaDePilhasDeProdutos().remove(posicaoPilhaVazia);
            }
            if(produtoNaoExisteEmNenhumaPilha){
                throw new CarrinhoVazioException("Carrinho sem nenhum item para remover");
            }
        }
        return !carrinho.getListaDePilhasDeProdutos().isEmpty() ? carrinho.getListaDePilhasDeProdutos() : null;
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
