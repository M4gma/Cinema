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
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

/**
 *
 * @author lucio
 */
public class FXMLController implements Initializable{    
    @FXML
    private ToolBar menuGerenciar;

    @Override
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
        
        mGChildren.add(salas);
        mGChildren.add(filmes);
        mGChildren.add(sessoes);
    }
}
