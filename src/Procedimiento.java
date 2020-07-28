import java.util.Scanner;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Procedimiento {
	
	//private String Lcaptura="";
	private int importe;
	private int llaveSecreta;
	private String subCadenaA;
	private Convertidor b = new Convertidor();
	private String primeros18a10="";
	private int suma=0;
	private int resModulo;
	private int sumaYanio;
	private String numFin="";
	private String CadenaTotal="";
	private String MensajeAnio="";
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	private int Serie[]= {11,13,17,19,23};
	//Contructor
	public Procedimiento() {
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
		
	
		Scanner entrada=new Scanner(System.in);
		String e1;
		int resultado =0;
		
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
		String aux= b.getsCadena().substring(0,13)+subCadenaA;
		
		//Sin 5C: Sustituimos SubCadena en la linea de Captura
		//String aux= b.getsCadena().substring(0,13)+subCadenaA+"--";
		subCadenaA=aux;
		System.out.println("Sustitucion de la linea de captura con Subcadena A: "+subCadenaA+b.getsCadena().substring(18,20));
		
		return subCadenaA;
		
	}

	public void LineaDeCapturaBase() { 
		
		String CadenaAConvertir=realizarOperación().substring(0,18);
		String c1="";
		int j=0;
		for(int i =CadenaAConvertir.length()-1; i>=0;i--) {
			c1 = Character.toString(CadenaAConvertir.charAt(i));
			//System.out.println(c1);
			primeros18a10+=(int)b.CaracterAB10(c1);
			//(int)b.convierteUnCaracterAB10(c1);
			if(j<=4) {
				suma+=(int)b.CaracterAB10(c1)*Serie[j];
				//System.out.println((int)b.CaracterAB10(c1)*Serie[j]);
				//System.out.println("El valor decimal es: "+b.CaracterAB10(c1));
				j++;
			}else {
				j=0;
				suma+=(int)b.CaracterAB10(c1)*Serie[j];
				//System.out.println((int)b.CaracterAB10(c1)*Serie[j]);
				j++;
				//System.out.println("El valor decimal es: "+b.CaracterAB10(c1));
			}
			
		}
		
		int anio=2007;
		sumaYanio=suma+anio;
		int mod=887;
		resModulo=sumaYanio%mod;
		String aux=""+(int)resModulo;
		numFin=b.transformarDecANabecedario(aux, 10, 30);
		CadenaTotal= subCadenaA;
		if(b.getsCadena().substring(18,20).equals(numFin)) {
			MensajeAnio="La linea de captura valido";
			System.out.println("VALIDO");
			String b =realizarOperación().substring(13,15); 
			//String b="NC";
			int row=0,column=0,position=0;
			
			String [][] matrix= {
	{"AA","AB","AC","AD","AE","AF","AH","AJ","AK","AM","AN","AP","AQ","AR","AS","AT","AU","AV","AW","AX","AY","BA","BB","BC","BD","BE","BF","BH","BJ","BK","BM"},
	{"BP","BQ","BR","BT","BU","BV","BW","BX","BY","CA","CB","CC","CD","CE","CF","CH","CJ","CK","CM","CN","CP","CQ","CR","CT","CU","CV","CW","CX","CY","    ","    "},
	{"DC","DD","DE","DF","DH","DJ","DK","DM","DN","DP","DQ","DR","DT","DU","DV","DW","DX","DY","EA","EB","EC","ED","EE","EF","EH","EJ","EK","EM","EN","EP","EQ"},
	{"ER","ET","EU","EV","EW","EX","EY","FA","FB","FC","FD","FE","FF","FH","FJ","FK","FM","FN","FP","FQ","FR","FT","FU","FV","FW","FX","FY","HA","HB","HC","    "},
	{"HE","HF","HH","HJ","HK","HM","HN","HP","HQ","HR","HT","HU","HV","HW","HX","HY","JA","JB","JC","JD","JE","JF","JH","JJ","JK","JM","JN","JP","JQ","JR","JT"},
	{"JU","JV","JW","JX","JY","KA","KB","KC","KD","KE","KF","KH","KJ","KK","KM","KN","KP","KQ","KR","KT","KU","KV","KW","KX","KY","MA","MB","MC","MD","ME",""},
	{"MH","MJ","MK","MM","MN","MP","MQ","MR","MT","MU","MV","MW","MX","MY","NA","NB","NC","ND","NE","NF","NH","NJ","NK","NM","NN","NP","NQ","NR","NT","NU","NV"},
	{"NW","NX","NY","PA","PB","PC","PD","PE","PF","PH","PJ","PK","PM","PN","PP","PQ","PR","PT","PU","PV","PW","PX","PY","QA","QB","QC","QD","QE","QF","QH","QJ"},
	{"QK","QM","QN","QP","QQ","QR","QT","QU","QV","QW","QX","QY","RA","RB","RC","RD","RE","RF","RH","RJ","RK","RM","RN","RP","RQ","RR","RT","RU","TV","TW",""},
	{"RY","TA","TB","TC","TD","TE","TF","TH","TJ","TK","TM","TN","TP","TQ","TR","TT","TU","TV","TW","TX","TY","UA","UB","UC","UD","UE","UF","UH","UJ","UK","UM"},
	{"UN","UP","UQ","UR","UT","UU","UV","UW","UX","UY","VA","VB","VC","VD","VE","VF","VH","VJ","VK","VM","VN","VP","VQ","VR","VT","VU","VV","VW","UX","UY",""},
	{"WB","WC","WD","WE","WF","WH","WJ","WK","WM","WN","WP","WQ","WR","WT","WU","WV","WW","WX","WY","XA","XB","XC","XD","XE","XF","XH","XJ","XK","JM","JN","JP"}
			} ;
		
			
			for(String []fila:matrix) {
			//	System.out.println();
				for(String z: fila) {
				//	System.out.print(z +" ");
				}
			}
			
			
			int count=1;
			for(int k=0;k<matrix.length;k++) {
				for(int l=0;l<matrix[k].length;l++) {
					if(matrix[k][l].equals(b)) {
						position=count;
						row=k;
						column=l;
					}
					count++;
				}
			}
			
			
			if(position>=1) {
				System.out.println();
				//System.out.println("The position "+position+" in array");
				//System.out.println("Month "+(row+1)+" day "+(column+1));
				 
			}else {
				System.out.println("poop");
			}
				
		
	        String dateInString = (column+1)+"/0"+(row+1)+"/2020"; 
	        String string1 = "17/07/2020";

	    
	        try {

	            Date date = formatter.parse(dateInString);
	            Date date1 = formatter.parse(string1);
	            formatter.format(date1);
	            //System.out.println(date);
	           // System.out.println("The DATE date of the system is: "+formatter.format(date1));
	            System.out.println("DATE:  "+formatter.format(date1));
	            System.out.println("La fecha de Expiracion: "+formatter.format(date));
	            if(date1.before(date) || string1.equals(dateInString)){
	            	//System.out.println("The date is valid to make the payment");
	            	System.out.println("Fecha valida");
	            }else {
	            	//System.out.println("The date expired");
	            	System.out.println("Fecha expirada");
	            }
	            
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }	
		}else {
			//MensajeAnio="La linea de captura no es vaido";
        	System.out.println("La linea de captura no es valido");
		}
	
		
	}

	
	
	
	
	
	/*public String toString() {
		return "\n***************************\n"+
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