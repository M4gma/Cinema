/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.sistemas.cinema;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;

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
        EventHandler<ActionEvent> nadaImplPopup = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Aviso Importante!");
                alert.setHeaderText("Aguarde por favor as atualizações futuras\t\t\t");
                alert.setContentText("Esta função ainda não foi implementada pelo time de desenvolvimento");

                alert.showAndWait();
            }
            
        };
        
        //constroi filhos de menuGerenciar
        ObservableList<Node> mGChildren = menuGerenciar.getItems();
        ToolBarButton salas = new ToolBarButton(
                "Salas",
                new Image("/icons/cinema_room.png"),
                new Image("/icons/cinema_room_active.png")
        );
        salas.setOnAction(nadaImplPopup);
        
        ToolBarButton filmes = new ToolBarButton(
                "Filmes",
                new Image("/icons/filme.png"),
                new Image("/icons/filme_active.png")
        );
        filmes.setOnAction(nadaImplPopup);
        
        ToolBarButton sessoes = new ToolBarButton(
                "Sessões",
                new Image("/icons/sessao.png"),
                new Image("/icons/sessao_active.png")
        );
        sessoes.setOnAction(nadaImplPopup);
        
        ToolBarButton produtos = new ToolBarButton(
                "Produtos",
                new Image("/icons/produtos.png"),
                new Image("/icons/produtos_active.png")
        );
        produtos.setOnAction(nadaImplPopup);
        
        ToolBarButton funcionarios = new ToolBarButton(
                "Funcionários",
                new Image("/icons/funcionarios.png"),
                new Image("/icons/funcionarios_active.png")
        );
        funcionarios.setOnAction(nadaImplPopup);
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
        ingressos.setOnAction(nadaImplPopup);
        
        ToolBarButton vendaProdutos = new ToolBarButton(
                "Produtos",
                new Image("/icons/produtos.png"),
                new Image("/icons/produtos_active.png")
        );
        vendaProdutos.setOnAction(nadaImplPopup);
        
        mVChildren.add(ingressos);
        mVChildren.add(vendaProdutos);
    }
}
