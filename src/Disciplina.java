
public class Disciplina {

    private long cddisciplina;
    private String nome;
    private String professor;
    private static long ndisciplina = 0;

    private Disciplina(String nome, String professor) {
        setNome(nome);
        setProfessor(professor);
        if (nome != null && nome.length() > 3 && professor != null && professor.length() > 3) {
            ndisciplina++;
            cddisciplina = ndisciplina;

        }

    }

    public static Disciplina criarDisciplina(String nome, String professor) {
        Disciplina novaDisc = new Disciplina(nome, professor);

        // Se o código ficou 0, significa que a validação falhou lá no construtor
        if (novaDisc.getCddisciplina() == 0) {
            return null; // Bloqueia a criação do objeto inválido
        }

        return novaDisc;
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
