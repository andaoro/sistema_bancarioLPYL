package sistemas_bancario;

import java.io.*;
import java.util.ArrayList;

public class Sistemas_Bancario {

    public static BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        ArrayList<Cuenta_Bancaria> cuentas = new ArrayList<Cuenta_Bancaria>();

        int decisiones_menu = 0;

        String Menu = " #### SELECCIONE UNA OPCIÓN ### \n"
                + "1. Consultar cuentas existentes \n"
                + "2. Crear cuenta nueva \n"
                + "3. Transferir desde una cuenta a otra \n"
                + "4. Retirar de una cuenta \n"
                + "5. Consignar a una cuenta \n"
                + "0. Salir";

        cuentas.add(new Cuenta_Bancaria(1, 1000, 123, "admin"));

        do {
            System.out.println(Menu);
            System.out.print("Seleccione una opción : ");
            decisiones_menu = Integer.parseInt(kb.readLine());

            if (decisiones_menu != 0) {
                switch (decisiones_menu) {
                    case 1:
                        if (!cuentas.isEmpty()) {
                            Consultar_Cuentas(cuentas);
                        } else {
                            System.out.println("No se encuentran cuentas registradas");
                        }
                        break;
                    case 2:
                        Agregar_Cuenta(cuentas);
                        break;
                    case 3:
                        Transerir_Saldo(cuentas);
                        break;
                    case 4:
                        System.out.println("Digite el id de la cuenta de la que desea retirar");
                        Actualizar_Saldo(4,cuentas);
                        break;
                    case 5:
                        System.out.println("Digite el id de la cuenta de la que desea consignar");
                        Actualizar_Saldo(5,cuentas);
                        break;
                }
            }
        } while (decisiones_menu != 0);
    }

    public static void Consultar_Cuentas(ArrayList<Cuenta_Bancaria> cuentas) throws IOException {
        System.out.println(" \n ##### CUENTAS REGISTRADAS ##### \n ");
        for (Cuenta_Bancaria cuenta : cuentas) {
            System.out.println(" ----------------------------- ");
            System.out.println("Id cuenta: " + cuenta.getId_cuenta());
            System.out.println("Saldo cuenta: " + cuenta.getSaldo_cuenta());
            System.out.println("Id Usuario: " + cuenta.getIdentificacion_Usuario());
            System.out.println("Nombre Usuario: " + cuenta.getNombre_Usuario());
            System.out.println("Tipo de cuenta :" + cuenta.getTipo_Cuenta());
        }

        System.out.println("Presione cualquier tecla para continuar");
        kb.readLine();
    }

    public static void Agregar_Cuenta(ArrayList<Cuenta_Bancaria> cuentas) throws IOException {
        System.out.println("\n #### CREAR USUARIOS #### \n");
        long saldo_cuenta;
        long id_Usuario;
        String nombre_usuario;

        System.out.print("Digite la identificación: ");
        id_Usuario = Long.parseLong(kb.readLine());

        System.out.print("Digite el nombre de usuario de la cuenta: ");
        nombre_usuario = kb.readLine();

        System.out.print("Digite el saldo inicial de la cuenta : ");
        saldo_cuenta = Long.parseLong(kb.readLine());

        cuentas.add(new Cuenta_Bancaria(cuentas.size() + 1, saldo_cuenta, id_Usuario, nombre_usuario));
        System.out.println("Cuenta agregada correctamente");
        System.out.println("Presione cualquier tecla para continuar");
        kb.readLine();
    }

    public static void Actualizar_Saldo(int decision, ArrayList<Cuenta_Bancaria> cuentas) throws IOException {
        long id;
        long modificar_saldo;
        
        id = Long.parseLong(kb.readLine());

        Cuenta_Bancaria cuenta = buscarCuentaPorID(cuentas,id);
        
        if(cuenta != null){
            System.out.print("Desea el valor que desea :");
            modificar_saldo = Long.parseLong(kb.readLine());
            cuenta.Actualizar_saldo(decision, modificar_saldo);
            System.out.print("Transaccion exitosa :");
        }else{
            System.out.println("No se encontro ninguna cuenta con el id indicado");
            modificar_saldo = Long.parseLong(kb.readLine());
            
            
        }
        
        System.out.println("Presione cualquier tecla para continuar");
        kb.readLine();
    }
    
    public static void Transerir_Saldo(ArrayList<Cuenta_Bancaria> cuentas) throws IOException{
        long id_inicial, id_final , valor;
        System.out.println(" \n  #### TRANSFERENCIA DE SALDO #### \n ");
        System.out.print("Digite el id de la cuenta de la que desea hacer la transferencia :");
        id_inicial = Long.parseLong(kb.readLine());
        
        Cuenta_Bancaria cuenta = buscarCuentaPorID(cuentas,id_inicial);
        
        if(cuenta != null){
            System.out.print("Digite el valor del cual desea hacer la transferencia : ");
            valor = Long.parseLong(kb.readLine());
            
            System.out.print("Digite la cuenta a la que desea hacer la transferencia : ");
            id_final = Long.parseLong(kb.readLine());
            
            Cuenta_Bancaria cuenta_destino = buscarCuentaPorID(cuentas,id_final);
            
            if(cuenta_destino != null){
                if(cuenta.getSaldo_cuenta() <= valor){
                    cuenta.Restar_saldo(valor);
                    cuenta_destino.Sumar_saldo(valor);
                    System.out.println("Transaccion Exitosa");
                }else{
                    System.out.println("saldo insuficiente");
                    System.out.println("Intentelo mas tarde");
                }
                
            }else{
                System.out.println("La cuenta de destino no existe");
                System.out.println("Intentelo mas tarde");
            }
        }else{
            System.out.println("El usuario digitado no existe");
        }
        
        System.out.println("Presione cualquier tecla para continuar");
        kb.readLine();
         
    }

    public static Cuenta_Bancaria buscarCuentaPorID(ArrayList<Cuenta_Bancaria> cuentas, long id) {
        for (Cuenta_Bancaria cuenta : cuentas) {
            if (cuenta.getId_cuenta() == id) {
                return cuenta;
            }
        }
        return null; // Si no se encuentra la cuenta
    }
    
}
