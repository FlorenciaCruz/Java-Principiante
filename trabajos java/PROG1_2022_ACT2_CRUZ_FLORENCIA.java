package prog1_2022_act2_cruz_florencia;
import java.util.Scanner;
public class PROG1_2022_ACT2_CRUZ_FLORENCIA {
    //_____________________________________________________________________________________
//fecha: 23/05/2022
//Asignatura: Programacion 1
//Tema elegido: Contraseñas
//Alumna: Florencia Cruz
//Descripcion:es un Home Banking del banco MONEY donde desarrolla,
//1)mensaje donde explica la problematica de la seguridad
//2)renueva contraseña de letras(le pide al usuario ingreso de contraseña y pueden ser letras con numeros)
//la condicion es que se repita dos veces la misma contraseña.
//3)renueva contraseña de numeros(solamente permite ingresar numeros)
//la validacion es que no pueda ingresar letras.
//4)menu de opciones de caja de ahorro, extraccion y salida.
//la caja de ahorro cuenta con un monto de $40000 en donde podes hacer extracciones hasta apretar la opcion salir.
//______________________________________________________________________________________
 /* **************************************************************************
                                     ANALISIS
    *  ***********************************************************************     
    DATOS DE ENTRADA:
    FUNCION(main):opcion,funcion_clave.
    FUNCION(ingresar_contra):pclave,pclave2.
    FUNCION(clave_numerica):clave_ingresada.
    FUNCION(menu_principal):popcion,pnum,pN.
    
    DATOS DE SALIDA:
    FUNCION(menu_principal):popcion,ppesos,presta,pacumulador,pnum,band,pmax,pmin,pN.
    FUNCION(clave_numerica):ppesos,pmax,pmin,band.
    
    PROCESOS:
    FUNCION(menu_principal):presta,pacumulador,pnum,band.
    FUNCION(clave_numerica):clave_numerica,cont.
    FUNCION(menu_principal):presta,pacumulador.
    ***************************************************************************/
    public static void main(String[] args) {
    

   /* ************************************************************************
                 P R O G R A M A     P R I N C I P A L
    *  ************************************************************************/                      
        int opcion=0;
        String funcion_clave="";
        Scanner entrada = new Scanner(System.in);
        mensaje_de_entrada();
        ingresar_contra();
        funcion_clave = clave_numerica();
        opcion=menu_principal();               
    }      
/* ************************************************************************
                          MENSAJE DE ENTRADA
*************************************************************************** 
 	Descripción:muestra el mensaje de bienvenida y explica la renovacion
        de seguridad
        tipo:procedimiento
	párametros de entrada: ninguno
	páramentros de salida: ninguno
    ***************************************************************************/
    public static void mensaje_de_entrada(){
        System.out.println("\033[36m________________________________ ");
        System.out.println("\033[30mBienvenido a Home Banking MONEY ");
        System.out.println("\033[36m ________________________________ ");
        System.out.println("");
        System.out.println("\033[30mEstamos renovando la seguridad del banco,"
                + " necesita cambiar la contraseña ");
    }
       /* ************************************************************************
                          INGRESAR CONTRASEÑA
    *  ***********************************************************************
     	Descripción:pide ingreso de contraseña alfabetica dos veces, que sea igual
        a la anterior de lo contrario muestra el cartel de contraseña incorrecta.
        tipo:procedimiento
	párametros de entrada:ninguno 
	páramentros de salida:ninguno
    ***************************************************************************/        
    public static void ingresar_contra(){		
	//Declaración de objetos
	Scanner entrada=new Scanner(System.in);		
        //Declaracón de variables locales
        String pclave = "";
        String pclave2="";
        System.out.println("\033[36m*cambio de contraseña");
        System.out.println("\033[30m__Escribi la clave alfanumerica__");
        //Ingreso de la clave
        pclave = entrada.nextLine();   	
        
        while(pclave.equals(pclave2)==false){
            System.out.println("__Repite la clave:__");
            pclave2 = entrada.nextLine();
            
            if (pclave.equals(pclave2)==true){
                System.out.println("\033[30mla contraseña se guardo \033[32mexitosamente"); 
                System.out.println("\033[30msu nueva contraseña es:"+pclave2);
            }    
            if (pclave.equals(pclave2)==false){
                System.out.println("\033[31mcontraseña incorrecta");             
            }
        }
           
    }
     /* ************************************************************************
                             FUNCION CLAVE NUMERICA
    *  ***********************************************************************
     	Descripción:pide ingreso de clave numerica, valida datos ingresados sean numeros 
        si ingresas letras te muestra el mensaje de error
        tipo:funcion
	párametros de entrada:ninguno
	páramentros de salida:clave_numerica
    ***************************************************************************/ 
    public static String clave_numerica(){
        //Declaración de objetos
	Scanner entrada=new Scanner(System.in);      
        System.out.println("__Escribi la clave numerica__");
        //pide el ingreso de numeros hasta 4 veces
        char clave_ingresada='j';
        String clave_numerica="";
        
        for (int cont=1; cont<=4; cont++){
            while(!Character.isDigit(clave_ingresada)){//mientras que no se un digito lo ejecuta
                clave_ingresada = entrada.next().charAt(0);
                if (Character.isDigit(clave_ingresada)){
                    clave_numerica = clave_numerica.concat(Character.toString(clave_ingresada));
                 //si es un dig lo suma a la clave numerica   
                }
                else{
                   
                    System.out.println("\033[31mError:Ingrese un valor numerico entre 0 y9\033[30m");   
                   
                }                         
        }    
             clave_ingresada='j';//para que pueda entrar al while en la proxima ejecucion del for.                         
    }
        System.out.println("\033[30mla clave ingresada es:"+clave_numerica);
        //devolucion parametro de salida
        return clave_numerica;
    }
     /* ************************************************************************
                                    MENU
    *  **********************************************************************
     	Descripción:muestra el menu de opciones
        tipo:procedimiento
	párametros de entrada:ninguno
	páramentros de salida:ninguno
    ***************************************************************************/ 
    public static void menu(){    
        System.out.println("\033[36m*********************");
        System.out.println("\033[30mMENU DE BANCO MONEY");
        System.out.println("\033[36m*********************");
        System.out.println("\033[30m1)VER CAJA DE AHORRO");
        System.out.println("2)EXTRACCION DE CAJA DE AHORRO");
        System.out.println("3)SALIR DEL PROGRAMA");   
        
    }    
    
