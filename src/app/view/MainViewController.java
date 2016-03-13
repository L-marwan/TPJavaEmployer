package app.view;

import app.Main;
import app.dataProviders.DataProviderFromDb;
import app.dataProviders.DataProviderInterface;
import app.dataProviders.DummyDataProvider;
import app.exceptions.MyExceptions;
import app.model.Employer;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
	private TextField                  		firstNameTF;
	@FXML
	private TextField                       lastNameTF;
	@FXML
	private TextField                       posteTF;
	@FXML
	private TextField                       salaireTF;


	private static ObservableList<Employer> e = FXCollections.observableArrayList();
	private DataProviderInterface provider;
	private Main mainApp;

	public MainViewController() {
		//provider = new DummyDataProvider();
		provider = new DataProviderFromDb();
	}

	@FXML
	private void initialize() throws Exception{

		nameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom())) ;
		lastNameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrenom())) ;
		salaireCol.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue()
				.getSalaire()).asObject()) ;

		e.addAll(provider.getEmployers());
		employerTable.setItems(e);

		//testing the text change listener
		firstNameTF.textProperty().addListener((observable, oldValue, newValue) -> {
			System.out.println("TextField Text Changed (newValue: " + newValue + ")");
		});



	}



	/**
	 * handles the event of clicking the "ajouter" btn
	 * @throws MyExceptions
	 */
	@FXML
	private void handleAdd() throws MyExceptions{
		String nom = firstNameTF.getText();
		String prenom = lastNameTF.getText();
		String poste = posteTF.getText();
		String salaire = salaireTF.getText();

		try{
			validateAndInsert(nom,prenom,poste,salaire);
		}catch (MyExceptions e){
			firstNameTF.setStyle("-fx-text-box-border: red;"); 
		}


	}

	/**
	 * validates the data entry, and posts them to the data base if valid
	 * @param nom
	 * @param prenom
	 * @param poste
	 * @param salaire
	 * @throws MyExceptions
	 */
	private void validateAndInsert(String nom,String prenom,String poste,String salaire) throws MyExceptions{

		String msg="";
		int sal = 0;
		if(nom.equals("") || prenom.equals("") || poste.equals("") || salaire.equals("")){
			msg = "- veuillez remplir tous les champs! \n";
		}
		try{
			sal = Integer.parseInt(salaire);
		}catch(NumberFormatException e){
			msg+="-salaire ne doit contenir que des chiffres! \n";
		}
		if(sal < 0){
			msg += "-salaire ne peut pas etre negatif";
		}

		if(msg.equals("")){
			Employer emp = new Employer(nom,prenom,poste,sal);
			try{
			provider.addEmployer(emp);
			e.add(emp);
			
			}catch(Exception e){
				
			}
			System.out.println("success");
		}else{
			throw new MyExceptions(msg, mainApp);
		}
	}
	
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
}

