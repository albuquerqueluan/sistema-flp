package entidade;

public class Funcionario {
    
    private int identificador;
    private String tipo_func;
    private Pessoa pessoa;
    private int senha_funcionario;

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getTipo_func() {
        return tipo_func;
    }

    public void setTipo_func(String tipo_func) {
        this.tipo_func = tipo_func;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public int getSenha_funcionario() {
        return senha_funcionario;
    }

    public void setSenha_funcionario(int senha_funcionario) {
        this.senha_funcionario = senha_funcionario;
    }
}
