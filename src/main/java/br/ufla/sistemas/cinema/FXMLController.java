/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.sistemas.cinema;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
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
        final Button Salas = new Button("Salas");
        final BackgroundImage bc = new BackgroundImage(
                new Image("/icons/cinema_room.png"), 
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(80,80,false,false,false,false)
        );
        final BackgroundImage bce = new BackgroundImage(
                new Image("/icons/cinema_room_active.png"), 
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(80,80,false,false,false,false)
        );
        Salas.setBackground(new Background(bc));
        Salas.setPrefSize(130, 130);
        Salas.setAlignment(Pos.BOTTOM_CENTER);
        Salas.setOnMouseEntered(new EventHandler<MouseEvent>(){
            
            @Override
            public void handle(MouseEvent t) {
                Salas.setBackground(new Background(bce));
            }
            
        });
        Salas.setOnMouseExited(new EventHandler<MouseEvent>(){
            
            @Override
            public void handle(MouseEvent t) {
                Salas.setBackground(new Background(bc));
            }
            
        });
        mGChildren.add(Salas);
    }
}
