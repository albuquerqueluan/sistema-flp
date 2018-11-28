package entidade;

//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import util.Conexao;

public class Pessoa {
    
    private int identificador;
    private String CPF;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
  
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getCPF() {
        return CPF;
    }
    
    public void setCPF(String CPF)
    {
        this.CPF = CPF;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
//    public static ResultSet conPes(String pcpf){
//    ResultSet resultado = null; 
//    try
//    {
//    // recupera uma conexao com o banco de dados.
//    Connection conexao = Conexao.getConexao();        // sql de consulta.
//        String SQL = "SELECT * from pessoa WHERE cpf = '" + pcpf +"'";
//
//        // executa o SQL.
//        Statement stmt = conexao.createStatement();
//        resultado = stmt.executeQuery(SQL);
//    }
//    catch(Exception erro)
//    {
//        System.out.println("Ocorreu um erro na conexão de Pessoa: " + erro.getMessage());
//    }
//
//    return(resultado);        
//}

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}