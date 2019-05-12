/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.sistemas.cinema;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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
public class ToolBarButton extends Button{
    private final BackgroundImage bca;//backgroundActive
    private final BackgroundImage bc;//background

    public ToolBarButton(String text, Image background, Image backgroundActive) {
        super(text);
        bc = new BackgroundImage(
                background, 
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(60,60,false,false,false,false)
        );
        bca = new BackgroundImage(
                backgroundActive, 
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(60,60,false,false,false,false)
        );
        setBackground(new Background(bc));
        setPrefSize(110, 110);
        setTranslateY(-8);
        setAlignment(Pos.BOTTOM_CENTER);
        setStyle("-fx-font-weight: bold;");
        
        setOnMouseEntered(new EventHandler<MouseEvent>(){
            
            @Override
            public void handle(MouseEvent t) {
                setBackground(new Background(bca));
            }
            
        });
        setOnMouseExited(new EventHandler<MouseEvent>(){
            
            @Override
            public void handle(MouseEvent t) {
                setBackground(new Background(bc));
            }
            
        });
        setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent t) {
                setBackground(new Background(bc));
                setStyle("-fx-font-weight: regular;");
            }
            
        });
        setOnMouseReleased(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent t) {
                setBackground(new Background(bca));
                setStyle("-fx-font-weight: bold;");
            }
            
        });
    }
    
}
