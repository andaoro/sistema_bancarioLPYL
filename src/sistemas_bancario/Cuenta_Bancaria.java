package sistemas_bancario;

public class Cuenta_Bancaria {

    private long id_cuenta;
    private long saldo_cuenta;
    private long identificacion_Usuario;
    String nombre_Usuario;
    String tipo_Cuenta;

    public Cuenta_Bancaria(long id_cuenta, long saldo_cuenta, long identificacion_Usuario, String nombre_Usuario) {
        this.id_cuenta = id_cuenta;
        this.saldo_cuenta = saldo_cuenta;
        this.identificacion_Usuario = identificacion_Usuario;
        this.nombre_Usuario = nombre_Usuario;
        this.tipo_Cuenta = "Cuenta de prueba";
    }

    public long getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(long id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public long getSaldo_cuenta() {
        return saldo_cuenta;
    }

    public void setSaldo_cuenta(long saldo_cuenta) {
        this.saldo_cuenta = saldo_cuenta;
    }

    public long getIdentificacion_Usuario() {
        return identificacion_Usuario;
    }

    public void setIdentificacion_Usuario(long identificacion_Usuario) {
        this.identificacion_Usuario = identificacion_Usuario;
    }

    public String getNombre_Usuario() {
        return nombre_Usuario;
    }

    public void setNombre_Usuario(String nombre_Usuario) {
        this.nombre_Usuario = nombre_Usuario;
    }

    public String getTipo_Cuenta() {
        return tipo_Cuenta;
    }

    public void Actualizar_saldo(int decision, long valor) {
        if (decision == 5) {
            this.saldo_cuenta = this.saldo_cuenta + valor;
            System.out.println("\n ## OPERACION EXITOSA ## \n");
            System.out.println("Su nuevo saldo es $" + this.saldo_cuenta);
        } else if (decision == 4) {
            if (valor <= this.saldo_cuenta) {
                this.saldo_cuenta = this.saldo_cuenta - valor;
                System.out.println("\n ## OPERACION EXITOSA ## \n");
                System.out.println("Su nuevo saldo es $" + this.saldo_cuenta);
            } else {
                System.out.println("Saldo insuficiente");
            }
        }
    }
    
    public void Sumar_saldo(long valor){
        this.saldo_cuenta = this.saldo_cuenta + valor;
    }
    
    public void Restar_saldo(long valor){
        if(valor <= this.saldo_cuenta){
            this.saldo_cuenta = this.saldo_cuenta - valor;
        }else{
            System.out.println("Saldo insuficiente");
        }
    }

}
