/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avionlab;

/**
 *
 * @author Monica
 */
public class Avionlab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creaciondevariablesymatrices
        int cl;
        int ub=0, ced;
        int ceding;
        int rep;
        String nom= "nombre";
        int A1[][] = new int[4][4];
        int A2[][] = new int[4][4];
        String A3[][] = new String[4][4];
        int A4[][] = new int[4][4];
        int A5[][] = new int[4][4];
        int B1[][] = new int[7][6];
        int B2[][] = new int[7][6];
        String B3[][] = new String[7][6];
        int B4[][] = new int[7][6];
        int B5[][] = new int[7][6];
        
        int i; int j;
        int n;int n2;int n3;
        for(i=0; i<4; i=i+1){
            n=1;
            for(j=0; j<4; j=j+1){
                A1[i][j]=n;
                n=n+1;
            }
        }
        for(i=0; i<4; i=i+1){
            n2=1;
            for(j=0; j<2; j=j+1){
                A5[i][j]=n2;
                n2=n2+1;
            }
        }
        for(i=0; i<4; i=i+1){
            n3=2;
            for(j=2; j<4; j=j+1){
                A5[i][j]=n3;
                n3=n3-1;
            }
        }       
             
        n=9;
        for(i=0; i<7; i=i+1){
            for(j=0; j<6; j=j+1){
                B1[i][j]=n;
                n=n+1;
            }
        }
        for(i=0; i<7; i=i+1){
            n2=1;
            for(j=0; j<3; j=j+1){
                B5[i][j]=n2;
                n2=n2+1;
            }
        }
        for(i=0; i<7; i=i+1){
            n3=3;
            for(j=3; j<6; j=j+1){
                B5[i][j]=n3;
                n3=n3-1;
            }
        }
        //
        //1.Asignacion de sillas
        do{
        java.util.Scanner lectura = 
                new java.util. Scanner(System.in);
        System.out.println("Digite su numero de Cedula");
        ced = lectura.nextInt();
        java.util.Scanner sc = 
              new java.util. Scanner(System.in);
        System.out.println("Digite su nombre");
        nom = sc.nextLine();
        System.out.println("Digite 1 si deseea clase Ejecutiva o 2 si deseea clase Economica");
        cl = lectura.nextInt();
        switch(cl){
            case 1: 
                System.out.println("Digite 1 si deseea Ventana, o 2 si deseea Pasillo");
                ub = lectura.nextInt();
                break;
            case 2:
                System.out.println("Digite 1 si deseea Ventana, 2 si deseea Centro o 3 si deseea Pasillo");
                ub = lectura.nextInt();
                break;
        }
        
        if(cl==1){
            for(i=0; i<4; i=i+1){
                for(j=0; j<4; j=j+1){
                    if(A5[i][j]==ub){
                        if(A2[i][j]==0){
                            A2[i][j]=1;
                            A3[i][j]=nom;
                            A4[i][j]=ced;
                            break;  
                        } 
                    if(A2[i][j]==1) break;    
                    }     
                    if(A2[i][j]==1) break; 
                }   
                if(A2[i][j]==1) break; 
            }
        }
        
        else if(cl==2){
            for(i=0; i<7; i=i+1){
                for(j=0; j<6; j=j+1){
                    while(B5[i][j]==ub){
                        if(B2[i][j]==0){
                            B2[i][j]=1;
                            B3[i][j]=nom;
                            B4[i][j]=ced; 
                            break;  
                        }
                        if(B2[i][j]==1) break;
                    }
                    if(B2[i][j]==1) break;
                }
                if(B2[i][j]==1) break;
            }
        }
        System.out.println("Digite 1 para ingresar otro pasajero");
        rep = lectura.nextInt();
        }while(rep==1);
        //
        
        /// for(i=0;i<4;i=i+1){
        ///    for(j=0;j<4;j=j+1){
        ///        System.out.println(A2[i][j]);
        ///    }         
        /// }
        /// System.out.println("-");
        /// for(i=0;i<7;i=i+1){
        ///    for(j=0;j<6;j=j+1){
        ///        System.out.println(B2[i][j]);
        ///   }
        /// }
        
        //2.Reporte
        java.util.Scanner lectura = 
                new java.util. Scanner(System.in);
        System.out.println("El numero de sillas de clase Ejecutivas ocupadas es: " + EjecutivasOcupadas(A2));
        System.out.println("Ingrese la cedula:");
        ceding = lectura.nextInt();
        System.out.println("La silla es la numero:" + LocalizarCedula(A1, A4, B1, B4, ceding));
        System.out.println("Se encuentran disponibles ");
        System.out.println(VentanaEconomica (B5, B2));
        NombresIguales(A3,A1);
        
               
        // TODO code application logic here
    }
    public static int EjecutivasOcupadas(int A2[][]){
        int i, j, cont=0;
        for(i=0; i<4; i=i+1){
            for(j=0; j<4; j=j+1){
                if(A2[i][j]==1){
                    cont=cont+1;
                }
            }
        }
            
        return cont;
    }
    
     public static int LocalizarCedula (int A1[][], int A4[][], int B1[][], int B4[][], int ceding){
        int i, j, ret=0;   
        for(i=0; i<4; i=i+1){
            for(j=0; j<4; j=j+1){
                if(A4[i][j]==ceding){
                    ret= A1[i][j];
                }
            }
        }
        for(i=0; i<7; i=i+1){
            for(j=0; j<6; j=j+1){
                if(B4[i][j]==ceding){
                    ret= B1[i][j];
                }
            }
        }
        return ret;
    }
    
    public static int VentanaEconomica (int B5[][], int B2[][]){
        int i, j , cont=0;
        for(i=0; i<7; i=i+1){
            for(j=0; j<6; j=j+1){
                if(B5[i][j]==1){
                    if(B2[i][j]==0){
                        cont=cont+1;
                    }
                }
            }
        }
        return cont;
    }
    
    public static void NombresIguales (String A3[][], int A1[][]){
        int i, j, ii, jj;
        for(i=0; i<7; i=i+1){
            for(j=0; i<6; j=j+1){
                for(ii=0; ii<7;ii=ii+1){
                    for(jj=0; jj<6; jj=jj+1){
                        if(A3[i][j]==A3[ii][jj] && i!=ii && j!=jj){
                            System.out.println("Los pasajeros de las sillas" + A1[i][j] + "y" + A1[ii][jj] + "tienen el mismo nombre: " + A3[i][j]);
                        }
                    } 
                }
            }
        }
    }   

  
     
}
