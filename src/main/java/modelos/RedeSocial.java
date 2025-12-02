package modelos;

public class RedeSocial {
	private final String nomePlataforma;
	private String link;
	
    public RedeSocial(String nomePlataforma, String link){
        this.nomePlataforma = nomePlataforma;
        this.link = link;
    }

    public String getNomePlataforma(){
        return this.nomePlataforma;
    }
    public String getLink(){
        return this.link;
    }
    public void setLink(String link) {
        this.link = link;
    }
}
