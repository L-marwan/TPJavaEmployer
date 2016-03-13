package app.dataProviders;

import java.time.LocalDate;
import java.util.ArrayList;

import app.model.Employer;

public class DummyDataProvider implements DataProviderInterface {
	
	private ArrayList<Employer> employers;
	
	public DummyDataProvider() {
		generate();
	}
	
	private void generate(){
		employers = new ArrayList<>();
		employers.add(new Employer("xx", "yy", LocalDate.of(1994, 01, 12),5000));
		employers.add(new Employer("aa", "ff", LocalDate.of(1967, 11, 22),12000));
		employers.add(new Employer("bb", "vv", LocalDate.of(1984, 05, 12),8000));
		employers.add(new Employer("cc", "zz", LocalDate.of(1978, 10, 02),10550));
		employers.add(new Employer("xx", "fffyy", LocalDate.of(1994, 01, 12),5000));
		employers.add(new Employer("afsfa", "ff", LocalDate.of(1967, 11, 22),12000));
		employers.add(new Employer("qsbb", "dsvv", LocalDate.of(1984, 05, 12),8700));
		employers.add(new Employer("cce", "zzez", LocalDate.of(1978, 10, 02),5477));
		
	}

	@Override
	public ArrayList<Employer> getEmployers() {
		return employers;
	}

	@Override
	public Employer getEmployerByNames(String nom, String prenom) {
		
		for(Employer e: employers){
			if(e.getNom().equals(nom) && e.getPrenom().equals(prenom)) return e;
		}
		return null;
	}

	@Override
	public void addEmployer(Employer emp) throws Exception {
		employers.add(emp);
		
	}

}
