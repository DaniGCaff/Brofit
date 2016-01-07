package model;

public class Estres{
	
	public static final int  [][][] porcentajePulsaciones_tiempo = {{{65,10},{70,15},{75,20},{75,30},{75,40}},{{65,10},{65,15},{70,20},{70,30},{70,40}},{{50,10},{60,10},{60,15},{60,25},{60,30}},{{40,5},{40,10},{50,10},{60,10},{60,15}}} ;
	public static final float  [][]co_progreso = {{1.1f,1.15f,1.2f,1.3f,1.4f},{1.1f,1.15f,1.2f,1.25f,1.35f},{1.1f,1.15f,1.175f,1.2f,1.275f},{1.1f,1.125f,1.15f,1.175f,1.2f}} ;
	public static final float  [][]estres_aerobico = {{5,7,9,11,13},{5,6,8,10,12},{3,4,5,7,8},{1,2,3,4,5}} ;
	public static final float  []estres_an_inf = {2.6f,5.2f,7.8f,10.4f,13f} ;
	public static final float  []estres_an_sup = {18.2f,36.4f,54.6f,72.8f,91f} ;
	public static final float  []estres_an_ab = {2.6f,5.2f,7.8f,10.4f,13f} ;
	


	public static float getCoProgreso(int imc , int pAE){
		return co_progreso[imc][pAE];
	}
	public static float getEstresAerobico(int imc , int pAE){
		return estres_aerobico[imc][pAE];
	}
	public static float getEstresAnInf(int clasificacion){
		return estres_an_inf[clasificacion];
	}
	public static float getEstresAnSup(int clasificacion){
		return estres_an_sup[clasificacion];
	}
	public static float getEstresAnAb(int clasificacion){
		return estres_an_ab[clasificacion];
	}
	public static int[] getPorcentajePulTiempo(int imc,int pAE){
		return porcentajePulsaciones_tiempo[imc][pAE];
	}
	
}
