package leandro.aneloja.authetication.dto;

public record LoginDTO(String email, String password) {
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
}
