package clover.mlclover.controllers;

import clover.mlclover.dtos.CategoriaDTO;
import clover.mlclover.dtos.ClienteDTO;
import clover.mlclover.dtos.ClienteLoginDTO;
import clover.mlclover.dtos.SubcategoriaDTO;
import clover.mlclover.services.AdminService;
import clover.mlclover.services.ClienteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AdminControllerTest {

    @Autowired
    AdminController controller;

    @MockBean
    AdminService service;

    @Autowired
    ClienteController clienteController;

    @MockBean
    ClienteService clienteService;

    // CATEGORIAS

    @Test
    @DisplayName("Quando getCategorias acionado retornar categorias")
    void getCategoriasDeveraResultarCorretamente(){
        CategoriaDTO cat1 = new CategoriaDTO(1, "Animes");
        CategoriaDTO cat2 = new CategoriaDTO(2, "Filmes");
        CategoriaDTO cat3 = new CategoriaDTO(2, "Séries");
        CategoriaDTO cat4 = new CategoriaDTO(2, "Desenhos");
        CategoriaDTO cat5 = new CategoriaDTO(2, "Jogos");
        List<CategoriaDTO> lista = new ArrayList<>();
        lista.addAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5));
        when(this.service.listaCategorias()).thenReturn(Arrays.asList(cat1, cat2, cat3, cat4, cat5));

        ResponseEntity<List<CategoriaDTO>> resultado = controller.listaCategorias();

        assertEquals(200, resultado.getStatusCodeValue());
        assertEquals(lista, resultado.getBody());
    }

    @Test
    @DisplayName("Quando getCategorias acionado retornar status 204")
    void getCategoriasDeveraResultarStatus204(){
        List<CategoriaDTO> lista = new ArrayList<>();
        when(this.service.listaCategorias()).thenReturn(lista);

        ResponseEntity<List<CategoriaDTO>> resultado = controller.listaCategorias();

        assertEquals(204, resultado.getStatusCodeValue());
    }

    // SUBCATEGORIAS

    @Test
    @DisplayName("Quando getSubcategorias acionado retornar subcategorias")
    void getSubcategoriasDeveraResultarCorretamente(){
        SubcategoriaDTO subcat1 = new SubcategoriaDTO(1, "One Piece");
        SubcategoriaDTO subcat2 = new SubcategoriaDTO(1, "Naruto");
        SubcategoriaDTO subcat3 = new SubcategoriaDTO(1, "Death Note");
        SubcategoriaDTO subcat4 = new SubcategoriaDTO(1, "Attack On Titan");
        SubcategoriaDTO subcat5 = new SubcategoriaDTO(1, "Hunter X Hunter");

        List<SubcategoriaDTO> lista = new ArrayList<>();
        lista.addAll(Arrays.asList(subcat1, subcat2, subcat3, subcat4, subcat5));
        when(this.service.listaSubcategorias()).thenReturn(Arrays.asList(subcat1, subcat2, subcat3, subcat4, subcat5));

        ResponseEntity<List<SubcategoriaDTO>> resultado = controller.listaSubcategorias();

        assertEquals(200, resultado.getStatusCodeValue());
        assertEquals(lista, resultado.getBody());
    }

    @Test
    @DisplayName("Quando getSubcategorias acionado retornar status 204")
    void getSubcategoriasDeveraResultarStatus204(){
        List<SubcategoriaDTO> lista = new ArrayList<>();
        when(this.service.listaSubcategorias()).thenReturn(lista);

        ResponseEntity<List<SubcategoriaDTO>> resultado = controller.listaSubcategorias();

        assertEquals(204, resultado.getStatusCodeValue());
    }

    // LOGIN E LOGOFF
    @Test
    @DisplayName("Quando login acionado retornar ClienteDTO")
    void getLoginAcionadoDeveraRetornarClienteDTO(){
        ClienteLoginDTO clienteLoginDTO = new ClienteLoginDTO();
        ClienteDTO clienteDTO = new ClienteDTO();

        when(this.clienteService.login(clienteLoginDTO)).thenReturn(clienteDTO);

        ResponseEntity<ClienteDTO> resultado = clienteController.login(clienteLoginDTO);

        assertEquals(200, resultado.getStatusCodeValue());
        assertEquals(clienteDTO, resultado.getBody());
    }

    @Test
    @DisplayName("Quando login acionado e os dados forem incongruentes, retornar status 403")
    void getLoginAcionadoDeveraRetornarStatus403QuandoFalho(){
        ClienteLoginDTO clienteLoginDTO = new ClienteLoginDTO();

        when(this.clienteService.login(clienteLoginDTO)).thenReturn(null);

        ResponseEntity<ClienteDTO> resultado = clienteController.login(clienteLoginDTO);

        assertEquals(403, resultado.getStatusCodeValue());
    }


}
