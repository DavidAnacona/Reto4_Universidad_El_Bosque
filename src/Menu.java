/**
Ejemplo de CRUD Mysql
Autor: WhitesoundCL
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Menu {
    VistaConsola vista = new VistaConsola();
    // public static void main(String[] args) {
    // utilizando el objeto entrada obtendremos lo que el usuario ingrese por consola.
    Scanner entrada = new Scanner(System.in);
    //instanciamos la clase Conexion
    Conexion con = new Conexion();
    // El while será ejecutado hasta que salir sea TRUE.
    boolean salir = false;
    public void operacion()
    {
        while (!salir) {   
            // Le indicamos al usuario cuales son sus opciones:

            System.out.println("INSTITUTO LA FLORESTA");
            System.out.println("Seleccione tarea a realizar:");
            System.out.println("1. Ingresar estudiante");
            System.out.println("2. Buscar estudiante");
            System.out.println("3. Modificar estudiante");
            System.out.println("4. Eliminar Estudiante");
            System.out.println("5. Ver directorio de estudiantes");
            System.out.println("6. Salir");
            System.out.println("Opción:");

            // Obtenemos el numero ingresado por el usuario en la consola:
            //int opcion = Integer.parseInt(entrada.nextLine());
              int opcion=entrada.nextInt();
            // Según el número que el usuario ingreso en la consola se ejecutará el "case" correspondiente.
            switch(opcion) {
                case 1: // "case" Ingresar nuevo vehiculo
                registrar();
                break;
                case 2: // Listar todos los vehiculos ingresados en la base de datos
                consultarEstudiante();
                break;
                case 3: // ELiminar vehiculo de la base de datos
                modificar();
                break;
                case 4: // Modificar vehiculo de la base de datos:
                eliminar();
                break;
                case 5:
                consultar();
                break;
                case 6:// "case" Salir del programa
                salir = true;
                System.out.println("Hasta pronto");
                break;
                default: // En caso de que el numero ingresado no corresponda a ningún "case"
                System.out.println("Opcion invalida!!!!!!!");

            }
        }

    }

    public void registrar()
    { 
        // Instanciamos un vehiculo vacio (Sin atributos)
        Estudiante estudiante = new Estudiante();
        vista.mostrarInformacion("Ingresar estudiante");
        estudiante.setNombres(vista.leerDatoString("Ingresar nombres:"));
        estudiante.setApellidos(vista.leerDatoString("Ingresar apellidos:"));
        estudiante.setFechaDeNacimiento(vista.leerDatoString("Ingresar fecha de nacimiento (YYYY-MM-DD):"));
        estudiante.setCorreoInstitucional(vista.leerDatoString("Ingresar correo institucional:"));
        estudiante.setCorreoPersonal(vista.leerDatoString("Ingresar correo personal:"));
        estudiante.setNumeroCelular(vista.leerDatoLong("Ingresar número de celular:"));
        estudiante.setNumeroFijo(vista.leerDatoLong("Ingresar número fijo:"));
        estudiante.setProgramaAcademico(vista.leerDatoString("Ingresar programa:"));

        try {

            Statement comando=con.getConnection().createStatement();
            System.out.println("Conectado!!"+con.getbd());
            comando.executeUpdate("INSERT INTO `estudiantes`(`nombres`, `apellidos`, `fechaNacimiento`, `correoInstitucional`, `correoPersonal`, `numeroCelular`, `numeroFijo`, `programaAcademico`) VALUES ('"+
                    estudiante.getNombres()+"','"+estudiante.getApellidos()+"','"+estudiante.getFechaDeNacimiento()+"','"+estudiante.getCorreoInstitucional()+"','"
                    +estudiante.getCorreoPersonal()+"',"+estudiante.getNumeroCelular()+","+estudiante.getNumeroFijo()+",'"+estudiante.getProgramaAcademico()+"')");

            System.out.println("Se agregó el estudiante");

        } catch(SQLException ex){
            System.out.println(ex.toString());
        }

    }

    public void consultar()
    { 

        System.out.println("El directorio de los estudiantes");
        try {

            Statement comando=con.getConnection().createStatement();
            ResultSet registro = comando.executeQuery("SELECT * FROM estudiantes");
            while (registro.next()) {
                String nombres = registro.getString("nombres");
                String apellidos = registro.getString("apellidos");
                String fechaNacimiento = registro.getString("fechaNacimiento");
                String correoInstitucional = registro.getString("correoInstitucional");
                String correoPersonal = registro.getString("correoPersonal");
                Long numeroCelular = registro.getLong("numeroCelular");
                Long numeroFijo = registro.getLong("numeroFijo");
                String programaAcademico = registro.getString("programaAcademico");
                System.out.println("Nombres:: " + nombres + ", Apellidos: "+ apellidos + ", Fecha nacimiento: " + fechaNacimiento 
                        +", Correo institucional: " + correoInstitucional + ", Correo personal: "+ correoPersonal 
                        +", Número de teléfono celular: "+ numeroCelular + ", Número de teléfono fijo: " + numeroFijo + ", Programa académico: "+ programaAcademico);
            }

        } catch(SQLException ex){
            System.out.println(ex.toString());
        }
        try { 
            Thread.sleep(5000); 
        } catch (InterruptedException e) { 

        }

    }

    public void consultarEstudiante()
    {   
        Estudiante estudiante = new Estudiante();
        System.out.println("Buscar estudiante");
        System.out.println("Ingresar correo institucional:");
        estudiante.setCorreoInstitucional(entrada.next());

        try {

            Statement comando=con.getConnection().createStatement();
            String consulta = "SELECT `nombres`, `apellidos`, `fechaNacimiento`, `correoInstitucional`, `correoPersonal`, `numeroCelular`, `numeroFijo`, `programaAcademico` FROM `estudiantes` WHERE correoInstitucional = '"+estudiante.getCorreoInstitucional()+"'";
            ResultSet registro=comando.executeQuery(consulta);
            while (registro.next()) {
                
                String nombres = registro.getString("nombres");
                String apellidos = registro.getString("apellidos");
                String fechaNacimiento = registro.getString("fechaNacimiento");
                String correoInstitucional = registro.getString("correoInstitucional");
                String correoPersonal = registro.getString("correoPersonal");
                Long numeroCelular = registro.getLong("numeroCelular");
                Long numeroFijo = registro.getLong("numeroFijo");
                String programaAcademico = registro.getString("programaAcademico");
                System.out.println("Nombres:: " + nombres + ", Apellidos: "+ apellidos + ", Fecha nacimiento: " + fechaNacimiento 
                        +", Correo institucional: " + correoInstitucional + ", Correo personal: "+ correoPersonal 
                        +", Número de teléfono celular: "+ numeroCelular 
                        +", Número de teléfono fijo: " + numeroFijo + ", Programa académico: "+ programaAcademico);
            }

        } catch(SQLException ex){
            System.out.println(ex.toString());
        }
        try { 
            Thread.sleep(5000); 
        } catch (InterruptedException e) { 

        }

    }

    public void eliminar()
    {
        Estudiante estudiante = new Estudiante();
        System.out.println("Eliminar estudiante");
        System.out.println("Ingresar correo institucional:");
        estudiante.setCorreoInstitucional(entrada.next());
        try {

            Statement comando=con.getConnection().createStatement();
            int cantidad = comando.executeUpdate("delete from estudiantes where correoInstitucional='"+estudiante.getCorreoInstitucional()+"'");
            if (cantidad==1) {

                System.out.println("Se eliminó el estudiante");
            } else {
                System.out.println("No existe estudiante con este correo institucional ");
            }

        } catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }

    public void modificar()
    {
        Estudiante estudiante = new Estudiante();
        System.out.println("Modificar estudiante");
        estudiante.setCorreoInstitucional(vista.leerDatoString("Ingresar correo institucional:"));
        estudiante.setCorreoPersonal(vista.leerDatoString("Ingresar correo personal:"));
        estudiante.setNumeroCelular(vista.leerDatoLong("Ingresar número de celular:"));
        estudiante.setNumeroFijo(vista.leerDatoLong("Ingresar número fijo:"));
        estudiante.setProgramaAcademico(vista.leerDatoString("Ingresar programa:"));
       
        try {

            Statement comando=con.getConnection().createStatement();
            int cantidad = comando.executeUpdate("update estudiantes set correoInstitucional='"+estudiante.getCorreoInstitucional() + "',"+
                    "correoPersonal=" +estudiante.getCorreoPersonal()+ "'," + "numeroCelular=" + estudiante.getNumeroCelular()+
                    "',"+ "numeroFijo=" + estudiante.getNumeroFijo() + "',"+ "programaAcademico=" + estudiante.getProgramaAcademico() +
                    " where correoInstitucional='"+estudiante.getCorreoInstitucional()+"'");
            if (cantidad==1) {
                System.out.println("Se modificó el estudiante");
            } else {
                System.out.println("No existe estudiante con el correo ingresado");
            }
             comando.close();
        } catch(SQLException ex){
            System.out.println(ex.toString());
           
        }
        

    }
}