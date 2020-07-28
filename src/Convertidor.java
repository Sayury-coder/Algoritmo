
public class Convertidor {
	

		private String subCdena;//SE USA PARA EXTRAER LA CADENA  DE sCadena QUE SE QUIERA
		//String sCadena="5MVYK";
		private String sCadena;// = "88SER992JXJK75MVYK5C";
		
		//Abecedarios para realizar las conversiones
		private String abecedario="0123456789ABCDEFHJKMNPQRTUVWXY";//Especifico para el cifrado
		private String abecedario2="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";//Abecedario normal
		/*Se usa el abecedario normal, para implementar en nuestro caso en especifico
		 * los resultados de las funciones de java que nos convierten 
		 * un numero decimal a cualquier base */
		
		//Consntructor
		public Convertidor() {
			this.subCdena="";
			this.sCadena = "88SER992JXJK75MVYK5C";
		}
		//Fin de cosntructor
		
		//Getters and Setter
		public String getSubCdena() {
			return subCdena;
		}

		public void setSubCdena(String subCdena) {
			this.subCdena = subCdena;
		}

		public String getsCadena() {
			return sCadena;
		}

		public void setsCadena(String sCadena) {
			this.sCadena = sCadena;
		}

		public String getAbecedario() {
			return abecedario;
		}

		public void setAbecedario(String abecedario) {
			this.abecedario = abecedario;
		}

		public String getAbecedario2() {
			return abecedario2;
		}

		public void setAbecedario2(String abecedario2) {
			this.abecedario2 = abecedario2;
		}
		//Fin de Getters and Setter
		
		
		/*****************Transformar de base n a Decimal*******************/
		 public int EnteroBeta() {
			 
			 String SubCadenaB = sCadena.substring(13,18);
			 
			 int resultado= 0;
			 String potencia="";
			 for (int x=SubCadenaB.length()-1;x>=0;x--)
				 potencia = potencia + SubCadenaB.charAt(x);
			
			 potencia.toUpperCase();
			 //System.out.println(potencia);
			 //System.out.println("La subcadena es: "+SubCadenaB+" ontenida de: "+sCadena);
			 potencia.length();
			 
			 for(int i=potencia.length()-1; i>=0;i--) {
				 //System.out.println(potencia.charAt(i));
				 for(int j=0; j<abecedario.length();j++) {
					 if(potencia.charAt(i)==abecedario.charAt(j)) {
						 //System.out.println(i);
						 double aux=(double)Math.pow(30,i);
						 //System.out.println(aux);
						 //System.out.println(j);
						 resultado+=(j*aux);
						// System.out.println(resultado);
					 }
				 }
					 
			 }
			 return resultado;
			//System.out.println(resultado);
		 }
		 
		
		/************************Transformar de Decimal a Base N**************/
		 public String transformarDecAN(String numero, int baseOrigen, int baseDestino) {
			 
			    int numeroBase10 = Integer.parseInt(numero, baseOrigen);            // convierte a base 10 cualquier numero en otra base
			    String numeroBaseB = Integer.toString(numeroBase10, baseDestino);   // convierte numeroBase10 a otra base
			    numeroBaseB=numeroBaseB.toUpperCase();
			    //System.out.println(numeroBaseB);
			    String result="";
			    for(int i=0;i<numeroBaseB.length();i++) {
			    	for(int j=0; j<abecedario2.length();j++)
			    		if(numeroBaseB.charAt(i)==abecedario2.charAt(j)) {
			    			if(j<15) {
					    		result+=numeroBaseB.charAt(i);
					    	}else if(j<=29){
					    		//System.out.println("Hola"+result);
					    		result+=abecedario.charAt(j);
					    	}else {
					    		result+=abecedario2.charAt(j);
					    	}
			    		}	    	
			    }
			    //System.out.println(result);
			    return result;
		}
		 /************************Transformar de Decimal a Base N con a becedario normal**************/
		
		public String transformarDecANabecedario(String numero, int baseOrigen, int baseDestino) {
			 
			    int numeroBase10 = Integer.parseInt(numero, baseOrigen);            // convierte a base 10 cualquier numero en otra base
			    String numeroBaseB = Integer.toString(numeroBase10, baseDestino);   // convierte numeroBase10 a otra base
			    numeroBaseB=numeroBaseB.toUpperCase();
			    return numeroBaseB;
		}
		
		 /**************************TRANSFORMAR UN CARACTER A BASE  10 ************************************************/
		 public int CaracterAB10(String c) {
			 int valorEnBase10=0;
			 
			 for (int i=0;i<abecedario2.length();i++) {
				 if(c.charAt(0)==abecedario2.charAt(i)) {
					 valorEnBase10=i;
				 }
			 }
			 
			 return valorEnBase10;
		 }
	 }
