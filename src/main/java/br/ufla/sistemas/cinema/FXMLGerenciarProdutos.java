package br.ufla.sistemas.cinema;

import br.ufla.sistemas.cinema.classesBase.Bebida;
import br.ufla.sistemas.cinema.classesBase.Lanche;
import br.ufla.sistemas.cinema.classesBase.Produto;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Callback;


public class FXMLGerenciarProdutos implements Initializable{

    @FXML
    private MenuButton menuInserir;
    
    @FXML
    private HBox insersor;
    
    @FXML
    private Button inserir;
    
    @FXML
    private TableView<Produto> tabela;
    
    @FXML
    private TableColumn<Produto,String> colNome;

    @FXML
    private TableColumn<Produto, String> colPreco;
    
    @FXML
    private TableColumn<Produto, String> colGramas;
    
    @FXML
    private TableColumn<Produto, String> colCalorias;
    
    @FXML
    private TableColumn<Produto, String> colLitros;
    
    private MenuItem selecionado = null;
    
    private static ObservableList<Produto> produtos = FXCollections.observableArrayList();
    
    public static void adicionarProduto(Produto p) throws Throwable{
        for(int i = 0; i < produtos.size(); i++){
            if(produtos.get(i).getNome().compareTo(p.getNome()) == 0){
                throws new Throwable("Teste");
            }
        }
        
        produtos.add(p);
    }
    
