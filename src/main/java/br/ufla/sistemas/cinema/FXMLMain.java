/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.sistemas.cinema;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

/**
 *
 * @author lucio
 */
public class FXMLMain implements Initializable{   
    @FXML
    private ToolBar menuGerenciar;
    
    @FXML
    private ToolBar menuVender;
    
    public void initialize(URL url, ResourceBundle rb) {
        
        //constroi filhos de menuGerenciar
        ObservableList<Node> mGChildren = menuGerenciar.getItems();
        ToolBarButton salas = new ToolBarButton(
                "Salas",
                new Image("/icons/cinema_room.png"),
                new Image("/icons/cinema_room_active.png")
        );
        
        ToolBarButton filmes = new ToolBarButton(
                "Filmes",
                new Image("/icons/filme.png"),
                new Image("/icons/filme_active.png")
        );
        
        ToolBarButton sessoes = new ToolBarButton(
                "Sessões",
                new Image("/icons/sessao.png"),
                new Image("/icons/sessao_active.png")
        );
        
        ToolBarButton produtos = new ToolBarButton(
                "Produtos",
                new Image("/icons/produtos.png"),
                new Image("/icons/produtos_active.png")
        );
        
        ToolBarButton funcionarios = new ToolBarButton(
                "Funcionários",
                new Image("/icons/funcionarios.png"),
                new Image("/icons/funcionarios_active.png")
        );
        funcionarios.setPrefWidth(funcionarios.getPrefWidth() + 20);
        
        mGChildren.add(salas);
        mGChildren.add(filmes);
        mGChildren.add(sessoes);
        mGChildren.add(produtos);
        mGChildren.add(funcionarios);
        
        //constrói filhos de menuVender
        ObservableList<Node> mVChildren = menuVender.getItems();
        
        ToolBarButton ingressos = new ToolBarButton(
                "Ingressos",
                new Image("/icons/ticket.png"),
                new Image("/icons/ticket_active.png")
        );
        
        ToolBarButton vendaProdutos = new ToolBarButton(
                "Produtos",
                new Image("/icons/produtos.png"),
                new Image("/icons/produtos_active.png")
        );
        
        mVChildren.add(ingressos);
        mVChildren.add(vendaProdutos);
    }
}
