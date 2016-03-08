package app.view;

import app.Main;
import app.dataProviders.DataProviderInterface;
import app.dataProviders.DummyDataProvider;
import app.model.Employer;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainViewController {
	
	@FXML
	private TableView<Employer>             employerTable;
	@FXML
	private TableColumn<Employer, String>   nameCol;
	@FXML
	private TableColumn< Employer, String>  lastNameCol;
	@FXML
	private TableColumn< Employer, Integer> salaireCol;
    @FXML
    private TextField                  		firstNameLabel;
    @FXML
    private TextField                       lastNameLabel;
    @FXML
    private TextField                       posteLabel;
    @FXML
    private TextField                       salaireLabel;
    

	private static ObservableList<Employer> e = FXCollections.observableArrayList();
    private DataProviderInterface provider;
    
    public MainViewController() {
    	provider = new DummyDataProvider();
	}
    
    @FXML
    private void initialize(){
    	
    	nameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom())) ;
    	lastNameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrenom())) ;
    	salaireCol.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue()
    			.getSalaire()).asObject()) ;

    	e.addAll(provider.getEmployers());
    	employerTable.setItems(e);
    	
    }
        
    
    
    
}
