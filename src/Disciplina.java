
public class Disciplina {

    private long cddisciplina;
    private String nome;
    private String professor;
    private static long ndisciplina = 0;

    private Disciplina(String nome, String professor) {
        ndisciplina++;
        cddisciplina = ndisciplina;
        setNome(nome);
        setProfessor(professor);

    }

    public static Disciplina getInstance(String nome, String professor) {
        return new Disciplina(nome, professor);
    }

    public long getCddisciplina() {
        return cddisciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && nome.length() > 3)
            this.nome = nome;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        if (professor != null && professor.length() > 3)
            this.professor = professor;
    }

}
