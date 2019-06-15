/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.sistemas.cinema;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author lucio
 */
public class FXMLMain implements Initializable{   
    @FXML
    private ToolBar menuGerenciar;
    
    @FXML
    private ToolBar menuVender;
    
    @FXML
    private Pane embedder;
    
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
        produtos.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t) {
                while(embedder.getChildren().isEmpty() == false){
                    embedder.getChildren().remove(0);
                }
                    
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GerenciarProdutos.fxml"));
                try {
                    embedder.getChildren().add((VBox)loader.load());
                } catch (IOException ex) {
                    Logger.getLogger(FXMLMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });   
        mGChildren.add(salas);
        mGChildren.add(filmes);
        mGChildren.add(sessoes);
    
        //constrói filhos de menuVender
        ObservableList<Node> mVChildren = menuVender.getItems();
        
        ToolBarButton caixa = new ToolBarButton(
                "Caixa",
                new Image("/icons/produtos.png"),
                new Image("/icons/produtos_active.png")
        );
        caixa.setOnAction(nadaImplPopup);
        mVChildren.add(caixa);
    }
}
