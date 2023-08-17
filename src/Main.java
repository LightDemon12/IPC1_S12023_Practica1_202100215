import javax.print.attribute.standard.MediaName;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Main {

    static Scanner scanner = new Scanner(System.in);
    /* Scanner para poder seleccionar las opciones del menu posterior*/
    static boolean continuar = true;
    //boleean para un while luego
    static String[] Vehiculos1 = new String[100];
    static String[] linea1 = new String[100];
    static String[] modelo1 = new String[100];
    static String[] placa1 = new String[100];
    static String[] costo1 = new String[100];
    static String[] descuento1 = new String[100];
    static String[] diasN1 = new String[100];
    static String[] usuario1A = new String[100];
    static String[] usuariocontra1 = new String[100];
    static String[] usuario1P = new String[100];
    static int[] diasRentadosPorMarca = new int[100];
    static int[] diasRentadosPorModelo = new int[100];
    static int[] diasrenta = new int[100];
    static boolean[] vehiculoDisponible = new boolean[100];


    // Array para poder tener las listas necesarias

    static String[] placasRentadas = new String[100];
    static String[] usuariosQueRentaron = new String[100];
    static int[] diasDeRenta = new int[100];
    static int numRentas = 0;

    static int Vehiculos2 = 0;
    static int lineas2 = 0;
    static int modelo2 = 0;
    static int placa2 = 0;
    static int costo2 = 0;
    static int descuento2 = 0;
    static int diasN2 = 0;
    static int usuario2A = 0;
    static int usuario2P = 0;
    static int ususariocontra2 = 0;

    //contadores registrados
    public static void main(String[] args) {
        // Después de cargar los datos de los vehículos, inicializa todos los vehículos como disponibles


        while (continuar) {
            //while para no parar el menu
            System.out.println("---Bienvenido--- ");
            System.out.println("1.Ingresar como administrador");
            System.out.println("2.Ingresar como cliente");

            int option = scanner.nextInt();
            //U para elegir opcion de inicio
            scanner.nextLine();
            // el salto de línea se consumirá y estarás listo para leer la entrada del usuario correctamente.
            switch (option) {
                //desplegar menu selecionado
                case 1:
                    String usuario = "admin_202100215";
                    String contrasena = "202100215";
                    //datos quemados para gerente
                    System.out.println("Ingrese su usuario");
                    String usuario1 = scanner.nextLine();

                    if (usuario1.equals(usuario)) {
                        // Realiza las acciones correspondientes para un usuario válido
                        System.out.println("ingrese la contraseña");
                        String contraseña1 = scanner.nextLine();
                        if (contraseña1.equals(contrasena)) {
                            //contraseña correcta = menu gerente
                            MenuGerente();
                        } else {
                            System.out.println("contraseña invalida");
                            //contraseña incorrecta mensaje de invalido
                        }
                    } else {
                        System.out.println("Usuario no válido");
                        //usuario invalido mensaje invalido
                    }
                    break;

                case 2:
                    Menucliente();
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;


            }
            System.out.println("¿Desea continuar? (s/n)");
            String respuesta = scanner.nextLine();
            continuar = respuesta.equalsIgnoreCase("s");

        }
        System.out.println("Gracias por usar el programa. ¡Hasta luego!");
    }

    static void MenuGerente() {
        //static void para desplegar un sub menu para el gerente


        System.out.println("***menu gerente***");
        System.out.println("1. opciones veiculos");
        System.out.println("2.Agregsar descuento");
        System.out.println("3.Realizar reporte");
        System.out.println("4.Mostrar usuarios");
        System.out.println("5.Regresar al menu principal");
        int option = scanner.nextInt();
        scanner.nextLine();
        //menu para gerente
        switch (option) {
            //switch para desplegar posibles acciones
            case 1:
                vehiculo();
                break;
            case 2:
                descuento();
                break;
            case 3:
                reporte();
                break;
            case 4:
                usuarios();
                break;
            case 5:
                continuar = false;
                break;
        }
    }

    static void vehiculo() {
        System.out.println("1.agregar vehiculo");
        System.out.println("2.modificar vehiculos");
        System.out.println("3.eliminar vehiculos");
        System.out.println("4. regresar al menu de gerente");
        int option = scanner.nextInt();
        scanner.nextLine();
        // int para el switch y sus opciones
        switch (option) {
            case 1:
                agregsar();
                break;
            case 2:
                modificar();
                break;
            case 3:
                eliminarVehiculo();
                break;
            case 4:
                MenuGerente();
                break;

        }
    }

    static void agregsar() {
        String op1 = "s";
        //variable para ser usada en el do/while
        do {


            System.out.println("ingrese informacion vehiculo");
            System.out.println("marca:");
            String marca = scanner.nextLine();
            Vehiculos1[Vehiculos2] = marca;
            Vehiculos2++;
            // solicita la marca, luego almacena la informacion e incrementa el contador
            System.out.println("linea:");
            String linea = scanner.nextLine();
            linea1[lineas2] = linea;
            lineas2++;

            System.out.println("modelo:");
            String modelo = scanner.nextLine();
            modelo1[modelo2] = modelo;
            modelo2++;

            System.out.println("placa:");
            String placa = scanner.nextLine();
            Boolean placaExistente = false;
            // variable boolean en falso para saber si la placa ya existe en el sistema
            for (int i = 0; i < Vehiculos2; i++) {
                //bucle for para recorrer el indice de placas
                if (placa1[i] != null && placa1[i].equalsIgnoreCase(placa)) {
                    //se verifica que la placa no exista, el equalsIgnoreCase para que no lea mayusculas o minusculas
                    placaExistente = true;
                    //si existe una placa se desplega un mensaje de existente si no continua normal el programa
                    break;
                }
            }
            if (placaExistente) {
                System.out.println("La placa ingresada ya existe en el sistema. Intente de nuevo.");
            } else {
                placa1[placa2] = placa;
                placa2++;


                System.out.println("costo:");
                String costo = scanner.nextLine();
                if (Double.parseDouble(costo) > 0) {
                    //se utiliza para pasar la entrada a un valor numerico, luego se verifica que sea mayor a 0
                    costo1[costo2] = costo;
                    costo2++;
                } else {
                    System.out.println("El costo ingresado debe ser mayor a 0. Intente de nuevo.");
                    //si no lo es error
                }


                System.out.println("desea agregar mas veiculos s/n");
                op1 = scanner.nextLine();

            }
        } while (op1.equalsIgnoreCase("s"));
        System.out.println("regresando");
        vehiculo();
    }

    static void modificar() {
        String op2;
        do {


            System.out.println("Lista vehiculos");
            for (int i = 0; i < Vehiculos2; i++) {
                System.out.println("Vehículo " + (i + 1));
                System.out.println("Marca: " + Vehiculos1[i]);
                System.out.println("Línea: " + linea1[i]);
                System.out.println("Modelo: " + modelo1[i]);
                System.out.println("Placa: " + placa1[i]);
                System.out.println("Costo: " + costo1[i]);
                System.out.println("------------------------");
                //imprime una lista de las celdas array utilizadas
            }
            System.out.println("Ingrese el número del vehículo que desea modificar (0 para regresar):");
            int nuevoVehiculo = scanner.nextInt();
            //se lee el numero de veiculo que se quiere modificar
            scanner.nextLine();
            if (nuevoVehiculo > 0 && nuevoVehiculo <= Vehiculos2) {
                // variable nueva para reemplzar la anterior
                int indiceVehiculos = nuevoVehiculo - 1;
                // modifica el vahiculo desde el indice 1 por eso siempre s epone -1 porque mepzamos en 0
                System.out.println("Ingrese nueva marca:");
                Vehiculos1[indiceVehiculos] = scanner.nextLine();
                //cambio de datos
                System.out.println("Ingrese nueva línea:");
                linea1[indiceVehiculos] = scanner.nextLine();

                System.out.println("Ingrese nuevo modelo:");
                modelo1[indiceVehiculos] = scanner.nextLine();

                System.out.println("Ingrese nuevo costo:");
                costo1[indiceVehiculos] = scanner.nextLine();
            } else if (nuevoVehiculo == 0) {
                break;

            } else {
                System.out.println("Número de vehículo inválido. Intente de nuevo.");
                //el numero de vehiculo no existe
            }
            System.out.println("desea continuar s/n");
            op2 = scanner.nextLine();
        } while (op2.equalsIgnoreCase("s"));
        System.out.println("regresando");
        vehiculo();


    }
    static boolean estaRentado(String placa) {
        for (int i = 0; i < numRentas; i++) {
            if (placasRentadas[i].equalsIgnoreCase(placa)) {
                return true;
            }
        }
        return false;
    }

    static void eliminarVehiculo() {
        System.out.println("Lista de Vehículos Disponibles para Eliminar:");
        boolean hayVehiculosDisponibles = false;

        for (int i = 0; i < Vehiculos2; i++) {
            if (!estaRentado(placa1[i])) {
                hayVehiculosDisponibles = true;
                System.out.println("Vehículo " + (i + 1));
                System.out.println("Marca: " + Vehiculos1[i]);
                System.out.println("Línea: " + linea1[i]);
                System.out.println("Modelo: " + modelo1[i]);
                System.out.println("Placa: " + placa1[i]);
                System.out.println("Costo: " + costo1[i]);
                System.out.println("------------------------");
            }
        }

        if (!hayVehiculosDisponibles) {
            System.out.println("No hay vehículos disponibles para eliminar.");
            return;
        }

        System.out.println("Ingrese el número del vehículo que desea eliminar (0 para regresar):");
        int opcionEliminar = scanner.nextInt();
        scanner.nextLine();

        if (opcionEliminar > 0 && opcionEliminar <= Vehiculos2 && !estaRentado(placa1[opcionEliminar - 1])) {
            eliminarVehiculo(opcionEliminar - 1);
            System.out.println("Vehículo eliminado exitosamente.");
        } else if (opcionEliminar == 0) {
            System.out.println("Regresando al menú de vehículos...");
            vehiculo();
        } else {
            System.out.println("Número de vehículo inválido o el vehículo está rentado. Intente de nuevo.");
        }
    }
    static void eliminarVehiculo(int indice) {
        for (int i = indice; i < Vehiculos2 - 1; i++) {
            Vehiculos1[i] = Vehiculos1[i + 1];
            linea1[i] = linea1[i + 1];
            modelo1[i] = modelo1[i + 1];
            placa1[i] = placa1[i + 1];
            costo1[i] = costo1[i + 1];
            descuento1[i] = descuento1[i + 1];
            diasN1[i] = diasN1[i + 1];
            vehiculoDisponible[i] = vehiculoDisponible[i + 1];
        }

        Vehiculos1[Vehiculos2 - 1] = null;
        linea1[Vehiculos2 - 1] = null;
        modelo1[Vehiculos2 - 1] = null;
        placa1[Vehiculos2 - 1] = null;
        costo1[Vehiculos2 - 1] = null;
        descuento1[Vehiculos2 - 1] = null;
        diasN1[Vehiculos2 - 1] = null;
        vehiculoDisponible[Vehiculos2 - 1] = false;

        Vehiculos2--;

}


    static void descuento() {
        String op3 = "s";
        do {
            System.out.println("Ingrese el descuento:");
            String descuento = scanner.nextLine();

            if (Double.parseDouble(descuento) > 0 && Double.parseDouble(descuento) < 100) {
                descuento1[descuento2] = descuento;
                descuento2++;
            } else {
                System.out.println("El descuento ingresado debe estar entre 0 y 100. Intente de nuevo.");
                continue;
            }

            double descuentoporciento = Double.parseDouble(descuento);
            double descuentodecimal = descuentoporciento / 100.0;

            System.out.println("Ingrese los días necesarios:");
            String diasN = scanner.nextLine();
            if (Double.parseDouble(diasN) > 0) {
                diasN1[diasN2] = diasN; // Aquí es donde se corrige el error
                diasN2++;
            } else {
                System.out.println("Los días ingresados deben ser mayores a 0. ¿Desea intentar de nuevo? (s/n)");
                if (!scanner.nextLine().equalsIgnoreCase("s")) {
                    break;
                }
            }

            System.out.println("¿Desea agregar más descuentos? (s/n)");
            op3 = scanner.nextLine();
        } while (op3.equalsIgnoreCase("s"));

        vehiculo();
    }


    static void reporte() {
        System.out.println("1.reporte mostrando las marcas con más días rentados");
        System.out.println("2.reporte mostrando los modelos con más días rentados");
        int option = scanner.nextInt();
        scanner.nextLine();
        // int para el switch y sus opciones
        switch (option) {
            case 1:
            reporteMarcasMasRentadas();
                break;
            case 2:
               reporteModelosMasRentados();
                break;


        }

    }
    static void reporteMarcasMasRentadas() {
        System.out.println("Reporte de Marcas Más Rentadas:");

        // Crear un arreglo auxiliar para almacenar índices
        int[] indicesMarcas = new int[Vehiculos2];
        for (int i = 0; i < Vehiculos2; i++) {
            indicesMarcas[i] = i;
        }

        // Ordenar los índices según los días rentados por marca
        for (int i = 0; i < Vehiculos2 - 1; i++) {
            for (int j = 0; j < Vehiculos2 - i - 1; j++) {
                if (diasRentadosPorMarca[indicesMarcas[j]] < diasRentadosPorMarca[indicesMarcas[j + 1]]) {
                    // Intercambiar índices
                    int temp = indicesMarcas[j];
                    indicesMarcas[j] = indicesMarcas[j + 1];
                    indicesMarcas[j + 1] = temp;
                }
            }
        }

        // Mostrar el reporte ordenado
        for (int i = 0; i < Vehiculos2; i++) {
            int indiceMarca = indicesMarcas[i];
            System.out.println("Marca: " + Vehiculos1[indiceMarca] + " | Días Rentados: " + diasRentadosPorMarca[indiceMarca]);
        }
    }
    static void reporteModelosMasRentados() {
        System.out.println("Reporte de Modelos Más Rentados:");

        // Crear un arreglo auxiliar para almacenar índices
        int[] indicesModelos = new int[modelo2];
        for (int i = 0; i < modelo2; i++) {
            indicesModelos[i] = i;
        }

        // Ordenar los índices según los días rentados por modelo
        for (int i = 0; i < modelo2 - 1; i++) {
            for (int j = 0; j < modelo2 - i - 1; j++) {
                if (diasRentadosPorModelo[indicesModelos[j]] < diasRentadosPorModelo[indicesModelos[j + 1]]) {
                    // Intercambiar índices
                    int temp = indicesModelos[j];
                    indicesModelos[j] = indicesModelos[j + 1];
                    indicesModelos[j + 1] = temp;
                }
            }
        }

        // Mostrar el reporte ordenado
        for (int i = 0; i < modelo2; i++) {
            int indiceModelo = indicesModelos[i];
            System.out.println("Modelo: " + modelo1[indiceModelo] + " | Días Rentados: " + diasRentadosPorModelo[indiceModelo]);
        }
    }


    static void usuarios() {
        System.out.println("Lista de Usuarios:");
        for (int i = 0; i < usuario2A; i++) {
            System.out.println("Usuario " + (i + 1));
            System.out.println("Nombre: " + usuario1A[i] + " | Apellido: " + usuario1P[i] + " | NIT: " + usuariocontra1[i]);
            System.out.println("------------------------");
        }

    }

    static void Menucliente() {
        System.out.println("---Bienvenido--- ");
        System.out.println("1.Registrase");
        System.out.println("2.Iniciar seción");
        System.out.println("3.Menu principal");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                Registro();
                break;
            case 2:
                inicisecion();
                break;
            case 3:
                continuar = false;
                break;
        }


    }

    static void Registro() {
        String op4 = "n";
        //variable para ser usada en el do/while
        do {
            System.out.println("ingrese su nombre");

            String nombre = scanner.nextLine();
            usuario1A[usuario2A] = nombre;
            usuario2A++;

            System.out.println("ingrese su apellido");

            String apellido = scanner.nextLine();
            usuario1P[usuario2P] = apellido;
            usuario2P++;


            System.out.println("ingrese su nit");
            String nit = scanner.nextLine();
            Boolean nitexistente = false;
            // variable boolean en falso para saber  ya existe en el sistema
            for (int i = 0; i < ususariocontra2; i++) {
                //bucle for para recorrer el indice de placas
                if (usuariocontra1[i] != null && usuariocontra1[i].equalsIgnoreCase(nit)) {
                    //se verifica que la placa no exista, el equalsIgnoreCase para que no lea mayusculas o minusculas
                    nitexistente = true;
                    //si existe una placa se desplega un mensaje de existente si no continua normal el programa
                    System.out.println("El NIT ingresado ya está registrado. Intente de nuevo.");
                    break;
                }
            }
            if (!nitexistente) {
                usuariocontra1[ususariocontra2] = nit;
                ususariocontra2++;
                System.out.println("Registro exitoso.");
            }

        } while (op4.equalsIgnoreCase("s"));
        System.out.println("regresando");
        Menucliente();
    }

    static void inicisecion() {

        System.out.println("Ingrese su contraseña");
        String contraseña1 = scanner.nextLine();
        boolean usuariovalido = false;
        int indiceUsuario = -1;

        for (int i = 0; i < ususariocontra2; i++) {
            if (usuariocontra1[i].equals(contraseña1)) {
                usuariovalido = true;
                indiceUsuario = i;
                break;
            }
        }

        if (usuariovalido) {
            Menurenta(usuario1A[indiceUsuario]);
        } else {
            System.out.println("Usuario no válido");
            Menucliente();
        }
    }


    static void Menurenta(String usuarioActual) {
        System.out.println("bienvenido");
        System.out.println("1.Realizar orden de renta");
        System.out.println("2.Ver factura");
        System.out.println("3.Finalizar renta");

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                ordenrenta(usuarioActual);
                break;
            case 2:
                mostrarFactura(usuarioActual);
                break;
            case 3:
                Menucliente();
                break;

        }
    }




    static void ordenrenta(String usuarioActual) {
        String op5 = "n";
        do {
            System.out.println("Lista de Vehículos:");
            for (int i = 0; i < Vehiculos2; i++) {
                System.out.println("Vehículo " + (i + 1));
                System.out.println("Marca: " + Vehiculos1[i] + " | Línea: " + linea1[i] + " | Modelo: " + modelo1[i] +
                        " | Placa: " + placa1[i] + " | Costo: " + costo1[i]);
                System.out.println("------------------------");
            }
            System.out.println("Lista de Descuentos y Días Necesarios:");
            for (int i = 0; i < descuento2; i++) {
                System.out.println("Descuento " + (i + 1));
                System.out.println("Descuento: " + descuento1[i] + "% | Días Necesarios: " + diasN1[i]);
                System.out.println("------------------------");
            }
            System.out.println("Ingrese el número de placa del vehículo que desea rentar:");
            String placarenta = scanner.nextLine();

            boolean placaEncontrada = false;
            int indiceEncontrado = -1;
            for (int i = 0; i < placa1.length; i++) {
                if (placa1[i] != null && placa1[i].equalsIgnoreCase(placarenta)) {
                    placaEncontrada = true;
                    indiceEncontrado = i;
                    break;
                }
            }

            if (placaEncontrada) {
                boolean placaRentada = false;
                for (int i = 0; i < numRentas; i++) {
                    if (placasRentadas[i].equalsIgnoreCase(placarenta)) {
                        placaRentada = true;
                        break;
                    }
                }

                if (!placaRentada) {
                    System.out.println("Ingrese la cantidad de días de renta:");
                    int diasRenta = Integer.parseInt(scanner.nextLine());

                    // Realizar la renta y registrar la información
                    vehiculoDisponible[indiceEncontrado] = false;
                    placasRentadas[numRentas] = placarenta;
                    usuariosQueRentaron[numRentas] = usuarioActual;
                    diasDeRenta[numRentas] = diasRenta;
                    numRentas++;

                    // Incrementar contadores de días rentados
                    String marcaRentada = Vehiculos1[indiceEncontrado];
                    for (int i = 0; i < Vehiculos2; i++) {
                        if (Vehiculos1[i].equals(marcaRentada)) {
                            diasRentadosPorMarca[i] += diasDeRenta[numRentas - 1];
                            break;
                        }
                    }

                    String modeloRentado = modelo1[indiceEncontrado];
                    for (int i = 0; i < modelo2; i++) {
                        if (modelo1[i].equals(modeloRentado)) {
                            diasRentadosPorModelo[i] += diasDeRenta[numRentas - 1];
                            break;
                        }
                    }

                    System.out.println("Vehículo rentado exitosamente.");
                } else {
                    System.out.println("Esta placa ya ha sido rentada por otro usuario.");
                }
            } else {
                System.out.println("Placa no encontrada.");
            }

            System.out.println("¿Desea continuar rentando vehículos? (s/n)");
            op5 = scanner.nextLine();
        } while (op5.equalsIgnoreCase("s"));

        System.out.println("Regresando al menú principal...");
        mostrarFactura(usuarioActual);

    }

    static void mostrarFactura(String usuarioActual) {
        int indiceUsuario = buscarIndiceUsuario(usuarioActual);

        if (indiceUsuario == -1) {
            System.out.println("Usuario no encontrado.");
            Menucliente();
            return;
        }

        System.out.println("Factura de Alquiler");
        System.out.println("Nombre de la empresa: ByteCar");
        System.out.println("Nombre del cliente: " + usuario1A[indiceUsuario]);
        System.out.println("Número de NIT: " + usuariocontra1[indiceUsuario]);
        System.out.println("Fecha y hora de emisión: " + obtenerFechaYHoraActual());

        double subtotal = 0.0;
        double descuento = 0.0;
        double total = 0.0;

        System.out.println("Listado de vehículos rentados:");
        boolean vehiculosRentados = false;

        for (int i = 0; i < numRentas; i++) {
            if (usuariosQueRentaron[i].equals(usuarioActual)) {
                vehiculosRentados = true;
                int indiceVehiculo = buscarIndiceVehiculo(placasRentadas[i]);
                double costoVehiculo = Double.parseDouble(costo1[indiceVehiculo]);
                int diasRenta = diasDeRenta[i];

                System.out.println("Modelo: " + modelo1[indiceVehiculo]);
                System.out.println("Línea: " + linea1[indiceVehiculo]);
                System.out.println("Placa: " + placasRentadas[i]);
                System.out.println("Días rentados: " + diasRenta);
                System.out.println("Costo total por los días rentados: $" + (costoVehiculo * diasRenta));
                System.out.println("------------------------");

                subtotal += costoVehiculo * diasRenta;
            }
        }

        for (int i = 0; i < descuento2; i++) {
            if (usuariosQueRentaron[numRentas - 1].equals(usuarioActual) && diasDeRenta[numRentas - 1] >= Integer.parseInt(diasN1[i])) {
                descuento = subtotal * (Double.parseDouble(descuento1[i]) / 100.0);
                break;
            }
        }

        total = subtotal - descuento;

        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Porcentaje de descuento: " + descuento + "%");
        System.out.println("Total a pagar: $" + total);

        if (!vehiculosRentados) {
            System.out.println("No ha rentado ningún vehículo.");
        }

        System.out.println("Regresando al menú principal...");
        Menucliente();
    }

    static int buscarIndiceUsuario(String usuarioActual) {
        for (int i = 0; i < usuario2A; i++) {
            if (usuario1A[i].equals(usuarioActual)) {
                return i;
            }
        }
        return -1; // Si no se encuentra el usuario
    }



    static String obtenerFechaYHoraActual() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    static int buscarIndiceVehiculo(String placa) {
        for (int i = 0; i < placa1.length; i++) {
            if (placa1[i] != null && placa1[i].equalsIgnoreCase(placa)) {
                return i;
            }
        }
        return -1; // Si no se encuentra la placa
    }



}