    private void onlyNumbers(final TextField tf){
        tf.textProperty().addListener(
                new ChangeListener<String>() {

                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        if (!newValue.matches("[\\d\\.]")) {
                            newValue = newValue.replaceAll("[^\\d,\\.]", "");
                            newValue = newValue.replaceAll(",", ".");
                            tf.setText(newValue);    
                        }
                    }
                }
        );
    };

    private void alertaProdutoExiste(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Aviso Importante!");
        alert.setHeaderText("Por favor, altere o nome do produto a ser adicionado,\nou remova o de mesmo nome");
        alert.setContentText("Todos os produtos precisam ter nomes diferentes entre si");

        alert.showAndWait();
    }
    public void initialize(URL url, ResourceBundle rb) {
        FXMLMain.setLogMsg("Crie sessões de filmes para que os ingressos apareçam no Caixa");
        
        final MenuItem lanche = menuInserir.getItems().get(0);
        final MenuItem bebida = menuInserir.getItems().get(1);
        final MenuItem outro = menuInserir.getItems().get(2);
        
        lanche.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t) {
                if(selecionado != lanche){
                    ObservableList<Node> nodes = insersor.getChildren();
                    while(nodes.isEmpty() == false){
                        nodes.remove(0);
                    }
                    
                    nodes.add(new Label("Nome: "));
                    final TextField nome = new TextField();
                    nome.setAlignment(Pos.CENTER_RIGHT);
                    nodes.add(nome);
                    
                    nodes.add(new Label("  Preço: "));
                    final TextField preco = new TextField();
                    preco.setAlignment(Pos.CENTER_RIGHT);
                    onlyNumbers(preco);
                    nodes.add(preco);
                    
                    nodes.add(new Label("  Gramas: "));
                    final TextField gramas = new TextField();
                    gramas.setAlignment(Pos.CENTER_RIGHT);
                    onlyNumbers(gramas);
                    nodes.add(gramas);
                    
                    nodes.add(new Label("  Calorias: "));
                    final TextField calorias = new TextField();
                    calorias.setAlignment(Pos.CENTER_RIGHT);
                    onlyNumbers(calorias);
                    nodes.add(calorias);
                    
                    
                    inserir.setDisable(false);
                    inserir.setOnAction(new EventHandler<ActionEvent>(){
                        public void handle(ActionEvent t) {
                            try{
                                
                                adicionarProduto(new Lanche(
                                        nome.getText(),
                                        Float.valueOf(preco.getText()),
                                        Float.valueOf(gramas.getText()),
                                        Float.valueOf(calorias.getText())
                                ));
                                
                                nome.setText("");
                                preco.setText("");
                                gramas.setText("");
                                calorias.setText("");
                            } catch(NumberFormatException e){
                                
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Aviso Importante!");
                                alert.setHeaderText("Não é possível adicionar o lanche ao banco de dados");
                                alert.setContentText("Existem valores inválidos preenchidos no formulário");

                                alert.showAndWait();
                            } catch (Throwable e){
                                alertaProdutoExiste();
                            }
                        }
                        
                    });
                    
                    selecionado = lanche;
                }
            }
        });

        bebida.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t) {
                if(selecionado != bebida){
                    ObservableList<Node> nodes = insersor.getChildren();
                    while(nodes.isEmpty() == false){
                        nodes.remove(0);
                    }
                    
                    nodes.add(new Label("Nome: "));
                    final TextField nome = new TextField();
                    nome.setAlignment(Pos.CENTER_RIGHT);
                    nodes.add(nome);
                    
                    nodes.add(new Label("  Preço: "));
                    final TextField preco = new TextField();
                    preco.setAlignment(Pos.CENTER_RIGHT);
                    onlyNumbers(preco);
                    nodes.add(preco);
                    
                    nodes.add(new Label("  Gramas: "));
                    final TextField gramas = new TextField();
                    gramas.setAlignment(Pos.CENTER_RIGHT);
                    onlyNumbers(gramas);
                    nodes.add(gramas);
                    
                    nodes.add(new Label("  Calorias: "));
                    final TextField calorias = new TextField();
                    calorias.setAlignment(Pos.CENTER_RIGHT);
                    onlyNumbers(calorias);
                    nodes.add(calorias);
                    
                    nodes.add(new Label("  Litros: "));
                    final TextField litros = new TextField();
                    litros.setAlignment(Pos.CENTER_RIGHT);
                    onlyNumbers(litros);
                    nodes.add(litros);
                    
                    
                    inserir.setDisable(false);
                    inserir.setOnAction(new EventHandler<ActionEvent>(){
                        public void handle(ActionEvent t) {
                            try{
                                adicionarProduto(new Bebida(
                                        nome.getText(),
                                        Float.valueOf(preco.getText()),
                                        Float.valueOf(gramas.getText()),
                                        Float.valueOf(calorias.getText()),
                                        Float.valueOf(litros.getText())
                                ));
                                
                                nome.setText("");
                                preco.setText("");
                                gramas.setText("");
                                calorias.setText("");
                                litros.setText("");
                            } catch(NumberFormatException e){
                                
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Aviso Importante!");
                                alert.setHeaderText("Não é possível adicionar a bebida ao banco de dados");
                                alert.setContentText("Existem valores inválidos preenchidos no formulário");

                                alert.showAndWait();
                            } catch (Throwable e){
                                alertaProdutoExiste();
                            }
                        }
                        
                    });
                    
                    selecionado = bebida;
                }
            }
        });

        outro.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t) {
                if(selecionado != outro){
                    ObservableList<Node> nodes = insersor.getChildren();
                    while(nodes.isEmpty() == false){
                        nodes.remove(0);
                    }
                    
                    nodes.add(new Label("Nome: "));
                    final TextField nome = new TextField();
                    nome.setAlignment(Pos.CENTER_RIGHT);
                    nodes.add(nome);
                    
                    nodes.add(new Label("  Preço: "));
                    final TextField preco = new TextField();
                    preco.setAlignment(Pos.CENTER_RIGHT);
                    onlyNumbers(preco);
                    nodes.add(preco);
                    
                    nodes.add(new Label("  Gramas: "));
                    final TextField gramas = new TextField();
                    gramas.setAlignment(Pos.CENTER_RIGHT);
                    onlyNumbers(gramas);
                    nodes.add(gramas);
                    
                    
                    inserir.setDisable(false);
                    inserir.setOnAction(new EventHandler<ActionEvent>(){
                        public void handle(ActionEvent t) {
                            try{
                                adicionarProduto(new Produto(
                                        nome.getText(),
                                        Float.valueOf(preco.getText()),
                                        Float.valueOf(gramas.getText())
                                ));
                                
                                nome.setText("");
                                preco.setText("");
                                gramas.setText("");
                            } catch(NumberFormatException e){
                                
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Aviso Importante!");
                                alert.setHeaderText("Não é possível adicionar o produto ao banco de dados");
                                alert.setContentText("Existem valores inválidos preenchidos no formulário");

                                alert.showAndWait();
                            } catch (Throwable e){
                                alertaProdutoExiste();
                            }
                        }
                        
                    });
                    
                    selecionado = outro;
                }
            }
        });
        

        tabela.setItems(produtos);
        
        colNome.setCellValueFactory(new Callback<CellDataFeatures<Produto, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(CellDataFeatures<Produto, String> p) {
                    FXMLMain.setLogMsg("Produto `" + p.getValue().getNome() + "` adicionado com sucesso");
                    return new ReadOnlyObjectWrapper(p.getValue().getNome());
                }
        });
        
        colPreco.setCellValueFactory(new Callback<CellDataFeatures<Produto, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<Produto, String> p) {
                return new ReadOnlyObjectWrapper(("R$" + (Float)p.getValue().getPreco()).toString());
            }
        });
        
        colGramas.setCellValueFactory(new Callback<CellDataFeatures<Produto, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<Produto, String> p) {
                return new ReadOnlyObjectWrapper(((Float)p.getValue().getPeso()).toString() + p.getValue().getUnidadePeso());
            }
        });
        
        colCalorias.setCellValueFactory(new Callback<CellDataFeatures<Produto, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<Produto, String> p) {
                if(p.getValue() instanceof Lanche){
                    return new ReadOnlyObjectWrapper(((Float)((Lanche)p.getValue()).getCalorias()).toString() + " cal");
                } else {
                    return new ReadOnlyObjectWrapper();
                }
            }
        });
        
        colLitros.setCellValueFactory(new Callback<CellDataFeatures<Produto, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<Produto, String> p) {
                if(p.getValue() instanceof Bebida){
                    return new ReadOnlyObjectWrapper(((Float)((Bebida)p.getValue()).getVolume()).toString() + ((Bebida)p.getValue()).getUnidadeVolume());
                } else {
                    return new ReadOnlyObjectWrapper();
                }
            }
        });
    }
    
}
