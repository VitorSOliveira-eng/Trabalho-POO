public class Aluno {
    private long numMatricula;
    private String nome;
    private String cpf;
    private Matricula mat;
    private static long nmatricula = 1;

    public Aluno(String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);

        if (this.nome != null && this.cpf != null) {
            this.numMatricula = nmatricula;
            nmatricula++;
        }
    }

    public static Aluno criarAluno(String nome, String cpf) {
        if (nome != null && cpf != null && cpf.length() > 10) {
            return new Aluno(nome, cpf);
        } else {
            return null;
        }
    }

    public long getNumMatricula() {
        return numMatricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && nome.length() > 3)
            this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf != null && cpf.length() > 10)
            this.cpf = cpf;
    }

    public Matricula getMat() {
        return mat;
    }

    // fazer a verificacao
    public void setMat(Matricula mat) {
        if (mat != null)
            this.mat = mat;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Aluno{");
        sb.append("numMatricula=").append(numMatricula);
        sb.append(", nome=").append(nome);
        sb.append(", cpf=").append(cpf);
        sb.append(", mat=").append(mat);
        sb.append('}');
        return sb.toString();
    }

}
