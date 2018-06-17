
package Modelo;

public class EmpresaModelo {
    
    private int codEmpresa;
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String endereco;
    private String telefone;
    private String email;
    
    public EmpresaModelo(
        int codEmpresa,
        String nomeFantasia,
        String razaoSocial,
        String cnpj,
        String endereco,
        String telefone,
        String email,
        Boolean check
    ){
        this.codEmpresa = codEmpresa;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }
    
    public EmpresaModelo(
        int codEmpresa,
        String nomeFantasia,
        String razaoSocial,
        String cnpj,
        String endereco,
        String telefone,
        String email
    ){
        this.codEmpresa = codEmpresa;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }
    
    public EmpresaModelo(){}

    public int getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(int codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
