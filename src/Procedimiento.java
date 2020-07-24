import java.util.Scanner;
public class Procedimiento {
	//private String Lcaptura="";
		private int importe;
		private int llaveSecreta;
		private String subCadenaA;
		private Convertidor b = new Convertidor ();
		private String primeros18a10="";
		private int suma=0;
		private int resModulo;
		private int sumaYanio;
		private String numFin="";
		private String CadenaTotal="";
		private String MensajeAnio="";
		
		private int Serie[]= {11,13,17,19,23};
		//Contructor
		public Procedimiento() {
			//subCadenaA="88SER992JXJK75MVYK5C";
			importe=3259;
			llaveSecreta=12357113;
			subCadenaA="";
			
		}
		
		
		//Getters and Setters
		public int getImporte() {
			return importe;
		}

		public String getsubCadenaA() {
			return subCadenaA;
		}

		public void setLCapturaDeco(String lCapturaDeco) {
			subCadenaA = lCapturaDeco;
		}

		public void setImporte(int importe) {
			this.importe = importe;
		}

		public int getLlaveSecreta() {
			return llaveSecreta;
		}

		public void setLlaveSecreta(int llaveSecreta) {
			this.llaveSecreta = llaveSecreta;
		}
		//Fin de Getters and Setters
		
		public String realizarOperación() {
			
			//Vriables para entrada
			Scanner entrada=new Scanner(System.in);
			String e1;
			//Fin de variables para entrada
			int resultado =0;
			
			//Objeto para conversiones de bases
			//BaseNaBaseDec b = new BaseNaBaseDec();//Se crea el nuevo objeto
			
			
			b.setsCadena("88SER992JXJK75MVYK5C");
			
			System.out.println("Entero beta: "+b.EnteroBeta());
			System.out.println("LLave secreta: "+llaveSecreta);
			System.out.println("Importe: "+ importe);
			int potencia = (int)(Math.pow(30, 5));
			System.out.println("Potencia de 30 a la 5: "+potencia);
			resultado=(b.EnteroBeta()-llaveSecreta-importe)%potencia; 
			
			if(resultado<0) {
				resultado = resultado+potencia;
			}  //EnteroAlfa
			System.out.println("Entero alfa: "+resultado);
			// Obteniendo enteroAlfa en base 30 subCadenaA
			subCadenaA= b.transformarDecAN(String.valueOf(resultado), 10, 30);
			System.out.println("SubCadena A: " +subCadenaA);
			
			//Con 5C:
			String aux= b.getsCadena().substring(0,13)+subCadenaA+b.getsCadena().substring(18,20);
			
			//Sin 5C: Sustituimos SubCadena en la linea de Captura
			//String aux= b.getsCadena().substring(0,13)+subCadenaA+"--";
			subCadenaA=aux;
			System.out.println("Sustitucion de la linea de captura con Subcadena A: "+subCadenaA);
			
			//Imprimeindo el resultado
			//System.out.println(LCapturaDeco);
			return subCadenaA;
			
		}

		public void LineaDeCapturaBase() { 
			
			String CadenaAConvertir=realizarOperación().substring(0,18);
			String c1="";
			//System.out.println(primeros18a10);
			//Convertir esos digitos en base 10 
			int j=0;
			for(int i =CadenaAConvertir.length()-1; i>=0;i--) {
				c1 = Character.toString(CadenaAConvertir.charAt(i));
				//System.out.println(c1);
				primeros18a10+=(int)b.CaracterAB10(c1);
				//(int)b.convierteUnCaracterAB10(c1);
				if(j<=4) {
					suma+=(int)b.CaracterAB10(c1)*Serie[j];
					System.out.println((int)b.CaracterAB10(c1)*Serie[j]);
					System.out.println("El valor decimal es: "+b.CaracterAB10(c1));
					j++;
				}else {
					j=0;
					suma+=(int)b.CaracterAB10(c1)*Serie[j];
					System.out.println((int)b.CaracterAB10(c1)*Serie[j]);
					j++;
					System.out.println("El valor decimal es: "+b.CaracterAB10(c1));
				}
				
			}
			
			int anio=2007;
			sumaYanio=suma+anio;
			System.out.println("La suma total es:"+ suma);
			System.out.println("La suma total: "+ sumaYanio+" de anio "+anio+" + suma total "+suma);
			int mod=887;
			resModulo=sumaYanio%mod;
			System.out.println("El modulo de la suma es: "+ resModulo);
			String aux=""+(int)resModulo;
			numFin=b.transformarDecANabecedario(aux, 10, 30);
			System.out.println("El valor de la cadena a base 30 : "+numFin);
			CadenaTotal= subCadenaA;
			if(b.getsCadena().substring(18,20).equals(numFin)) {
				MensajeAnio="Anio vigente";
			}else {
				MensajeAnio="Anio no vigente";
			}
			
			//System.out.println(primeros18a10);
			System.out.println(MensajeAnio);
		}
		
		/*public String toString() {
			return "\n***************************************************************************\n"+
					"La linea de Captura es: "+ b.getsCadena()+
					"\nLinea de Captura de entrada decodificada es: "+ subCadenaA +
					"\nPrimeros 18 a base 10: "+primeros18a10+
					"\nLa suma es:"+suma+"\nSumando el anio: "+sumaYanio+
					"\nAplicando el resultado al modulo: "+ resModulo+
					"\nRepresentado en base 30: "+numFin+
					"\nAgregando el resultado anterior a La linea de Captura Decodificada: "+CadenaTotal+
					"\n"+MensajeAnio;
		}*/
	}