     /* ************************************************************************
                                MENU PRINCIPAL
    *  **********************************************************************
     	Descripción:llamo al procedimiento menu() y resuelvo que hace cada opcion
        llamando a los funciones opcion1, opcion2, opcion2_sub.
        tipo:funcion
	párametros de entrada:pN.
	páramentros de salida:popcion
    ***************************************************************************/ 
    //Repito el menu hasta que la opcion sea distinta de 3
    public static int menu_principal(){
    //declaracion de objetos
         Scanner entrada=new Scanner(System.in);
    //variables locales
         int popcion=-1;
         int ppesos=40000;
         int presta=0;
         int pacumulador=0;
        
         int pnum=0;
         boolean band=true;
         int   pmax=10000000;
         int   pmin=0;
         int   pN=0;
        // int   i=1;
         int variable_opcion1=0;
         int variable_opcion2=0;
         int variable=0;
         
        
      
        System.out.println("INGRESE UNA OPCION:");
     // popcion = entrada.nextInt(); 
        while(popcion!=3){
              menu();//llamo al procedimiento menu
            //popcion = entrada.nextInt();
             popcion = entrada.nextInt(); 
            //  break;  
        switch(popcion){
                case 1:
                       // llamo a la funcion opcion1
                       presta=opcion1(ppesos,presta,pacumulador);
                    break;
                case 2:
                       // llamo a la funcion opcion2
                        pN=opcion2(pN,pnum,presta,pacumulador,pmax,pmin,band);    
                       // llamo a la funcion opcion2_sub
                        variable= opcion2_sub(pN,pnum,presta,pacumulador,pmax,pmin, band,ppesos);
                         
                    break; 
                case 3:
                     System.out.println("SALIENDO DEL PROGRAMA...");    
                    
                    
                    
                    
       }        
                        
   }  
      //devolucion parametro de salida
      return popcion;
   }
    
