package clover.mlclover.services;

import clover.mlclover.controllers.utils.ListaObj;

import clover.mlclover.dtos.*;
import clover.mlclover.entities.*;
import clover.mlclover.repositories.*;
import clover.mlclover.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;




import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.util.IOUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AdminService {

    @Value("${application.bucket.name}")
    private String bucketName;

    @Autowired
    private AmazonS3 s3Client;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    SubcategoriaRepository subcategoriaRepository;

    @Autowired
    ProdutoCategoriaRepository produtoCategoriaRepository;

    @Autowired
    ProdutoSubcategoriaRepository produtoSubcategoriaRepository;

    @Autowired
    ProdutoCorRepository produtoCorRepository;

    @Autowired
    ProdutoTamanhoRepository produtoTamanhoRepository;

    @Autowired
    CorRepository corRepository;

    @Autowired
    TamanhoRepository tamanhoRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    ClienteRepository clienteRepository;


    // PRODUTOS
    public void cadastroProduto(ProdutoPostDTO obj) {

        Produto produto = produtoRepository.save(new Produto(obj));
        adicionaRelacionamentoProdutoTabelas(obj, produto);

    }

    public List<ProdutoDTO> listaProdutos() {
       List<Produto> produtos = produtoRepository.findAll();
       return produtos.stream().map(x -> new ProdutoDTO(x)).collect(Collectors.toList());
    }

    public void deleteProduto(Integer id) {
            Produto produto = produtoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
                    "Objeto não encontrado! Tipo: " + Produto.class.getName()));

            produtoTamanhoRepository.deleteByProdutoId(produto.getId());
            produtoCorRepository.deleteByProdutoId(produto.getId());
            produtoSubcategoriaRepository.deleteByProdutoId(produto.getId());
            produtoCategoriaRepository.deleteByProdutoId(produto.getId());

            produtoRepository.deleteById(produto.getId());
    }

    public void updateProduto(Integer id, ProdutoPostDTO obj) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Tipo: " + Produto.class.getName()));

        produto.updateProduto(obj);

        produtoTamanhoRepository.deleteByProdutoId(produto.getId());
        produtoCorRepository.deleteByProdutoId(produto.getId());
        produtoSubcategoriaRepository.deleteByProdutoId(produto.getId());
        produtoCategoriaRepository.deleteByProdutoId(produto.getId());

        adicionaRelacionamentoProdutoTabelas(obj, produto);

    }

    private void adicionaRelacionamentoProdutoTabelas(ProdutoPostDTO obj, Produto produto){
        if(!obj.getCategorias().isEmpty()){
            List<ProdutoCategoria> lista = new ArrayList<>();
            for(CategoriaDTO c : obj.getCategorias()){
                Categoria categoria = categoriaRepository.findById(c.getId()).orElseThrow(() -> new ObjectNotFoundException(
                        "Objeto não encontrado! Tipo: " + Categoria.class.getName()));
                lista.add(new ProdutoCategoria(produto, categoria));
            }
            produtoCategoriaRepository.saveAll(lista);
        }

        if(!obj.getSubcategorias().isEmpty()){
            List<ProdutoSubcategoria> lista = new ArrayList<>();
            for(SubcategoriaDTO s : obj.getSubcategorias()){
                Subcategoria subcategoria = subcategoriaRepository.findById(s.getId()).orElseThrow(() -> new ObjectNotFoundException(
                        "Objeto não encontrado! Tipo: " + Subcategoria.class.getName()));
                lista.add(new ProdutoSubcategoria(produto, subcategoria));
            }
            produtoSubcategoriaRepository.saveAll(lista);
        }

        if(!obj.getCores().isEmpty()){
            List<ProdutoCor> lista = new ArrayList<>();
            for(CorDTO c : obj.getCores()){
                Cor cor = corRepository.findById(c.getHexadecimal()).orElseThrow(() -> new ObjectNotFoundException(
                        "Objeto não encontrado! Tipo: " + Cor.class.getName()));
                lista.add((new ProdutoCor(produto, cor)));
            }
            produtoCorRepository.saveAll(lista);
        }

        if(!obj.getTamanhos().isEmpty()){
            List<ProdutoTamanho> lista = new ArrayList<>();
            for(TamanhoDTO t : obj.getTamanhos()){
                Tamanho tamanho = tamanhoRepository.findById(t.getTamanho()).orElseThrow(() -> new ObjectNotFoundException(
                        "Objeto não encontrado! Tipo: " + Tamanho.class.getName()));
                lista.add(new ProdutoTamanho(produto, tamanho));
            }
            produtoTamanhoRepository.saveAll(lista);
        }
    }
    //CATEGORIAS

    public void cadastroCategoria(CategoriaPostDTO obj) {
        Categoria categoria = categoriaRepository.save(new Categoria(obj));
        adicionaRelacionamentoCategoriaTabelas(obj, categoria);
    }

    private void adicionaRelacionamentoCategoriaTabelas(CategoriaPostDTO obj, Categoria categoria){
        if(!obj.getProdutos().isEmpty()){
            List<ProdutoCategoria> lista = new ArrayList<>();
            for(ProdutoDTO p : obj.getProdutos()){
                Produto produto = produtoRepository.findById(p.getId()).orElseThrow(() -> new ObjectNotFoundException(
                        "Objeto não encontrado! Tipo: " + Produto.class.getName()));
                lista.add(new ProdutoCategoria(produto, categoria));
            }
            produtoCategoriaRepository.saveAll(lista);
        }
    }


    public List<CategoriaDTO> listaCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias.stream().map(x -> new CategoriaDTO(x)).collect(Collectors.toList());
    }


    public void deleteCategoria(Integer id) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Tipo: " + Categoria.class.getName()));
        produtoCategoriaRepository.deleteByCategoriaId(categoria.getId());
        subcategoriaRepository.deleteByCategoriaId(categoria.getId());

        categoriaRepository.deleteById(categoria.getId());
    }

    public void updateCategoria(Integer id, CategoriaPostDTO obj){
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Tipo: " + Categoria.class.getName()));
        categoria.updateCategoria(obj);

        produtoCategoriaRepository.deleteByCategoriaId(categoria.getId());
        subcategoriaRepository.deleteByCategoriaId(categoria.getId());

        adicionaRelacionamentoCategoriaTabelas(obj, categoria);
    }

    // SUBCATEGORIAS

    public void cadastroSubcategoria(SubcategoriaPostDTO obj){
        Categoria categoria = categoriaRepository.findById(obj.getCategoria().getId()).orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Tipo: " + Categoria.class.getName()));
        Subcategoria subcategoria = subcategoriaRepository.save(new Subcategoria(obj.getNome(), categoria));

        if(!obj.getProdutos().isEmpty()){
            List<ProdutoSubcategoria> lista = new ArrayList<>();
            for(ProdutoDTO p : obj.getProdutos()){
                Produto produto = new Produto(p);
                lista.add(new ProdutoSubcategoria(produto, subcategoria));
            }
            produtoSubcategoriaRepository.saveAll(lista);
        }
    }

    public List<SubcategoriaDTO> listaSubcategorias() {
        List<Subcategoria> subcategorias = subcategoriaRepository.findAll();
        return subcategorias.stream().map(x -> new SubcategoriaDTO(x)).collect(Collectors.toList());
    }


    // ARQUIVOS


    public List<ClienteGerarArquivoDTO> listaClientesToArquivo() {
        return clienteRepository.findAll().stream().map(x -> new ClienteGerarArquivoDTO(x)).collect(Collectors.toList());
    }

    public List<Endereco> listaEnderecoToArquivo(){
        return enderecoRepository.findAll();
    }

    public boolean gerarArquivoCsv() {
        List<ClienteGerarArquivoDTO> lista = listaClientesToArquivo();

        for(int i = 0; i < lista.size() - 1; i++){
            int menIndice = i;
            for(int j = i + 1; j < lista.size(); j++){
                if(lista.get(j).getNome().substring(0,1).toLowerCase().hashCode() < lista.get(menIndice).getNome().substring(0,1).toLowerCase().hashCode()){
                    menIndice = j;
                }
            }
            ClienteGerarArquivoDTO aux = lista.get(i);
            lista.set(i, lista.get(menIndice));
            lista.set(menIndice, aux);
        }

        List<Endereco> listaEnderecos = listaEnderecoToArquivo();

        FileWriter arq = null;
        Formatter saida = null;
        String nomeArq = "arquivo.csv";

        try {
            arq = new FileWriter(nomeArq, StandardCharsets.ISO_8859_1);
            saida = new Formatter(arq);
        } catch (IOException erro) {
            return false;
        }

        try {
            Date data = new Date(System.currentTimeMillis());
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

            saida.format("%S;%S;%S;%S;%S\n", "id", "nome", "e-mail", "cpf/cnpj", "tipo");
            int count = 0;
            for (int i = 0; i < lista.size(); i++) {
                ClienteGerarArquivoDTO p = lista.get(i);
                String tipo = p.getTipo() == 1 ? "PESSOA_FISICA" : "PESSOA_JURIDICA";

                saida.format("%d;%S;%s;%s;%S\n", p.getId(), p.getNome(), p.getEmail(), p.getCpfOuCnpj(), tipo);
                count++;
            }
            saida.format("\n%d REGISTROS\n\n\n", count);


            count = 0;
            for (Endereco e : listaEnderecos) {
                if(e.getComplemento() == null){
                    e.setComplemento("N/A");
                }
                saida.format("%d;%S;%S;%S;%S;%S;%S;%S;%S\n", e.getId(), e.getLocalidadeCep().getBairro(), e.getLocalidadeCep().getCep(), e.getComplemento(), e.getLocalidadeCep().getLogradouro(), e.getNumero(), e.getCliente().getNome(), e.getLocalidadeCep().getCidade(), e.getLocalidadeCep().getUf());
                count++;
            }
            saida.format("\n%d REGISTROS\n\n\n", count);
            return true;

        } catch (FormatterClosedException erro) {
            return false;
        } finally {
            saida.close();
            try {
                arq.close();
            } catch (IOException erro) {
                return false;
            }
        }

    }

    public boolean gravarArquivoTxt() {
        List<ClienteGerarArquivoDTO> lista = listaClientesToArquivo();
        List<Endereco> listaEnderecos = listaEnderecoToArquivo();
        ListaObj listaObj= new ListaObj(100);
        for(Endereco e : listaEnderecos){
            listaObj.adiciona(e);
        }

        for(int i = 0; i < lista.size() - 1; i++){
            int menIndice = i;
            for(int j = i + 1; j < lista.size(); j++){
                if(lista.get(j).getNome().substring(0,1).toLowerCase().hashCode() < lista.get(menIndice).getNome().substring(0,1).toLowerCase().hashCode()){
                    menIndice = j;
                }
            }
            ClienteGerarArquivoDTO aux = lista.get(i);
            lista.set(i, lista.get(menIndice));
            lista.set(menIndice, aux);
        }

        FileWriter arq = null;
        Formatter saida = null;
        String nomeArq = "arquivo.txt";


        try {
            arq = new FileWriter(nomeArq, StandardCharsets.UTF_8);
            saida = new Formatter(arq);
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }

        try {
            Date data = new Date(System.currentTimeMillis());
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String dataFormatada = formatador.format(data);

            saida.format("00V1RELATORIOCLIENTES-%s\n", dataFormatada);
            int count = 0;
            for (int i = 0; i < lista.size(); i++) {
                ClienteGerarArquivoDTO p = lista.get(i);
                String tipo = p.getTipo() == 1 ? "PESSOA_FISICA" : "PESSOA_JURIDICA";

                saida.format("02%06d%-40S%-40s%-15s%-15S\n", p.getId(), p.getNome(), p.getEmail(), p.getCpfOuCnpj(), tipo);
                count++;
            }
            saida.format("01%08d\n\n\n", count);

            saida.format("00V1RELATORIOENDERECOSCLIENTES-%s\n", dataFormatada);

            count = 0;
            for (Endereco e : listaEnderecos) {
                if(e.getComplemento() == null){
                    e.setComplemento("N/A");
                }
                saida.format("03%06d%-25S%-10s%-20S%-40S%-8S%-40S%-20S%-5S\n", e.getId(), e.getLocalidadeCep().getBairro(), e.getLocalidadeCep().getCep(), e.getComplemento(), e.getLocalidadeCep().getLogradouro(), e.getNumero(), e.getCliente().getNome(), e.getLocalidadeCep().getCidade(), e.getLocalidadeCep().getUf());
                count++;
            }
            saida.format("01%08d\n\n\n", count);
            return true;

        } catch (FormatterClosedException erro) {
            return false;
        } finally {
            saida.close();
            try {
                arq.close();
            } catch (IOException erro) {
                return false;
            }
        }
    }

    // S3


    public URI uploadFile(MultipartFile file, Integer idProduto, String hexadecimal) {
        try {
            File fileObj = convertMultiPartFileToFile(file);
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            String contentType = file.getContentType();
            InputStream is = file.getInputStream();

            URI url = uploadFile(is, fileName, contentType);

            ProdutoCor produtoCor = produtoCorRepository.findByProdutoIdAndCorHexadecimal(idProduto, hexadecimal);
            produtoCor.addImagem(url.toString());
            produtoCorRepository.save(produtoCor);

            return url;
        } catch (IOException e) {
            throw  new RuntimeException("Erro de IO: " + e.getMessage());
        }
        //s3Client.putObject(new PutObjectRequest(bucketName, fileName, fileObj));
        // fileObj.delete();

    }

    public URI uploadFile(File file, String extensao) {
        try {
            String fileName = System.currentTimeMillis() + extensao;
            String contentType = extensao;

            InputStream is = new FileInputStream(file);

            URI url = uploadFile(is, fileName, contentType);
            return url;
        } catch (IOException e) {
            throw  new RuntimeException("Erro de IO: " + e.getMessage());
        }
        //s3Client.putObject(new PutObjectRequest(bucketName, fileName, fileObj));
        // fileObj.delete();

    }

    public URI uploadFile(InputStream is, String fileName, String contentType){
        try {
            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentType(contentType);
            s3Client.putObject(bucketName, fileName, is, meta);
            return s3Client.getUrl(bucketName, fileName).toURI();
        } catch (URISyntaxException e) {
            throw  new RuntimeException("Erro ao converter URL para URI");
        }
    }
    public byte[] downloadFile(String fileName){
        S3Object s3Object = s3Client.getObject(bucketName, fileName);
        S3ObjectInputStream inputStream = s3Object.getObjectContent();
        try {
            byte[] content =  IOUtils.toByteArray(inputStream);
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String deleteFile(String fileName){
        s3Client.deleteObject(bucketName,fileName);
        return fileName +" removed...";
    }

    public List<String> listAllFiles(){
        ListObjectsV2Result listObjectsV2Result = s3Client.listObjectsV2(bucketName);
        return listObjectsV2Result.getObjectSummaries().stream().map(S3ObjectSummary::getKey).collect(Collectors.toList());
    }

    private File convertMultiPartFileToFile(MultipartFile file){
        File convertedFile = new File(file.getOriginalFilename());
        try(FileOutputStream fos = new FileOutputStream(convertedFile)){
            fos.write(file.getBytes());
        } catch (IOException e){
            log.error("Error converting multipartFile to file", e);
        }
        return convertedFile;
    }

    // DASHBOARD

    public DashboardDTO getDataDashboard() {

        TicketMedioMesDTO t1 = new TicketMedioMesDTO(180.00, "01/22");
        TicketMedioMesDTO t2 = new TicketMedioMesDTO(220.00, "02/22");
        TicketMedioMesDTO t3 = new TicketMedioMesDTO(195.00, "03/22");
        TicketMedioMesDTO t4 = new TicketMedioMesDTO(162.00, "04/22");
        TicketMedioMesDTO t5 = new TicketMedioMesDTO(171.00, "05/22");
        TicketMedioMesDTO t6= new TicketMedioMesDTO(177.00, "06/22");
        TicketMedioMesDTO t7 = new TicketMedioMesDTO(179.00, "07/22");
        TicketMedioMesDTO t8 = new TicketMedioMesDTO(208.00, "08/22");
        TicketMedioMesDTO t9 = new TicketMedioMesDTO(198.00, "09/22");
        TicketMedioMesDTO t10 = new TicketMedioMesDTO(125.00, "10/22");
        TicketMedioMesDTO t11 = new TicketMedioMesDTO(160.00, "11/22");
        TicketMedioMesDTO t12 = new TicketMedioMesDTO(221.00, "12/22");

        Queue<TicketMedioMesDTO> filaTicketMedio = new LinkedList<>();


        filaTicketMedio.add(t1);
        filaTicketMedio.add(t2);
        filaTicketMedio.add(t3);
        filaTicketMedio.add(t4);
        filaTicketMedio.add(t5);
        filaTicketMedio.add(t6);
        filaTicketMedio.add(t7);
        filaTicketMedio.add(t8);
        filaTicketMedio.add(t9);
        filaTicketMedio.add(t10);
        filaTicketMedio.add(t11);
        filaTicketMedio.add(t12);

        TicketMedioDTO ticketMedio = new TicketMedioDTO();

        while(!filaTicketMedio.isEmpty()){
            ticketMedio.getLista().add(filaTicketMedio.poll());
        }

        TaxaConversaoMesDTO tc1 = new TaxaConversaoMesDTO(1.80, "01/22");
        TaxaConversaoMesDTO tc2 = new TaxaConversaoMesDTO(2.20, "02/22");
        TaxaConversaoMesDTO tc3 = new TaxaConversaoMesDTO(1.95, "03/22");
        TaxaConversaoMesDTO tc4 = new TaxaConversaoMesDTO(1.62, "04/22");
        TaxaConversaoMesDTO tc5 = new TaxaConversaoMesDTO(1.71, "05/22");
        TaxaConversaoMesDTO tc6 = new TaxaConversaoMesDTO(1.77, "06/22");
        TaxaConversaoMesDTO tc7 = new TaxaConversaoMesDTO(1.79, "07/22");
        TaxaConversaoMesDTO tc8 = new TaxaConversaoMesDTO(2.08, "08/22");
        TaxaConversaoMesDTO tc9 = new TaxaConversaoMesDTO(1.98, "09/22");
        TaxaConversaoMesDTO tc10 = new TaxaConversaoMesDTO(1.25, "10/22");
        TaxaConversaoMesDTO tc11 = new TaxaConversaoMesDTO(1.60, "11/22");
        TaxaConversaoMesDTO tc12 = new TaxaConversaoMesDTO(2.21, "12/22");



        Queue<TaxaConversaoMesDTO> filaTaxaConversao = new LinkedList<>();


        filaTaxaConversao.add(tc1);
        filaTaxaConversao.add(tc2);
        filaTaxaConversao.add(tc3);
        filaTaxaConversao.add(tc4);
        filaTaxaConversao.add(tc5);
        filaTaxaConversao.add(tc6);
        filaTaxaConversao.add(tc7);
        filaTaxaConversao.add(tc8);
        filaTaxaConversao.add(tc9);
        filaTaxaConversao.add(tc10);
        filaTaxaConversao.add(tc11);
        filaTaxaConversao.add(tc12);


        TaxaConversaoDTO taxaConversao = new TaxaConversaoDTO();

        while(!filaTaxaConversao.isEmpty()){
            taxaConversao.getLista().add(filaTaxaConversao.poll());
        }



        PercentualFaturamentoDTO pf1 = new PercentualFaturamentoDTO("Norte", 9.25);
        PercentualFaturamentoDTO pf2 = new PercentualFaturamentoDTO("Sul", 26.17);
        PercentualFaturamentoDTO pf3 = new PercentualFaturamentoDTO("Sudeste", 31.48);
        PercentualFaturamentoDTO pf4 = new PercentualFaturamentoDTO("Nordeste", 18.12);
        PercentualFaturamentoDTO pf5 = new PercentualFaturamentoDTO("Centro-Oeste", 14.98);


        Queue<PercentualFaturamentoDTO> percentualFaturamento = new LinkedList<>();


        percentualFaturamento.add(pf1);
        percentualFaturamento.add(pf2);
        percentualFaturamento.add(pf3);
        percentualFaturamento.add(pf4);
        percentualFaturamento.add(pf5);

        PercentualFaturamentoPorRegiaoDTO percentualFaturamentoPorRegiao = new PercentualFaturamentoPorRegiaoDTO();

        while(!percentualFaturamento.isEmpty()){
            percentualFaturamentoPorRegiao.getLista().add(percentualFaturamento.poll());
        }


        return new DashboardDTO(percentualFaturamentoPorRegiao,taxaConversao, ticketMedio);
    }
}
