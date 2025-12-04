package dao;

import java.util.ArrayList;
import java.util.List;
import modelos.Unidade;
import enums.TipoUnidade;

public class UnidadeDAO {

    private static final List<Unidade> unidades = new ArrayList<>();

    static {
        unidades.add(new Unidade(1, "Departamento de Educação Física", TipoUnidade.DEPARTAMENTO));
        unidades.add(new Unidade(2, "Departamento de Artes", TipoUnidade.DEPARTAMENTO));
        unidades.add(new Unidade(3, "Instituto da Tecnologia", TipoUnidade.INSTITUTO));
    }

    public Unidade buscarPorId(int id) {
        for (Unidade u : unidades) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null; 
    }

    public List<Unidade> listar() {
        return unidades;
    }
}
