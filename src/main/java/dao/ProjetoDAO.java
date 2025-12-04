package dao;

import modelos.Acao;
import modelos.Local;
import modelos.Projeto;

import java.util.ArrayList;
import java.util.List;

public class ProjetoDAO {

    private static final List<Projeto> projetos = new ArrayList<>();

    static {
        Acao acao1 = new Acao("Tênis", "Venha jogar tênis!", "Alunos",
                new Local("Quadra", "Rural", ""), null, null, false);

        Acao acao2 = new Acao("Jiu-jitsu", "Aprenda a se defender!", "Alunos",
                new Local("DEFIS", "Rural", ""), null, null, false);

        Acao acao3 = new Acao("Futebol", "Um clássico brasileiro!", "Alunos",
                new Local("Ginásio", "Rural", ""), null, null, false);

        Projeto principal = new Projeto(
                "Esporte na Rural",
                "Vários esportes dentro da Universidade!",
                "Alunos",
                new Local("DEFIS", "Rural", "")
        );

        principal.adicionarAcao(acao1);
        principal.adicionarAcao(acao2);
        principal.adicionarAcao(acao3);

        projetos.add(principal);
    }

    public Projeto buscarPrincipal() {
        return projetos.get(0);
    }
}
