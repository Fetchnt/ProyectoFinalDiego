package co.edu.unbosque.model.persistence;

import java.util.Properties;

public interface DAO<A> {
		
		public void create(A nuevoDato);
		public String showAll();
		public boolean delete(int indice);
		public boolean delete(A objetoAEliminar);
		public boolean update(int indice, A datoActualizado);
		public int count();
		public void readFromTextFile(String url);
		public void writeTextFile();
		public void loadFromSerializedFile();
		public void writeSerializedFile();
		public boolean actualizarLikes(String alias, int nuevosLikes);
		public void internacionalizacion(Properties prop);
		
	}

