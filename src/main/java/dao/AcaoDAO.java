package dao;

import modelos.Acao;
import modelos.Local;
import java.util.ArrayList;
import java.util.List;

public class AcaoDAO {

    private static final List<Acao> acoes = new ArrayList<>();
    private static int contador = 1;

    static {
        acoes.add(new Acao("Tênis", "Venha jogar tênis!", "Alunos",
                new Local("Quadra", "Rural", ""), null, null, false));

        acoes.add(new Acao("Jiu-jitsu", "Aprenda a se defender!", "Alunos",
                new Local("DEFIS", "Rural", ""), null, null, false));

        acoes.add(new Acao("Futebol", "Um clássico brasileiro!", "Alunos",
                new Local("Ginásio", "Rural", ""), null, null, false));
    }

    public void salvar(Acao acao) {
        try {
            var idField = Acao.class.getDeclaredField("id");
            idField.setAccessible(true);
            idField.setInt(acao, contador++);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atribuir ID", e);
        }
        acoes.add(acao);
    }

    public List<Acao> listar() {
        return new ArrayList<>(acoes);
    }
}
