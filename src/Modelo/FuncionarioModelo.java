
package Modelo;

public class FuncionarioModelo {
    
    private int idFuncionario;
    private int idEmpresa;
    private String nome;
    private String cpf;
    private String cep;
    private String email;
    private String telefone;
    private String logradouro;
    private String bairro;
    private int numero;
    private String cidade;
    private String estado;
    private String cargo;
    private String chapa;
    private float salario;
    
    public FuncionarioModelo(
            int idFuncionario,
            int idEmpresa,
            String nome,
            String cpf,
            String cep,
            String email,
            String telefone,
            String logradouro,
            String bairro,
            int numero,
            String cidade,
            String estado,
            String cargo,
            String chapa,
            float salario
    ) {
        this.idFuncionario = idFuncionario;
        this.idEmpresa     = idEmpresa;
        this.nome          = nome;
        this.cpf           = cpf;
        this.cep           = cep;
        this.email         = email;
        this.telefone      = telefone;
        this.logradouro    = logradouro;
        this.bairro        = bairro;
        this.numero        = numero;
        this.cidade        = cidade;
        this.estado        = estado;
        this.cargo         = cargo;
        this.chapa         = chapa;
        this.salario       = salario;
    }
    
    public FuncionarioModelo(
            int idFuncionario,
            int idEmpresa,
            String nome,
            String cpf,
            String cep,
            String email,
            String telefone,
            String logradouro,
            String bairro,
            int numero,
            String cidade,
            String estado,
            String cargo,
            String chapa,
            float salario,
            Boolean check
    ) {
        this.idFuncionario = idFuncionario;
        this.idEmpresa     = idEmpresa;
        this.nome          = nome;
        this.cpf           = cpf;
        this.cep           = cep;
        this.email         = email;
        this.telefone      = telefone;
        this.logradouro    = logradouro;
        this.bairro        = bairro;
        this.numero        = numero;
        this.cidade        = cidade;
        this.estado        = estado;
        this.cargo         = cargo;
        this.chapa         = chapa;
        this.salario       = salario;
    }

    public FuncionarioModelo(
            Boolean FALSE,
            int idFuncionario,
            int idEmpresa,
            String nome,
            String cpf,
            String cep,
            String email,
            String telefone,
            String logradouro,
            String bairro,
            int numero,
            String cidade,
            String estado,
            String cargo,
            String chapa,
            float salario
    ) {
        this.idFuncionario = idFuncionario;
        this.idEmpresa     = idEmpresa;
        this.nome          = nome;
        this.cpf           = cpf;
        this.cep           = cep;
        this.email         = email;
        this.telefone      = telefone;
        this.logradouro    = logradouro;
        this.bairro        = bairro;
        this.numero        = numero;
        this.cidade        = cidade;
        this.estado        = estado;
        this.cargo         = cargo;
        this.chapa         = chapa;
        this.salario       = salario;
    }
    
    public FuncionarioModelo(){}

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getChapa() {
        return chapa;
    }

    public void setChapa(String chapa) {
        this.chapa = chapa;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
    
}
