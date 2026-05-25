
public class Disciplina {

    private long cddisciplina;
    private String nome;
    private String professor;
    private static long ndisciplina = 0;

    private Disciplina() {
        ndisciplina++;
        cddisciplina = ndisciplina;
    }

    public Disciplina(String nome) {
        this();
        this.nome = nome;
    }

    public long getCddisciplina() {
        return cddisciplina;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome != null && nome.length()>3)
        this.nome = nome;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        if(professor !=null && professor.length()>3)
         this.professor = professor;
    }




    
}
