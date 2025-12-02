package modelos;

import java.util.ArrayList;
import java.util.List;

public class Projeto {
	private String nome;
	private String sobre;
    private String publicoAlvo;
	private Local localParaInformacao;
	private final List<Acao> acoes;
	private final List<RedeSocial> perfis;

    public Projeto(String nome, String sobre, String publicoAlvo, Local localParaInformacao){
        this.nome = nome;
        this.sobre = sobre;
        this.publicoAlvo = publicoAlvo;
        this.localParaInformacao = localParaInformacao;
        this.acoes = new ArrayList<>();
        this.perfis = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }
    public String getSobre() {
        return sobre;
    }
    public String getPublicoAlvo() { return publicoAlvo; }
    public Local getLocalParaInformacao() {
        return localParaInformacao;
    }
    public void adicionarAcao(Acao acao) {
        this.acoes.add(acao);
    }
    public List<Acao> getAcoes() {
        return new ArrayList<>(acoes);
    }
    public void adicionarPerfil(RedeSocial perfil) {
        this.perfis.add(perfil);
    }
    public List<RedeSocial> getPerfis() {
        return new ArrayList<>(perfis);
    }


    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSobre(String sobre) {
        this.sobre = sobre;
    }
    public void setPublicoAlvo(String publicoAlvo) { this.publicoAlvo = publicoAlvo; }
    public void setLocalParaInformacao(Local localParaInformacao) {
        this.localParaInformacao = localParaInformacao;
    }

}

