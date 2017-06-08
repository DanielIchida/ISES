package test;

import java.util.List;

import modelos.Municipios;
import modelos.MunicipiosDAO;

public class Testing {

	public static void main(String[] args) {
		//LISTADO DE MUNICIPIOS POR DEPARTAMENTO
		MunicipiosDAO dao = new MunicipiosDAO();
		List<Municipios> municipios = dao.getListDepartamento(5);
		for(Municipios m : municipios){
			System.out.println(m.getNombre()+"\n");
		}

	}

}
