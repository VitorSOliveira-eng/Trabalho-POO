
public class Nota {
    private Disciplina disc;
    private Matricula matricula;
    private double valor;
    
    private Nota(Disciplina disc, Matricula matricula, double valor) {
        this.disc = disc;
        this.matricula = matricula;
        this.valor = valor;
    }
    public static Nota criarNota(Disciplina disc, Matricula matricula, double valor) {
        if (disc != null && matricula != null && valor >= 0) {
            return new Nota(disc, matricula, valor);
        } else {
            return null;
        }
    }
    
    
    public Disciplina getDisc() {
        return disc;
    }
    public void setDisc(Disciplina disc) {
        this.disc = disc;
    }
    public Matricula getMatricula() {
        return matricula;
    }
    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }


    
}
