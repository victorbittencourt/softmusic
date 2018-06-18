
package Modelo;

public class FornecedorModelo {
    
    private int codFornecedor;
    private String nomeFantasia;
    private String razaoSocial;
    private String endereco;
    private String email;
    private String telefone;
    private String cnpj;
    
    public FornecedorModelo (
        int codFornecedor,
        String nomeFantasia,
        String razaoSocial,
        String endereco,
        String email,
        String telefone,
        String cnpj,
        Boolean check
    ){
        this.codFornecedor = codFornecedor;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.cnpj = cnpj;
    }
    
    public FornecedorModelo (
        int codFornecedor,
        String nomeFantasia,
        String razaoSocial,
        String endereco,
        String email,
        String telefone,
        String cnpj
    ){
        this.codFornecedor = codFornecedor;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.cnpj = cnpj;
    }
    
    public FornecedorModelo (){}

    public int getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(int codFornecedor) {
        this.codFornecedor = codFornecedor;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
}