 /* ************************************************************************
                          CAJA DE AHORRO
*************************************************************************** 
 	Descripción:opcion1 es la funcion que hice para el case1 de la funcion menu_principal().
        muestra la caja de ahorro y el monto restante con extracciones.
        tipo:funcion
	párametros de entrada: ninguno
	páramentros de salida: presta
    ***************************************************************************/      
//FUNCION DE PRIMERA OPCION    
public static  int opcion1(int ppesos,int presta, int pacumulador){     
                    
    
    Scanner entrada=new Scanner(System.in);
    
    System.out.println("\033[36m*Caja de ahorro*:");
    System.out.println("\033[30mMonto inicial: $40.000");
    //monto restante con extracciones.
    presta = (ppesos-pacumulador);                   
    System.out.println("\033[30mMonto restante con extracciones: $"+presta); 
    //devolucion parametro de salida
    return presta;
                   
}
/* ************************************************************************
                         EXTRACCIONES
*************************************************************************** 
 	Descripción:opcion2 es la funcion que hice para el case2 de la funcion menu_principal().
        escribo por teclado la cantidad de extracciones que quiero realizar.
        tipo:funcion
	párametros de entrada: ninguno
	páramentros de salida: pN
    ***************************************************************************/
public static int opcion2(int pN,int pnum,int presta,int pacumulador,int pmax,int pmin,boolean band){
    
Scanner entrada=new Scanner(System.in);    
 System.out.println("Verifique cuanto dinero tiene en Op1, para poder realizar extracciones");
                    System.out.println("\033[36m*Extraccion de dinero*:");                  
                    System.out.println("Ingrese la cantidad de extracciones a realizar:");
                     pN=entrada.nextInt();
                     //devolucion parametro de salida
                      return pN;
}    
/* ************************************************************************
                        EXTRACCIONES CON TICKET
*************************************************************************** 
 	Descripción:en esta funcion es donde repito la extraccion hasta la cantidad de veces
        que el usuario quiera extraer, esta funcion es la continuacion de opcion2 y esta llamadada en 
        la funcion menu_principal().
        me muestra el maximo de plata que extraje, el minimo de plata que extraje, en caso que supere
        el monto incial de 40000 tendra un saldo deudor, tambien te muestra el dinero que te queda en la cuenta.
        tipo:funcion
	párametros de entrada: ninguno
	páramentros de salida: pN
    ***************************************************************************/
public static int opcion2_sub(int pN,int pnum,int presta,int pacumulador,int pmax,int pmin,boolean band,int ppesos){ 
   Scanner entrada=new Scanner(System.in);
    for(int i = 0; i < pN; i++){      
                        if(presta==0){
                            presta=1;
                        }
                        if(pnum<presta){
                        System.out.print("INGRESE EL MONTO A EXTRAER:");                      
                        pnum = entrada.nextInt();
                        pacumulador=pacumulador+pnum;              
                        if(band==true){
                            pmax=pnum;
                            pmin=pnum;
                            band=false;
                        } else {
                            if(pnum>pmax) {
                                pmax=pnum;
                            }else{
                                if(pnum<pmin){
                                    pmin=pnum;
                                }
                            }
                        }
                    }
    }
                     if(pacumulador<=40000){
                    System.out.println("*---------------------------------------------------------------*");
                    System.out.println("            TICKET DE EXTRACCIONES BANCO MONEY                 ");
                    System.out.println("               TOTAL EXTRAIDO:"+pacumulador+"                     ");
                    presta = (ppesos-pacumulador);
                    System.out.println("               \033[30mDINERO DISPONIBLE EN LA CTA CTE: $"+presta+"  ");
                    System.out.println("               EL MAXIMO DE DINERO EXTRAIDO ES: $"+pmax+ "          ");
                    System.out.println("               EL MINIMO DE DINERO EXTRAIDO ES: $"+pmin+ "          "); 
                    System.out.println("               GRACIAS POR CONFIAR EN NOSOTROS                      ");  
                    System.out.println("-----------------------------------------------------------------");
                    }else{
                     
                        //de lo contrario aparece el saldo deudor
                        System.out.println("*---------------------------------------------------------------*");
                        System.out.println("             TICKET DE EXTRACCIONES BANCO MONEY               ");
                        System.out.println("EL MONTO ES MAYOR A SU SALDO");
                        System.out.println("TOTAL EXTRAIDO:"+pacumulador);
                        presta = (ppesos-pacumulador);
                        System.out.println("\033[30mSALDO DEUDOR DE: $"+presta);
                        System.out.println("EL MAXIMO DE DINERO EXTRAIDO ES: $"+pmax);
                        System.out.println("EL MINIMO DE DINERO EXTRAIDO ES: $"+pmin); 
                        System.out.println("             GRACIAS POR CONFIAR EN NOSOTROS                  ");  
                        System.out.println("---------------------------------------------------------------");
                    }
                    //devolucion parametro de salida
                      return pN;
}                   
}    
/**********************************************************************************************************
                                    PRUEBA DE ESCRITORIO
 **********************************************************************************************************
  INTENTO       CLAVE       CLAVE2       NUMERO      OPCION    PN      NUM      MAX       MIN       RESTA
 **********************************************************************************************************
 *     1     *  telefono  *  telefono *  9803      *    2     *  2   *  200  *   200  *   100    *   39700                                                                 
 *           *            *           *            *          *      *  100  *        *          *         
 *           *            *           *            *          *      *       *        *          *         
 * *********************************************************************************************************
 *     2     *   clave  *  clave     *  4562      *    2     *  4   *  100  *   400  *    100    *   39000                                                                    
 *           *          *            *            *          *      *  200  *        *           *         
 *           *          *            *            *          *      *  300  *        *           *
 *           *          *            *            *          *      *  400  *        *           *
 * *********************************************************************************************************
 */

    
        
    
    

