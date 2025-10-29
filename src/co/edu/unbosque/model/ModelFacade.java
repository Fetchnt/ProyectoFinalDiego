package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import co.edu.unbosque.model.persistence.MenDAO;
import co.edu.unbosque.model.persistence.WomenDAO;

public class ModelFacade {

	private WomenDAO wDAO;
	private MenDAO mDAO;

	public ModelFacade() {
		mDAO = new MenDAO();
		wDAO = new WomenDAO();
	}

	public WomenDAO getwDAO() {
		return wDAO;
	}

	public void setwDAO(WomenDAO wDAO) {
		this.wDAO = wDAO;
	}

	public MenDAO getmDAO() {
		return mDAO;
	}

	public void setmDAO(MenDAO mDAO) {
		this.mDAO = mDAO;
	}

	public List<String> getUsuariosPorPais(String pais) {
		List<String> resultado = new ArrayList<>();

		for (var m : mDAO.listaMenDTO) {
			if (m.getCountry().equalsIgnoreCase(pais)) {
				resultado.add(m.getAlias());
			}
		}

		for (var w : wDAO.listaWomenDTO) {
			if (w.getCountry().equalsIgnoreCase(pais)) {
				resultado.add(w.getAlias());
			}
		}

		return resultado;
	}
	
	 public void cargarProperties(Properties prop) {
	        mDAO.internacionalizacion(prop);
	        wDAO.internacionalizacion(prop);
	        
	    }
}
