package modelos;

import java.util.ArrayList;
import java.util.List;

public class Representante {
	private final String nomeCompleto;
	private final String cpf;
	private String emailContato;
    private final List<Projeto> projetos;
    private final List<Acao> acoes;
	
    public Representante(String nomeCompleto, String cpf, String emailContato){
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.emailContato = emailContato;
        this.projetos = new ArrayList<>();
        this.acoes = new ArrayList<>();
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }
    public String getCpf() {
        return cpf;
    }
    public String getEmailContato() {
        return emailContato;
    }
    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }
    public List<Projeto> getProjetos() {
        return new ArrayList<>(projetos);
    }
    public void adicionarProjeto(Projeto projeto) {
        this.projetos.add(projeto);
    }
    public List<Acao> getAcoes() {
        return new ArrayList<>(acoes);
    }
    public void adicionarAcao(Acao acao) {
        this.acoes.add(acao);
    }
}
