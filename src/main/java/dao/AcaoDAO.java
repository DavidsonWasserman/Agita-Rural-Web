package dao;

import modelos.Acao;
import modelos.Local;

import java.util.ArrayList;
import java.util.List;

public class AcaoDAO {

    private static final List<Acao> acoes = new ArrayList<>();
    private static int contador = 1; 

    static {
        Acao a1 = new Acao("Tênis", "Venha jogar tênis!", "Alunos",
                new Local("Quadra", "Rural", ""), null, null, false);
        atribuirId(a1);

        Acao a2 = new Acao("Jiu-jitsu", "Aprenda a se defender!", "Alunos",
                new Local("DEFIS", "Rural", ""), null, null, false);
        atribuirId(a2);

        Acao a3 = new Acao("Futebol", "Um clássico brasileiro!", "Alunos",
                new Local("Ginásio", "Rural", ""), null, null, false);
        atribuirId(a3);

        acoes.add(a1);
        acoes.add(a2);
        acoes.add(a3);
    }

    // --- ID ---
    private static void atribuirId(Acao acao) {
        try {
            var idField = Acao.class.getDeclaredField("id");
            idField.setAccessible(true);
            idField.setInt(acao, contador++);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao definir ID", e);
        }
    }

    // --- SALVAR AÇÃO ---
    public void salvar(Acao acao) {
        atribuirId(acao);
        acoes.add(acao);
    }

    public List<Acao> listar() {
        return new ArrayList<>(acoes);
    }

    // --- BUSCAR ID ---
    public Acao buscarPorId(int id) {
        return acoes.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
