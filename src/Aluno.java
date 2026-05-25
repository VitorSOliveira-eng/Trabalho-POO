
public class Aluno {
    private long numMatricula;
    private String nome;
    private String cpf;
    private Matricula mat;
    private static long nmatricula = 0;

    private Aluno() {
        nmatricula ++;
        numMatricula= nmatricula ;
    }

    public Aluno(String nome) {
        this();
        this.nome = nome;
    }

    public long getNumMatricula() {
        return numMatricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome != null && nome.length() > 3)
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(cpf !=null && cpf.length()>10)
        this.cpf = cpf;
    }

    public Matricula getMat() {
        return mat;
    }
    //fazer a verificacao
    public void setMat(Matricula mat) {
        this.mat = mat;
    }

    

}
