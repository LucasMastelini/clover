package terceirosemestre.clover.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import terceirosemestre.clover.domain.*;
import terceirosemestre.clover.domain.enums.EstadoPagamento;
import terceirosemestre.clover.domain.enums.TipoCliente;
import terceirosemestre.clover.repositories.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private BCryptPasswordEncoder pe;

    public void instantiateTestDatabase() throws ParseException {
        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");
        Categoria cat3 = new Categoria(null, "Cama");
        Categoria cat4 = new Categoria(null, "Mesa");
        Categoria cat5 = new Categoria(null, "Banho");
        Categoria cat6 = new Categoria(null, "Tecnologia");
        Categoria cat7 = new Categoria(null, "Celular");
        Categoria cat8 = new Categoria(null, "Televisores");
        Categoria cat9 = new Categoria(null, "Campo");
        Categoria cat10 = new Categoria(null, "Mamãe&Bebê");
        Categoria cat11 = new Categoria(null, "Office");
        Categoria cat12 = new Categoria(null, "Acessórios");
        Categoria cat13 = new Categoria(null, "Roupas");
        Categoria cat14 = new Categoria(null, "Calças");
        Categoria cat15 = new Categoria(null, "Camisas");
        Categoria cat16 = new Categoria(null, "Times");
        Categoria cat17 = new Categoria(null, "Animes");
        Categoria cat18 = new Categoria(null, "Filmes");
        Categoria cat19 = new Categoria(null, "Séries");
        Categoria cat20 = new Categoria(null, "NERD");



        Produto p1 = new Produto("Computador", 2000.000);
        Produto p2 = new Produto("Impressora", 800.000);
        Produto p3 = new Produto("Mouse", 80.00);
        Produto p4 = new Produto("Mesa de escritório", 300.00);
        Produto p5 = new Produto("Toalha", 50.00);
        Produto p6 = new Produto("Colcha", 200.00);
        Produto p7 = new Produto("TV true color", 1200.00);
        Produto p8 = new Produto("Roçadeira", 800.00);
        Produto p9 = new Produto("Abajour", 100.00);
        Produto p10 = new Produto("Pendente", 180.00);
        Produto p11 = new Produto("Shampoo", 90.00);


        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2, p4));
        cat3.getProdutos().addAll(Arrays.asList(p5, p6));
        cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
        cat5.getProdutos().addAll(Arrays.asList(p8));
        cat6.getProdutos().addAll(Arrays.asList(p9, p10));
        cat7.getProdutos().addAll(Arrays.asList(p11));



        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
        p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
        p4.getCategorias().addAll(Arrays.asList(cat2));
        p5.getCategorias().addAll(Arrays.asList(cat3));
        p6.getCategorias().addAll(Arrays.asList(cat3));
        p7.getCategorias().addAll(Arrays.asList(cat4));
        p8.getCategorias().addAll(Arrays.asList(cat5));
        p9.getCategorias().addAll(Arrays.asList(cat6));
        p10.getCategorias().addAll(Arrays.asList(cat6));
        p11.getCategorias().addAll(Arrays.asList(cat7));


        Estado est1 = new Estado("Minas Gerais");
        Estado est2 = new Estado("São Paulo");

        Cidade c1 = new Cidade(null, "Uberlândia", est1);
        Cidade c2 = new Cidade(null, "São Paulo", est2);
        Cidade c3 = new Cidade(null, "Campinas", est2);

        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2, c3));

        Cliente cli1 = new Cliente(null, "Maria Silva", "igormartins337@gmail.com", "28765101030", TipoCliente.PESSOA_FISICA, pe.encode("123"));

        cli1.getTelefones().addAll(Arrays.asList("954556393", "952307711"));

        Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "3854578", cli1, c1);
        Endereco e2 = new Endereco(null, "Pau Brasil", "221", "Casa", "Jardim Pinheiros", "09854690", cli1, c2);

        cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Pedido ped1 = new Pedido(null,sdf.parse("30/09/2017 10:32"), cli1, e1);
        Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);

        Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
        ped1.setPagamento(pagto1);

        Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
        ped2.setPagamento(pagto2);

        cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

        ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
        ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
        ItemPedido ip3= new ItemPedido(ped2, p2, 100.00, 1, 800.00);

        p1.getItens().addAll(Arrays.asList(ip1));
        p2.getItens().addAll(Arrays.asList(ip3));
        p3.getItens().addAll(Arrays.asList(ip2));


        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8,
                cat9, cat10, cat11, cat12, cat13, cat14, cat15, cat16, cat17, cat18, cat19, cat20));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));
        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

        clienteRepository.saveAll(Arrays.asList(cli1));
        enderecoRepository.saveAll(Arrays.asList(e1, e2));

        pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
        pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

        itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

    }
}
