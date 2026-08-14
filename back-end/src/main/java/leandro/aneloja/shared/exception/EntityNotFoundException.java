package leandro.aneloja.shared.exception;

public class EntityNotFoundException extends RuntimeException {
    private String message;
    private String campo;
    public EntityNotFoundException(String message, String campo) {
            super(message);
            this.message = message;
            this.campo = campo;
    }

    public String getCampo() {
        return campo;
    }
}

