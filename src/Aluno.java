
public class Aluno {
    private long numMatricula;
    private String nome;
    private String cpf;
    private Matricula mat;
    private static long nmatricula = 1;
        // construtor privado regra 3
    private Aluno() {
        numMatricula= nmatricula ;
        nmatricula ++;
    }
        // construtor chaamndo regra 3
    public Aluno(String nome, String cpf) {
        this();
        if(nome != null && cpf != null && cpf.length() > 10){
            this.nome = nome;
            this.cpf = cpf;
        } 
    }


    public static Aluno criarAluno(String nome, String cpf) {
        if(nome != null && cpf != null && cpf.length() > 10){
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
        if(nome != null && nome.length() > 3)
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(cpf !=null && cpf.length() > 10)
        this.cpf = cpf;
    }

    public Matricula getMat() {
        return mat;
    }
    
    //fazer a verificacao
    public void setMat(Matricula mat) {
        if(mat != null)
            this.mat = mat;
    }

    

}
